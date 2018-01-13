package by.vorobyov.training.database.service;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.database.creator.*;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.*;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.database.exception.DAOException;
import by.vorobyov.training.entity.*;

import java.sql.*;
import java.util.List;

public class CommonDAO extends AbstractDAO {

//    public Account getAccountByLoginPassword(String login, String password) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        AccountCreator accountCreator = new AccountCreator();
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_BY_ID);
//
//            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, password);
//
//            resultSet = preparedStatement.executeQuery();
//
//            return resultSet != null ? accountCreator.createAccount(resultSet) : null; // resultSet != null ????????
//
//        } catch (SQLException | DAOException e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//        return null;
//    }

    public User singIn(Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserCreator userCreator = new UserCreator();

        try {

            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UserQuery.SELECT_PASSWORD_BY_LOGIN);
            preparedStatement.setString(1, account.getLogin());

            resultSet = preparedStatement.executeQuery();

            if (resultSet != null && account.getPassword() == resultSet.getString(UserColumnName.PASSWORD)) {
                preparedStatement = connection.prepareStatement(UserDataQuery.SELECT_USER_DATA_BY_USER_ID);
                preparedStatement.setInt(1, account.getAccountId());

                resultSet = preparedStatement.executeQuery();

                return userCreator.createUser(resultSet);
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();                        //Залогировать
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
        return null;
    }

    public void addAccount(Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserQuery.INSERT_USER);

            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }

    public void updateAccount(Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserCreator userCreator = new UserCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserQuery.UPDATE_USER_BY_ID);

            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }

    public List<Course> takeCourseList() {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        CourseCreator courseCreator = new CourseCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(CourseQuery.SELECT_ALL_COURSES);

            return resultSet != null ? courseCreator.createCourseList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
        return null;
    }

    public List<Course> takeCourseListByUserId(Integer userId) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        CourseCreator courseCreator = new CourseCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(CourseQuery.SELECT_ALL_COURSES_BY_ID);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            return resultSet != null ? courseCreator.createCourseList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
        return null;
    }

    public List<WorkGroup> takeWorkGroupListByUserId(Integer userId) {
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

    public List<UserTask> takeUserTaskListByUserId(Integer userId) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        UserTaskCreator userTaskCreator = new UserTaskCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserTaskQuery.SELECT_ALL_USER_TASK_BY_USER_ID);

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

    public List<User> takeStudentListByGroupId(Integer workGroupId) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        UserCreator userCreator = new UserCreator();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserDataQuery.SELECT_USER_DATA_BY_WORK_GROUP_ID);

            preparedStatement.setInt(1, workGroupId);

            resultSet = preparedStatement.executeQuery();

            return resultSet != null ? userCreator.createUsersList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
        return null;
    }

    public void updateUserData(User user) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UserDataQuery.UPDATE_USER_DATA_BY_USER_ID);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserSurname());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setInt(4, user.getCreationTime());
            preparedStatement.setString(5, user.getDescription());
            preparedStatement.setInt(6, user.getUserId());

            preparedStatement.executeQuery();

        } catch (SQLException | DAOException e) {
            e.printStackTrace();       //Залогировать
        } finally {
            super.closeStatement(statement);
            super.closeConnection(connection);
        }
    }

}
