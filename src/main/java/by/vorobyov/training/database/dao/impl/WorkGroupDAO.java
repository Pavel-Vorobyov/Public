package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.UserCreator;
import by.vorobyov.training.creator.impl.WorkGroupCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.WorkGroupQuery;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.DAOException;

import java.sql.*;
import java.util.List;

public class WorkGroupDAO extends AbstractDAO<WorkGroup> {
    public static final String SELECT_USER_ID_BY_GROUP_ID = "SELECT user.id, user.login, user.password, user.email, user.status" +
            " FROM user_has_work_group, user" +
            " WHERE user.id = user_has_work_group.user_id AND user_has_work_group.work_group_id = ?";

    @Override
    public List<WorkGroup> getAll() throws DAOException, SQLException {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery(WorkGroupQuery.SELECT_ALL_WORK_GROUPS);
            connection.commit();
            return workGroupCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean update(WorkGroup entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(WorkGroupQuery.UPDATE_WORK_GROUP_BY_ID);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getLeadId());
            preparedStatement.setInt(4, entity.getCourseId());
            preparedStatement.setInt(5, entity.getWorkGroupId());

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
            preparedStatement = connection.prepareStatement(WorkGroupQuery.SELECT_WORK_GROUP_BY_ID);
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
        return false;
    }

    @Override
    public boolean create(WorkGroup entity) throws DAOException, SQLException {
        return false;
    }

    public List<WorkGroup> getWorkGroupListByLeadId(Integer leadId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        WorkGroupCreator workGroupCreator = new WorkGroupCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(WorkGroupQuery.SELECT_WORK_GROUP_BY_LEAD_ID);
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
}
