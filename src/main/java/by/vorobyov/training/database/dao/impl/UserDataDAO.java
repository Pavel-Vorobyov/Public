package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.UserDataCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.UserDataQuery;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDataDAO extends AbstractDAO<UserData> {
    @Override
    public List<UserData> getAll() throws DAOException, SQLException {
//        Connection connection = getConnection();
//        Statement statement = null;
//
//        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//        connection.setAutoCommit(false);
//
//        try {
//            statement = connection.createStatement();
//            statement.execute(UserDataQuery.ALL_USER_DATA_SELECT);
//
//        }
        return null;
    }

    @Override
    public boolean update(UserData entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserDataQuery.UPDATE_USER_DATA_BY_USER_ID);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getCreationTime());
            preparedStatement.setString(4, entity.getDescription());
            preparedStatement.setInt(5, entity.getUserId());

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
    public UserData getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserDataCreator userDataCreator = new UserDataCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserDataQuery.SELECT_USER_DATA_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            if (resultSet.next()) {
                return userDataCreator.createEntity(resultSet);
            } else {
                return UserData.emptyUserData(); //Залогировать!!!!!!
            }
        } catch (SQLException e) {
            rollback(connection);
            System.out.println(e);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(UserData entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserDataQuery.DELETE_USER_DATA_BY_ID);
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
    public boolean create(UserData entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(UserDataQuery.INSERT_USER_DATA);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setString(4, entity.getCreationTime());
            preparedStatement.setString(5, entity.getDescription());

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
}
