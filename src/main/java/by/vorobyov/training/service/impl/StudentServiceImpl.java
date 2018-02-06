package by.vorobyov.training.service.impl;

import by.vorobyov.training.database.dao.DAOFactory;
import by.vorobyov.training.database.dao.impl.*;
import by.vorobyov.training.dto.StudentGroup;
import by.vorobyov.training.dto.StudentUserTask;
import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.StudentService;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentServiceImpl extends CommonServiceImpl implements StudentService {
    public static final Integer USER_TASK_STATUS_SUBMITTED = 2;
    public static final Integer USER_TASK_STATUS_NOT_READY = 0;

    public List<StudentUserTask> takeUserTaskByUserId(Integer userId) throws ServiceException {
        WorkGroupDAO workGroupDAO = DAOFactory.getINSTANCE().getWorkGroupDAO();
        UserTaskDAO userTaskDAO = DAOFactory.getINSTANCE().getUserTaskDAO();
        UserDataDAO userDataDAO = DAOFactory.getINSTANCE().getUserDataDAO();
        List<StudentUserTask> studentUserTaskList = new LinkedList<>();
        List<WorkGroup> workGroupList;
        List<UserTask> userTaskList;

        try {
            workGroupList = workGroupDAO.getWorkGroupByUserId(userId);

            for (int i=0; i<workGroupList.size(); i++) {
                StudentUserTask studentUserTask = new StudentUserTask();
                UserData userData = userDataDAO.getEntityById(userId);

                userTaskList = userTaskDAO.getUserTaskByGroupUserId(workGroupList.get(i).getWorkGroupId(), userId);

                studentUserTask.setWorkGroupTitle(workGroupList.get(i).getTitle());
                studentUserTask.setUserTaskList(userTaskList);
                studentUserTask.setStudentName(userData.getName() + " " + userData.getSurname());

                studentUserTaskList.add(studentUserTask);
            }
            return studentUserTaskList;
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<StudentGroup> takeStudentGroupByUserId(Integer userId) throws ServiceException {
        WorkGroupDAO workGroupDAO = DAOFactory.getINSTANCE().getWorkGroupDAO();
        UserDataDAO userDataDAO = DAOFactory.getINSTANCE().getUserDataDAO();
        List<StudentGroup> studentGroupList = new LinkedList<>();
        List<WorkGroup> workGroupList;
        List<UserData> userDataList;

        try {
            workGroupList = workGroupDAO.getWorkGroupByUserId(userId);

            for (int i=0; i<workGroupList.size(); i++) {
                StudentGroup studentGroup = new StudentGroup();
                UserData currentUserData = userDataDAO.getEntityById(userId);

                userDataList = userDataDAO.getUserDataByWorkGroupId(workGroupList.get(i).getWorkGroupId());
                userDataList.remove(currentUserData);

                studentGroup.setWorkGroupTitle(workGroupList.get(i).getTitle());
                studentGroup.setUserDataList(userDataList);
                studentGroup.setStudentName(currentUserData.getName() + " " + currentUserData.getSurname());

                studentGroupList.add(studentGroup);
            }
            return studentGroupList;
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean applyForCourse(User student, Integer courseId) throws ServiceException {
        UserHasCourseDAO userHasCourseDAO = DAOFactory.getINSTANCE().getUserHasCourseDAO();

        try {
            UserHasCourse checkingUserHasCourse = userHasCourseDAO.getUerHasCourseById(student.getUserId(), courseId);

            if (checkingUserHasCourse.isEmpty()) {
                checkingUserHasCourse.setUserId(student.getUserId());
                checkingUserHasCourse.setCourseId(courseId);

                return userHasCourseDAO.create(checkingUserHasCourse);
            } else {
                return false;
            }
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean submitTask(Integer userTaskId) throws ServiceException {
        UserTaskDAO userTaskDAO = DAOFactory.getINSTANCE().getUserTaskDAO();

        try {
            UserTask currentUserTask = userTaskDAO.getEntityById(userTaskId);

            if (currentUserTask.getStatus() != USER_TASK_STATUS_NOT_READY) {

                currentUserTask.setStatus(USER_TASK_STATUS_SUBMITTED);
                return userTaskDAO.update(currentUserTask);

            } else {
                return false;
            }

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }
}
