package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.service.creator.impl.UserForAdminCreator;
import by.vorobyov.training.service.creator.impl.entitycreator.UserDataCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.IDAO;
import by.vorobyov.training.dto.UserForAdmin;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDataDAO extends AbstractDAO<UserData> implements IDAO<UserData> {

    public static final String SELECT_USER_DATA_BY_GROUP_ID = "SELECT user_data.user_id,user_data.name, user_data.surname,user_data.creationtime, user_data.description" +
            " FROM user_data, user_has_work_group, work_group" +
            " WHERE user_data.user_id = user_has_work_group.user_id AND user_has_work_group.work_group_id = ? GROUP BY user_data.user_id";

    public static final String SELECT_USER_DATA_BY_USER_ID = "SELECT *" +
            " FROM user_data" +
            " WHERE user_id = ?";

    public static final String SELECT_USER_DATA_BY_STATUS = "SELECT user.id, user.email, user.status, user_data.name, user_data.surname, user_data.creationtime" +
            " FROM user, user_data" +
            " WHERE user_data.user_id = user.id AND user.status = ?";

    public static final String INSERT_USER_DATA = "INSERT INTO user_data (user_id, creationtime, description) VALUES (?,?,?)";

    public final static String UPDATE_USER_DATA_BY_USER_ID = "UPDATE user_data SET name = ?, surname = ?, creationtime = ?, description = ?" +
            " WHERE user_id = ?";

    public final static String SELECT_USER_DATA_BY_ID = "SELECT * FROM user_data WHERE user_id = ?";

    public final static String DELETE_USER_DATA_BY_ID = "DELETE FROM user_data WHERE id = ?";

    public final static String SELECT_ALL_USER_DATA_BY_STATUS_BETWEEN = "SELECT id, status, name, surname, creationtime, description" +
            " FROM user_data, user" +
            " WHERE user.id = user_data.user_id and user.status BETWEEN ? AND ?";

    public final static String SELECT_ALL_USER_DATA_BY_USER_ID = "SELECT user.id, user.status, user_data.name, user_data.surname, user_data.email, user_data.creationtime, user_data.description" +
            " FROM user, user_data WHERE user_data.user_id = user.id AND user.id = ?";

    public final static String SELECT_USER_DATA_BY_WORK_GROUP_ID = "SELECT user.id, user.status, user_data.name, user_data.surname, user_data.email, user_data.creationtime, user_data.description" +
            " FROM user, user_data, user_has_group" +
            " WHERE user_data.user_id = user.id" +
            "      AND user.id = user_has_group.user_id" +
            "      AND user_has_group.work_group_id = ?";

    public final static String SELECT_ALL_USER_DATA = "SELECT * FROM user_data";


    @Override
    public boolean update(UserData entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER_DATA_BY_USER_ID);
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
            preparedStatement = connection.prepareStatement(SELECT_USER_DATA_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? userDataCreator.createEntity(resultSet) : UserData.emptyUserData();

        } catch (SQLException e) {
            rollback(connection);
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
            preparedStatement = connection.prepareStatement(DELETE_USER_DATA_BY_ID);
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
            preparedStatement = connection.prepareStatement(INSERT_USER_DATA);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setString(2, entity.getCreationTime());
            preparedStatement.setString(3, entity.getDescription());

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

    public List<UserData> getUserDataByWorkGroupId(Integer workGroupId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserDataCreator userDataCreator = new UserDataCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_DATA_BY_GROUP_ID);
            preparedStatement.setInt(1, workGroupId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return userDataCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public UserData getUserDataByUserId(Integer userId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserDataCreator userDataCreator = new UserDataCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_DATA_BY_USER_ID);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? userDataCreator.createEntity(resultSet) : UserData.emptyUserData();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<UserForAdmin> getUserDataListByStatus(Integer userStatus) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserForAdminCreator userForAdminCreator = new UserForAdminCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_DATA_BY_STATUS);
            preparedStatement.setInt(1, userStatus);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return userForAdminCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
