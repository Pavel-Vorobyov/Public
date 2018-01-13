package by.vorobyov.training.database.dao;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.database.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<E> {

    public abstract List<E> getAll() throws DAOException, SQLException;
    public abstract E update(E entity) throws DAOException;
    public abstract E getEntityById(Integer entityId) throws DAOException;
    public abstract boolean delete(E entity) throws DAOException;
    public abstract boolean create(E entity) throws DAOException;

    public void rollback(Connection connection) throws DAOException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DAOException("Transaction hasn't benn rolled back!");
        }
    }

    public Connection getConnection() throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        return connection;
    }

    public Statement getStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        return statement;
    }

    public PreparedStatement getPreparedStatement(Connection connection, String sqlRequest) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
        return preparedStatement;
    }

    public void closeConnection(Connection connection) throws DAOException {
        if (connection != null) {
            ConnectionPool.getInstance().close(connection);
        } else {
            throw new DAOException("Connection is null!");
        }
    }

    public void closeStatement(Statement statement) throws DAOException, SQLException {
        if (statement != null) {
            statement.close();
        } else {
            throw new DAOException("Statement is null!");
        }
    }

    public void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException, DAOException {
        if (preparedStatement != null) {
            preparedStatement.close();
        } else {
            throw new DAOException("PreparedStatement is null!");
        }
    }
}
