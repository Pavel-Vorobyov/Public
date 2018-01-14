package by.vorobyov.training.database.creator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICreator<E> {

    List<E> createEntityList(ResultSet resultSet) throws SQLException;
    E createEntity(ResultSet resultSet) throws SQLException;

}
