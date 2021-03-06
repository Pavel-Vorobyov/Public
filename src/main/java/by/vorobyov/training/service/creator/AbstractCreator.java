package by.vorobyov.training.service.creator;

import by.vorobyov.training.exception.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Makes a base realization of the method that
 * creates a list of entity.
 *
 * @param <E> a type of some entity.
 */
public abstract class AbstractCreator<E> implements ICreator<E> {
    @Override
    public List<E> createEntityList(ResultSet resultSet) throws DAOException {
        List<E> entityList = new LinkedList<>();

        try {
            if (resultSet.next()) {
                do {
                    E entity = createEntity(resultSet);
                    entityList.add(entity);
                } while (resultSet.next());
            } else {
                return Collections.emptyList();
            }
            return entityList;

        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public abstract E createEntity(ResultSet resultSet) throws SQLException;
}
