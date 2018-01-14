package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.UserTaskCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.UserTaskQuery;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.entity.UserTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserTaskDAO extends AbstractDAO<UserTask> {
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
            preparedStatement = connection.prepareStatement(UserTaskQuery.UPDATE_USER_TASK_BY_ID);
            preparedStatement.setInt(1, entity.getDeadLine());
            preparedStatement.setInt(2, entity.getEstimate());
            preparedStatement.setInt(3, entity.getStatus());
            preparedStatement.setInt(4, entity.getCommentId());
            preparedStatement.setInt(5, entity.getWorkGroupId());
            preparedStatement.setInt(6, entity.getUserTaskId());

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
            preparedStatement = connection.prepareStatement(UserTaskQuery.INSERT_USER_TASK);
            preparedStatement.setInt(1, entity.getCreationTime());
            preparedStatement.setInt(2, entity.getDeadLine());
            preparedStatement.setInt(3, entity.getEstimate());
            preparedStatement.setInt(4, entity.getCommentId());
            preparedStatement.setInt(5, entity.getUserId());
            preparedStatement.setInt(6, entity.getTaskId());
            preparedStatement.setInt(7, entity.getWorkGroupId());

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
