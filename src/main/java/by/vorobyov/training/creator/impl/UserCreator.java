package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.dto.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserCreator implements ICreator<User> {
    public UserCreator() {
    }

    @Override
    public List<User> createEntityList(ResultSet resultSet) throws SQLException {
        List<User> userList = new LinkedList<>();

        if (resultSet.next()) {
            do {
                User user = createEntity(resultSet);
                userList.add(user);
            } while (resultSet.next());
            return userList;
        } else {
            return Collections.emptyList();
        }

    }

    @Override
    public User createEntity(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt(UserColumnName.ID));
        user.setLogin(resultSet.getString(UserColumnName.LOGIN));
        user.setPassword(resultSet.getString(UserColumnName.PASSWORD));
        user.setEmail(resultSet.getString(UserColumnName.EMAIL));
        user.setStatus(resultSet.getInt(UserColumnName.STATUS));

        return user;
    }

}
