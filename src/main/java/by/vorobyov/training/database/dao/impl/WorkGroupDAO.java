package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.UserCreator;
import by.vorobyov.training.creator.impl.entitycreator.WorkGroupCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.IDAO;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.DAOException;

import java.sql.*;
import java.util.List;

public class WorkGroupDAO extends AbstractDAO<WorkGroup> implements IDAO<WorkGroup> {
    public static final String SELECT_USER_ID_BY_GROUP_ID = "SELECT user.id, user.login, user.password, user.email, user.mail_confirmed, user.status" +
            " FROM user_has_work_group, user" +
            " WHERE user.id = user_has_work_group.user_id AND user_has_work_group.work_group_id = ?";

    public static final String SELECT_WORK_GROUP_BY_USER_ID = "SELECT work_group.id, work_group.title, work_group.description, work_group.course_id, work_group.lead_id" +
            " , work_group.status, work_group.type, work_group.region" +
            " FROM work_group, user_has_work_group" +
            " WHERE work_group.id = user_has_work_group.work_group_id AND user_has_work_group.user_id = ?";;

    public static final String INSERT_WORK_GROUP = "INSERT INTO work_group (title, description, lead_id, course_id, " +
            " status, type, region) VALUES (?,?,?,?,?,?,?)";

    public final static String UPDATE_WORK_GROUP_BY_ID = "UPDATE work_group" +
            " SET work_group.title = ?, work_group.description = ?, work_group.status = ?" +
            " , work_group.type = ?, work_group.region = ?, work_group.course_id = ?, work_group.lead_id = ?" +
            " WHERE work_group.id = ?";

    public final static String DELETE_WORK_GROUP_BY_ID = "DELETE FROM work_group WHERE id = ?";

    public final static String SELECT_WORK_GROUP_BY_ID = "SELECT * FROM work_group WHERE id = ?";

    public final static String SELECT_WORK_GROUP_BY_LEAD_ID = "SELECT * FROM work_group WHERE lead_id = ?";



    @Override
    public boolean update(WorkGroup entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(UPDATE_WORK_GROUP_BY_ID);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getStatus());
            preparedStatement.setString(4, entity.getType());
            preparedStatement.setString(5, entity.getRegion());
            preparedStatement.setInt(6, entity.getCourseId());
            preparedStatement.setInt(7, entity.getLeadId());
            preparedStatement.setInt(8, entity.getWorkGroupId());

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
    public WorkGroup getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_WORK_GROUP_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? workGroupCreator.createEntity(resultSet) : WorkGroup.emptyEntity();

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(WorkGroup entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(DELETE_WORK_GROUP_BY_ID);
            preparedStatement.setInt(1, entity.getWorkGroupId());

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

    @Override
    public boolean create(WorkGroup entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(INSERT_WORK_GROUP);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getLeadId());
            preparedStatement.setInt(4, entity.getCourseId());
            preparedStatement.setInt(5, entity.getStatus());
            preparedStatement.setString(6, entity.getType());
            preparedStatement.setString(7, entity.getRegion());

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

    public List<WorkGroup> getWorkGroupListByLeadId(Integer leadId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_WORK_GROUP_BY_LEAD_ID);
            preparedStatement.setInt(1, leadId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return workGroupCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<User> getUserListByGroupId(Integer groupId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserCreator userCreator = new UserCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_ID_BY_GROUP_ID);
            preparedStatement.setInt(1, groupId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return userCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<WorkGroup> getWorkGroupByUserId(Integer userId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_WORK_GROUP_BY_USER_ID);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return workGroupCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<WorkGroup> getGroupListBySQLRequest(String sqlRequest) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(sqlRequest);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return workGroupCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<WorkGroup> getWorkGroupByLeadId(Integer leadId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_WORK_GROUP_BY_LEAD_ID);
            preparedStatement.setInt(1, leadId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return workGroupCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
