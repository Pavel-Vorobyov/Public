package by.vorobyov.training.database.service.impl;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.database.service.CommonDAO;
import by.vorobyov.training.database.dao.preparedquery.UserHasCourseQuery;
import by.vorobyov.training.database.dao.preparedquery.UserTaskQuery;
import by.vorobyov.training.database.exception.DAOException;
import by.vorobyov.training.entity.Task;
import by.vorobyov.training.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO extends CommonDAO {
    public static final Integer TASK_STATUS_COMPLETE = 1;

//    public User singIn(Account account) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        UserCreator userCreator = new UserCreator();
//
//        try {
//
//            connection = ConnectionPool.getInstance().getConnection();
//
//            preparedStatement = connection.prepareStatement(UserQuery.SELECT_PASSWORD_BY_LOGIN);
//            preparedStatement.setString(1, account.getLogin());
//
//            resultSet = preparedStatement.executeQuery();
//
//            if (resultSet != null && account.getPassword() == resultSet.getString(UserColumnName.PASSWORD)) {
//                preparedStatement = connection.prepareStatement(UserDataQuery.SELECT_USER_DATA_BY_USER_ID);
//                preparedStatement.setInt(1, account.getAccountId());
//
//                resultSet = preparedStatement.executeQuery();
//
//                return userCreator.createUser(resultSet);
//            }
//
//        } catch (SQLException | DAOException e) {
//            e.printStackTrace();                        //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//        return null;
//    }

//    public void register(Account account) {
//        super.addAccount(account);
//    }
//
//    public List<Course> takeCourseList() {
//        return super.takeCourseList();
//    }
//
//    public List<Course> takeCourseListByUserId(Integer userId) {
//        return super.takeCourseListByUserId(userId);
//    }
//
//    public List<WorkGroup> takeWorkGroupByUserId(Integer userId) {
//        return super.takeWorkGroupListByUserId(userId);
//    }
//
//    public List<UserTask> takeUserTaskListById(Integer userId) {
//        return super.takeUserTaskListByUserId(userId);
//    }

    public void applyForCourse(Integer userId, Integer courseId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UserHasCourseQuery.INSERT_USER_HAS_COURSE);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.executeUpdate();

        } catch (SQLException | DAOException e) {
            e.printStackTrace();                        //Залогировать
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }

    public void cancelCourseApplication(Integer userId, Integer courseId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UserHasCourseQuery.DELETED_USER_FROM_COURSE);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.executeUpdate();

        } catch (SQLException | DAOException e) {
            e.printStackTrace();                        //Залогировать
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }

    public void performTask(User user, Task task) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UserTaskQuery.UPDATE_STATUS_BY_ID);
            preparedStatement.setInt(1, TASK_STATUS_COMPLETE);
            preparedStatement.setInt(2, user.getUserId());
            preparedStatement.setInt(3, task.getTaskId());
            preparedStatement.executeUpdate();

            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        } catch (SQLException | DAOException e) {
            e.printStackTrace();                    //Залогировать
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }
}
