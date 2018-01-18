package by.vorobyov.training.service;

import by.vorobyov.training.database.dao.impl.CourseDAO;
import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.database.dao.impl.UserDataDAO;
import by.vorobyov.training.database.dao.impl.WorkGroupDAO;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.ServiceException;

import java.sql.*;
import java.util.List;

public class CommonService {

    public User checkUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {

            User checkedUser = userDAO.getUserByLogPass(user);
            return checkedUser;

        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean addUserData(UserData userData) throws ServiceException {
        UserDataDAO userDataDAO = new UserDataDAO();

        try {

            return userDataDAO.create(userData);

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public UserData getUserDataById(Integer userId) throws ServiceException {
        UserDataDAO userDataDAO = new UserDataDAO();

        try {

            UserData userData = userDataDAO.getEntityById(userId);
            return userData;

        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public boolean addUser(User user) throws ServiceException {
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

    public List<Course> takeCourseListByStatus(Integer status) throws ServiceException {
        CourseDAO courseDAO = new CourseDAO();

        try {
            return courseDAO.getCourseListByStatus(status);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
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

    public Course takeCourseByCourseId(Integer courseId) throws ServiceException {
        CourseDAO courseDAO = new CourseDAO();

        try {
            return courseDAO.getEntityById(courseId);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<WorkGroup> takeWorkGroupListByLeadId(Integer userId) throws ServiceException{
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();

        try {
            return workGroupDAO.getWorkGroupListByLeadId(userId);
        } catch (SQLException |DAOException e) {
            throw new ServiceException(e);
        }
    }

    public WorkGroup takeWorkGroupById(Integer workGroupId) throws ServiceException {
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();

        try {
            return workGroupDAO.getEntityById(workGroupId);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public List<UserTask> takeUserTaskListByUserId(Integer userId) throws ServiceException{
        return null;
    }
}
