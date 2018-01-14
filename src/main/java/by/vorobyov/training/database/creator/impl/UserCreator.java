package by.vorobyov.training.database.creator.impl;

import by.vorobyov.training.database.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.database.dao.util.columnname.UserDataColumnName;
import by.vorobyov.training.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserCreator implements ICreator<User> {
    public UserCreator() {
    }

    @Override
    public List<User> createEntityList(ResultSet resultSet) throws SQLException {
        List<User> usersList = new LinkedList<>();

        while (resultSet.next()) {
            User user = createEntity(resultSet);
            usersList.add(user);
        }

        return usersList;
    }

    @Override
    public User createEntity(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt(UserColumnName.ID));
        user.setStatus(resultSet.getInt(UserColumnName.STATUS));
        user.setUserName(resultSet.getString(UserDataColumnName.NAME));
        user.setUserSurname(resultSet.getString(UserDataColumnName.SURNAME));
        user.setUserEmail(resultSet.getString(UserDataColumnName.EMAIL));
        user.setCreationTime(resultSet.getInt(UserDataColumnName.CREATION_TIME));
        user.setDescription(resultSet.getString(UserDataColumnName.DESCRIPTION));

        return user;
    }
}
