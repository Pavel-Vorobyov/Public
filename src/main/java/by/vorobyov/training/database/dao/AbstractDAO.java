package by.vorobyov.training.database.dao;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<E> {

    public abstract boolean update(E entity) throws DAOException, SQLException;
    public abstract E getEntityById(Integer entityId) throws DAOException, SQLException;
    public abstract boolean delete(E entity) throws DAOException, SQLException;
    public abstract boolean create(E entity) throws DAOException, SQLException;

    public void rollback(Connection connection) throws DAOException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DAOException("Transaction hasn't been rolled back!", e);
        }
    }

    public Connection getConnection() throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        return connection;
    }

    public void closeConnection(Connection connection) throws DAOException {
        if (connection != null) {
            ConnectionPool.getInstance().close(connection);
        } else {
            throw new DAOException("Connection is null!");
        }
    }

    public void closeStatement(Statement statement) throws DAOException {
        try {
            if (statement != null) {
                statement.close();
            } else {
                throw new DAOException("Statement is null!");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void closePreparedStatement(PreparedStatement preparedStatement) throws DAOException {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            } else {
                throw new DAOException("PreparedStatement is null!");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
