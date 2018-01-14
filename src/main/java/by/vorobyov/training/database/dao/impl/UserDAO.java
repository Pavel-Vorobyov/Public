package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.database.creator.impl.AccountCreator;
import by.vorobyov.training.database.creator.impl.UserCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.UserDataQuery;
import by.vorobyov.training.database.dao.preparedquery.UserQuery;
import by.vorobyov.training.database.exception.DAOException;
import by.vorobyov.training.entity.Account;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO<Account> {
    public static final Integer START_STATUS_VALUE = 0;
    public static final Integer END_STATUS_VALUE = 1;

    @Override
    public List<Account> getAll() throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        AccountCreator accountCreator = new AccountCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_STATUS_BETWEEN);

            preparedStatement.setInt(1, START_STATUS_VALUE);
            preparedStatement.setInt(2, END_STATUS_VALUE);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet != null ? accountCreator.createEntityList(resultSet) : null;

        } catch (SQLException  e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean update(Account entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.UPDATE_USER_BY_ID);
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getStatus());
            preparedStatement.setInt(4, entity.getAccountId());

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
    public Account getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        AccountCreator accountCreator = new AccountCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            if (resultSet != null) {
                return accountCreator.createEntity(resultSet);
            } else {
                throw new DAOException("ResultSet is null! -> UserQuery.SELECT_USER_BY_ID ");
            }
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(Account entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.DELETE_USER_BY_ID);

            preparedStatement.setInt(1, entity.getAccountId());

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
    public boolean create(Account entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.INSERT_USER);

            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getStatus());

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

    public List<Account> getAccountListByStatus(Integer status) throws SQLException, DAOException {
        return getAccountListByStatus(status, status);
    }

    public List<Account> getAccountListByStatus(Integer firstStatus, Integer secondStatus) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        AccountCreator accountCreator = new AccountCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_STATUS_BETWEEN);
            preparedStatement.setInt(1, firstStatus);
            preparedStatement.setInt(2, secondStatus);

            resultSet = preparedStatement.executeQuery();
            connection.commit();

            if (resultSet != null) {
                return accountCreator.createEntityList(resultSet);
            } else {
                throw new DAOException("ResultSet is null! -> UserQuery.SELECT_USER_BY_ID ");
            }
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
