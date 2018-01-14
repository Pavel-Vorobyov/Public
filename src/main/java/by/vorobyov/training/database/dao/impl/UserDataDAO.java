package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.exception.DAOException;
import by.vorobyov.training.entity.User;
import by.vorobyov.training.entity.UserData;

import java.sql.SQLException;
import java.util.List;

public class UserDataDAO extends AbstractDAO<UserData> {
    @Override
    public List<UserData> getAll() throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean update(UserData entity) throws DAOException, SQLException {
        return false;
    }

    @Override
    public UserData getEntityById(Integer entityId) throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean delete(UserData entity) throws DAOException, SQLException {
        return false;
    }

    @Override
    public boolean create(UserData entity) throws DAOException, SQLException {
        return false;
    }
}
