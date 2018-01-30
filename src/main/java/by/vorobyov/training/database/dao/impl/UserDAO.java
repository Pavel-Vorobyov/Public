package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.UserCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.UserQuery;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    public static final Integer START_STATUS_VALUE = 0;
    public static final Integer END_STATUS_VALUE = 1;
    public static final Integer STATUS_STUDENT = 0;

    public static final String SELECT_USER_BY_STATUS = "SELECT *" +
            " FROM user" +
            " WHERE status = ?";

    public static final String INSERT_USER = "INSERT INTO user (login, password, email, status) VALUES (?,?,?,?)";

    public final static String SELECT_PASSWORD_BY_LOGIN = "SELECT * FROM user WHERE login = ? AND password = ?";

    public static final String SELECT_USER_BY_LOGIN_EMAIL = "SELECT * FROM user WHERE login = ? AND email = ?";


    @Override
    public List<User> getAll() throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_STATUS_BETWEEN);

            preparedStatement.setInt(1, START_STATUS_VALUE);
            preparedStatement.setInt(2, END_STATUS_VALUE);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet != null ? userCreator.createEntityList(resultSet) : null;

        } catch (SQLException  e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean update(User entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.UPDATE_USER_BY_ID);
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getStatus());
            preparedStatement.setInt(4, entity.getUserId());

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
    public User getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? userCreator.createEntity(resultSet) : User.emptyUser();
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(User entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.DELETE_USER_BY_ID);

            preparedStatement.setInt(1, entity.getUserId());

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
    public boolean create(User entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);

            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setInt(4, STATUS_STUDENT);

            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            rollback(connection);
            System.out.println(e);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<User> getAccountListByStatus(Integer status) throws SQLException, DAOException {
        return getAccountListByStatus(status, status);
    }

    public List<User> getAccountListByStatus(Integer firstStatus, Integer secondStatus) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserQuery.SELECT_USER_STATUS_BETWEEN);
            preparedStatement.setInt(1, firstStatus);
            preparedStatement.setInt(2, secondStatus);

            resultSet = preparedStatement.executeQuery();
            connection.commit();

            if (resultSet != null) {
                return userCreator.createEntityList(resultSet);
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

    public User getUserByLogPass(User user) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_PASSWORD_BY_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? userCreator.createEntity(resultSet) : User.emptyUser();
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<User> getUserListByStatus(Integer userStatus) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_STATUS);
            preparedStatement.setInt(1, userStatus);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return userCreator.createEntityList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public User getUserByLogEmail(User user) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN_EMAIL);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getEmail());

            resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? userCreator.createEntity(resultSet) : User.emptyUser();
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
