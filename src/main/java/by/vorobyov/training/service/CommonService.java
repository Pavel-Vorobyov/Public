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

    }

    public List<WorkGroup> takeWorkGroupListByUserId(Integer userId) throws ServiceException{
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserHasGroupQuery.SELECT_All_GROUP_BY_USER_ID);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            return resultSet != null ? workGroupCreator.createWorkGroupList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
        return null;
    }

    public List<UserTask> takeUserTaskListByUserId(Integer userId) throws ServiceException{
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        UserTaskCreator userTaskCreator = new UserTaskCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserTaskQuery.SELECT_USER_TASK_BY_ID);

            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            return resultSet != null ? userTaskCreator.createUserTaskList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
        return null;
    }

    public List<User1> takeStudentListByGroupId(Integer workGroupId) throws ServiceException{
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        UserCreator1 userCreator1 = new UserCreator1();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserDataQuery.SELECT_USER_DATA_BY_WORK_GROUP_ID);

            preparedStatement.setInt(1, workGroupId);

            resultSet = preparedStatement.executeQuery();

            return resultSet != null ? userCreator1.createUsersList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
        return null;
    }

    public void updateUserData(User1 user1) throws ServiceException{
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserDataQuery.UPDATE_USER_DATA_BY_USER_ID);

            preparedStatement.setString(1, user1.getUserName());
            preparedStatement.setString(2, user1.getUserSurname());
            preparedStatement.setString(3, user1.getUserEmail());
            preparedStatement.setInt(4, user1.getCreationTime());
            preparedStatement.setString(5, user1.getDescription());
            preparedStatement.setInt(6, user1.getUserId());

            preparedStatement.executeQuery();

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
    }

}
