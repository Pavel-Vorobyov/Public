package by.vorobyov.training.database.dao;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDAO<E> {

    boolean update(E entity) throws DAOException, SQLException;

    E getEntityById(Integer entityId) throws DAOException, SQLException;

    boolean delete(E entity) throws DAOException, SQLException;

    boolean create(E entity) throws DAOException, SQLException;

    void rollback(Connection connection) throws DAOException;

    Connection getConnection() throws DAOException;

    void closeConnection(Connection connection) throws DAOException;

    void closeStatement(Statement statement) throws DAOException;

    void closePreparedStatement(PreparedStatement preparedStatement) throws DAOException;

}
