package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserCreator implements ICreator<User> {
    public UserCreator() {
    }

    @Override
    public List<User> createEntityList(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public User createEntity(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setAccountId(resultSet.getInt(UserColumnName.ID));
        user.setLogin(resultSet.getString(UserColumnName.LOGIN));
        user.setPassword(resultSet.getString(UserColumnName.PASSWORD));
        user.setStatus(resultSet.getInt(UserColumnName.STATUS));

        return user;
    }

}
