package by.vorobyov.training.service.impl;

import by.vorobyov.training.database.dao.DAOFactory;
import by.vorobyov.training.database.dao.impl.TaskDAO;
import by.vorobyov.training.database.dao.impl.UserDataDAO;
import by.vorobyov.training.database.dao.impl.UserTaskDAO;
import by.vorobyov.training.database.dao.impl.WorkGroupDAO;
import by.vorobyov.training.dto.TeacherGroupTask;
import by.vorobyov.training.dto.TeacherUserTask;
import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.TeacherService;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TeacherServiceImpl extends CommonServiceImpl implements TeacherService {
    public static final Integer USER_TASK_MODIFYING_PARAMETER_SIZE = 3;

    public boolean createTask (Task task, Integer groupId) throws ServiceException {
        TaskDAO taskDAO = DAOFactory.getINSTANCE().getTaskDAO();
        UserTaskDAO userTaskDAO = DAOFactory.getINSTANCE().getUserTaskDAO();
        WorkGroupDAO workGroupDAO = DAOFactory.getINSTANCE().getWorkGroupDAO();
        Task createdTask;

        try {
            boolean taskCreated = taskDAO.create(task);
            boolean flag = false;

            if (taskCreated) {
                createdTask = taskDAO.getTaskByData(task);
                System.out.println(createdTask);
                List<User> userList = workGroupDAO.getUserListByGroupId(groupId);

                for (int i=0; i<userList.size(); i++) {
                    UserTask userTask = new UserTask();

                    userTask.setUserId(userList.get(i).getUserId());
                    userTask.setCreationTime(createdTask.getCreationTime());
                    userTask.setDeadline(createdTask.getDeadline());
                    userTask.setWorkGroupId(groupId);
                    userTask.setTaskId(createdTask.getTaskId());

                    boolean userTaskCreated = userTaskDAO.create(userTask);

                    if (!userTaskCreated) {
                        throw new ServiceException("User task hasn't been created!");
                    }
                }
                flag = true;
            }

            return flag;

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean updateTask(Task task) throws ServiceException {
        TaskDAO taskDAO = DAOFactory.getINSTANCE().getTaskDAO();

        try {
            return taskDAO.update(task);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean userTaskUpdate(UserTask userTask) throws ServiceException {
        UserTaskDAO userTaskDAO = DAOFactory.getINSTANCE().getUserTaskDAO();

        try {
            UserTask modifyingUserTask = userTaskDAO.getEntityById(userTask.getUserTaskId());

            modifyingUserTask.setDeadline(userTask.getDeadline());
            modifyingUserTask.setEstimate(userTask.getEstimate());
            modifyingUserTask.setStatus(userTask.getStatus());
            modifyingUserTask.setComment(userTask.getComment());

            return userTaskDAO.update(modifyingUserTask);

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public List<TeacherGroupTask> takeUserTaskByUserId(Integer userId) throws ServiceException {
        WorkGroupDAO workGroupDAO = DAOFactory.getINSTANCE().getWorkGroupDAO();
        TaskDAO taskDAO = DAOFactory.getINSTANCE().getTaskDAO();
        List<WorkGroup> workGroupList;
        List<TeacherGroupTask> teacherGroupTaskList = new LinkedList<>();

        try {
            workGroupList = workGroupDAO.getWorkGroupByLeadId(userId);

            for (int i=0; i<workGroupList.size(); i++) {
                TeacherGroupTask teacherGroupTask = new TeacherGroupTask();

                List<Task> taskList = taskDAO.getGroupTaskByGroupId(workGroupList.get(i).getWorkGroupId());

                teacherGroupTask.setGroupTitle(workGroupList.get(i).getTitle());
                teacherGroupTask.setGroupId(workGroupList.get(i).getWorkGroupId());
                teacherGroupTask.setTaskList(taskList);

                teacherGroupTaskList.add(teacherGroupTask);
            }
            return teacherGroupTaskList;
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<TeacherUserTask> takeUserTaskList(Integer taskId, Integer groupId) throws DAOException {
        List<TeacherUserTask> teacherUserTaskList = new LinkedList<>();
        UserTaskDAO userTaskDAO = DAOFactory.getINSTANCE().getUserTaskDAO();
        UserDataDAO userDataDAO = DAOFactory.getINSTANCE().getUserDataDAO();

        try {
            List<UserTask> userTaskList = userTaskDAO.getUserTaskByGroupLeadId(taskId, groupId);

            for (int i=0; i<userTaskList.size(); i++) {
                TeacherUserTask teacherUserTask = new TeacherUserTask();

                UserData userData = userDataDAO.getEntityById(userTaskList.get(i).getUserId());
                String studentName = userData.getName() + " " + userData.getSurname();

                teacherUserTask.setUserTaskId(userTaskList.get(i).getUserTaskId());
                teacherUserTask.setStudentName(studentName);
                teacherUserTask.setStartTime(userTaskList.get(i).getCreationTime());
                teacherUserTask.setDeadline(userTaskList.get(i).getDeadline());
                teacherUserTask.setEstimate(userTaskList.get(i).getEstimate());
                teacherUserTask.setStatus(userTaskList.get(i).getStatus());

                teacherUserTaskList.add(teacherUserTask);
            }

            return teacherUserTaskList;
        } catch (SQLException | DAOException e) {
            throw new DAOException(e);
        }
    }
}
