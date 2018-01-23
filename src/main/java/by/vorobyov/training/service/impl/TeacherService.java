package by.vorobyov.training.service.impl;

import by.vorobyov.training.database.dao.impl.TaskDAO;
import by.vorobyov.training.database.dao.impl.UserTaskDAO;
import by.vorobyov.training.database.dao.impl.WorkGroupDAO;
import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;

import java.sql.SQLException;
import java.util.List;

public class TeacherService extends CommonService {
    public static final Integer USER_TASK_MODIFYING_PARAMETER_SIZE = 3;

    public boolean createTask (Task task, Integer groupId) throws ServiceException {
        TaskDAO taskDAO = new TaskDAO();
        UserTaskDAO userTaskDAO = new UserTaskDAO();
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();
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

    public boolean userTaskUpdate(UserTask userTask) throws ServiceException {
        UserTaskDAO userTaskDAO = new UserTaskDAO();

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

}
