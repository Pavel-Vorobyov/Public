package by.vorobyov.training.service;

import by.vorobyov.training.creator.impl.UserCreator1;
import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.creator.impl.CourseCreator;
import by.vorobyov.training.creator.impl.UserTaskCreator;
import by.vorobyov.training.creator.impl.WorkGroupCreator;
import by.vorobyov.training.database.dao.impl.CourseDAO;
import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.database.dao.preparedquery.*;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.entity.*;
import by.vorobyov.training.exception.ServiceException;

import java.sql.*;
import java.util.List;

public class CommonService {

    public User singIn(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {
            User checkedUser = userDAO.getUserByLogPass(user);
            return checkedUser;
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean addAccount(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {
            return userDAO.create(user);
        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public boolean updateAccount(User user) throws ServiceException{
        UserDAO userDAO = new UserDAO();

        try {
            return userDAO.update(user);
        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public List<Course> takeCourseList() throws ServiceException{
        CourseDAO courseDAO = new CourseDAO();

        try {
            return courseDAO.getAll();
        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public List<Course> takeCourseListByUserId(Integer userId) throws ServiceException{
        CourseDAO courseDAO = new CourseDAO();

        try {
            return courseDAO.getCourseListByUserId(userId);
        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public List<WorkGroup> takeWorkGroupListByUserId(Integer userId) throws ServiceException{
        return null;
    }

    public List<UserTask> takeUserTaskListByUserId(Integer userId) throws ServiceException{
        return null;
    }

    public List<User1> takeStudentListByGroupId(Integer workGroupId) throws ServiceException{
        return null;
    }

    public boolean updateUserData(User1 user1) throws ServiceException{
        return false;
    }

}
