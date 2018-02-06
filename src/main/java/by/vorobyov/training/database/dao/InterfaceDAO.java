package by.vorobyov.training.database.dao;

import by.vorobyov.training.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Interface for DAO classes. Lists a number of methods that provided
 * an access to data in database.
 *
 * @param <E> Entity class containing all data from table in database.
 */
public interface InterfaceDAO<E> {

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
