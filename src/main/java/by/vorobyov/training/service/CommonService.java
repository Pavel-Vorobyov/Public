package by.vorobyov.training.service;

import by.vorobyov.training.database.dao.impl.*;
import by.vorobyov.training.dto.TeachingUserTask;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.ServiceException;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonService {
    public static final String DESCRIPTION_STUDENT = "Student";

    public User checkUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {

            return userDAO.getUserByLogPass(user);

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

    public List<TeachingUserTask> takeTeacherUserTask(Integer taskId, Integer groupId) throws ServiceException {
        TaskDAO taskDAO = new TaskDAO();

        try {
            return taskDAO.getUserTaskListByTaskId(taskId, groupId);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }


    public User addUser(User user) throws ServiceException {
        UserDataDAO userDataDAO = new UserDataDAO();
        UserDAO userDAO = new UserDAO();

        try {
            User checkingUser = new User();

            checkingUser.setLogin(user.getLogin());
            checkingUser.setEmail(user.getEmail());

            checkingUser = userDAO.getUserByLogEmail(checkingUser);

            if (checkingUser.isEmpty()) {
                User currentUser = new User();

                currentUser.setLogin(user.getLogin());
                currentUser.setPassword(user.getPassword());
                currentUser.setEmail(user.getEmail());

                boolean createUserSuccess = userDAO.create(currentUser);

                if (createUserSuccess) {
                    UserData currentUserData = new UserData();
                    currentUser = userDAO.getUserByLogPass(user);

                    String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                    currentUserData.setUserId(currentUser.getUserId());
                    currentUserData.setCreationTime(currentDate);
                    currentUserData.setDescription(DESCRIPTION_STUDENT);

                    return userDataDAO.create(currentUserData) ? currentUser : User.emptyUser();
                }
            }

            return User.emptyUser();

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

    public List<Task> takeGroupTaskListByGroupId(Integer groupId) throws ServiceException {
        TaskDAO taskDAO = new TaskDAO();

        try {
            return taskDAO.getGroupTaskByGroupId(groupId);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public UserTask takeUserTaskById(Integer userTaskId) throws ServiceException {
        UserTaskDAO userTaskDAO = new UserTaskDAO();

        try {
            return userTaskDAO.getEntityById(userTaskId);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }


}
