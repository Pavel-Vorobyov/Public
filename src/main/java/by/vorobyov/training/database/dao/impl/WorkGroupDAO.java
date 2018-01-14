package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.WorkGroupCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.WorkGroupQuery;
import by.vorobyov.training.entity.WorkGroup;
import by.vorobyov.training.exception.DAOException;

import java.sql.*;
import java.util.List;

public class WorkGroupDAO extends AbstractDAO<WorkGroup> {
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
            return workGroupCreator.createEntity(resultSet);

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
}
