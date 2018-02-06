package by.vorobyov.training.service.creator;

import by.vorobyov.training.exception.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface for creator describes two methods:<br>
 *      that creates a list of entity
 *      and creates a single entity by ResultSet.
 *
 * @param <E> a type of some entity.
 */
public interface ICreator<E> {

    /**
     * Gets a result set and makes a list of entity by
     * adding entity to the LinkedList calling the method createEntity.
     * If resultSet is empty returns an empty list.
     *
     * @param resultSet from database contains entity parameters.
     * @return a list of entity or an empty list.
     * @throws DAOException
     */
    List<E> createEntityList(ResultSet resultSet) throws DAOException;

    /**
     * Gets a result set and makes an entity.
     * If resultSet is empty returns an empty entity.
     *
     * @param resultSet from database contains entity parameters.
     * @return an entity or an empty entity.
     * @throws SQLException
     */
    E createEntity(ResultSet resultSet) throws SQLException;

}
