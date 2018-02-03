package by.vorobyov.training.creator;

import by.vorobyov.training.exception.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICreator<E> {

    List<E> createEntityList(ResultSet resultSet) throws DAOException;
    E createEntity(ResultSet resultSet) throws SQLException;

}
