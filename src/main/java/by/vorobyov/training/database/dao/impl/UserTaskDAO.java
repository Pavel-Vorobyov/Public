package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.UserTaskCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.UserTaskQuery;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.UserTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserTaskDAO extends AbstractDAO<UserTask> {
    public static final String INSERT_USER_TASK = "INSERT INTO user_task (user_id, creationtime, deadline, " +
            " work_group_id, task_id) VALUES ( ?, ?, ?, ?, ? )";

    @Override
    public List<UserTask> getAll() throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean update(UserTask entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(INSERT_USER_TASK);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setString(2, entity.getCreationTime());
            preparedStatement.setString(3, entity.getDeadLine());
            preparedStatement.setInt(4, entity.getWorkGroupId());
            preparedStatement.setInt(5, entity.getTaskId());

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
            preparedStatement = connection.prepareStatement(UserTaskQuery.SELECT_USER_TASK_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();

            if (resultSet != null) {
                return userTaskCreator.createEntity(resultSet);
            } else {
                throw new DAOException("ResultSet is null! -> UserTaskQuery.SELECT_USER_TASK_BY_ID ");
            }
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
            preparedStatement = connection.prepareStatement(UserTaskQuery.DELETE_USER_TASK_BY_ID);
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
            preparedStatement.setString(3, entity.getDeadLine());
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
}
