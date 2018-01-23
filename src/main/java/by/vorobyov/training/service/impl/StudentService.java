package by.vorobyov.training.service.impl;

import by.vorobyov.training.database.dao.impl.*;
import by.vorobyov.training.dto.StudentGroup;
import by.vorobyov.training.dto.StudentUserTask;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentService extends CommonService {

    public List<StudentUserTask> takeUserTaskByUserId(Integer userId) throws ServiceException {
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();
        UserTaskDAO userTaskDAO = new UserTaskDAO();
        UserDataDAO userDataDAO = new UserDataDAO();
        TaskDAO taskDAO = new TaskDAO();
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
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();
        UserDataDAO userDataDAO = new UserDataDAO();
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

    public boolean userDataUpdate(User user, UserData userData) throws ServiceException {
        UserDataDAO userDataDAO = new UserDataDAO();
        UserDAO userDAO = new UserDAO();

        try {
            User modifyingUser = userDAO.getEntityById(user.getUserId());
            UserData modifyingUserData = userDataDAO.getUserDataByUserId(user.getUserId());

            modifyingUserData.setName(userData.getName());
            modifyingUserData.setSurname(userData.getSurname());

            modifyingUser.setLogin(user.getLogin());
            modifyingUser.setPassword(user.getPassword());
            modifyingUser.setEmail(user.getEmail());

            modifyingUserData.setName(userData.getName());
            modifyingUserData.setSurname(userData.getSurname());

            boolean userUpdateSuccess = userDAO.update(modifyingUser);
            boolean userDataUpdateSuccess = userDataDAO.update(modifyingUserData);

            return userUpdateSuccess && userDataUpdateSuccess ? true : false;

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }
}
