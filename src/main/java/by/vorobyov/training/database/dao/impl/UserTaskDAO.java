package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.UserTaskCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.UserTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserTaskDAO extends AbstractDAO<UserTask> {
    public final static String SELECT_USER_TASK_BY_ID = "SELECT user_task.id, user_task.user_id, user_task.work_group_id, user_task.status, user_task.estimate" +
            " , user_task.deadline, user_task.task_id, user_task.creationtime, user_task.comment, task.title" +
            " FROM user_task, task" +
            " WHERE task.id = user_task.task_id AND user_task.id = ?";

    public static final String INSERT_USER_TASK = "INSERT INTO user_task (user_id, creationtime, deadline, " +
            " work_group_id, task_id) VALUES ( ?, ?, ?, ?, ? )";

    public static final String UPDATE_USER_TASK_BY_ID = "UPDATE user_task" +
            " SET user_task.deadline = ?, user_task.estimate = ?, user_task.status = ?, user_task.comment = ?" +
            " WHERE user_task.id = ?";

    public static final String SELECT_USER_TASK_BY_GROUP_USER_ID = "SELECT user_task.id, user_task.user_id, user_task.work_group_id, user_task.status, user_task.estimate" +
            " , user_task.deadline, user_task.task_id, user_task.creationtime, user_task.comment, task.title" +
            " FROM user_task, task" +
            " WHERE task.id = user_task.task_id AND user_task.user_id = ? AND user_task.work_group_id = ?";

    public static final String SELECT_USER_TASK_BY_GROUP_TASK_ID = "SELECT user_task.id, user_task.user_id, user_task.work_group_id, user_task.status, user_task.estimate" +
            " , user_task.deadline, user_task.task_id, user_task.creationtime, user_task.comment, task.title" +
            " FROM user_task, task" +
            " WHERE task.id = user_task.task_id AND user_task.task_id = ? AND user_task.work_group_id = ?";

    public final static String DELETE_USER_TASK_BY_ID = "DELETE FROM user_task WHERE id = ?";


    @Override
    public boolean update(UserTask entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER_TASK_BY_ID);
            preparedStatement.setString(1, entity.getDeadline());
            preparedStatement.setInt(2, entity.getEstimate());
            preparedStatement.setInt(3, entity.getStatus());
            preparedStatement.setString(4, entity.getComment());
            preparedStatement.setInt(5, entity.getUserTaskId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public UserTask getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserTaskCreator userTaskCreator = new UserTaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_TASK_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? userTaskCreator.createEntity(resultSet) : UserTask.emptyEntity();

        } catch (SQLException e) {
            rollback(connection);
            throw  new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(UserTask entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(DELETE_USER_TASK_BY_ID);
            preparedStatement.setInt(1, entity.getUserTaskId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean create(UserTask entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER_TASK);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setString(2, entity.getCreationTime());
            preparedStatement.setString(3, entity.getDeadline());
            preparedStatement.setInt(4, entity.getWorkGroupId());
            preparedStatement.setInt(5, entity.getTaskId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<UserTask> getUserTaskByGroupUserId(Integer groupId, Integer userId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserTaskCreator userTaskCreator = new UserTaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_TASK_BY_GROUP_USER_ID);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, groupId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return userTaskCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<UserTask> getUserTaskByGroupLeadId(Integer taskId, Integer groupId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserTaskCreator userTaskCreator = new UserTaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_TASK_BY_GROUP_TASK_ID);
            preparedStatement.setInt(1, taskId);
            preparedStatement.setInt(2, groupId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return userTaskCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
