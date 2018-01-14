package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.database.dao.util.columnname.UserDataColumnName;
import by.vorobyov.training.entity.User1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserCreator1 implements ICreator<User1> {
    public UserCreator1() {
    }

    @Override
    public List<User1> createEntityList(ResultSet resultSet) throws SQLException {
        List<User1> usersList = new LinkedList<>();

        while (resultSet.next()) {
            User1 user1 = createEntity(resultSet);
            usersList.add(user1);
        }

        return usersList;
    }

    @Override
    public User1 createEntity(ResultSet resultSet) throws SQLException {
        User1 user1 = new User1();

        user1.setUserId(resultSet.getInt(UserColumnName.ID));
        user1.setStatus(resultSet.getInt(UserColumnName.STATUS));
        user1.setUserName(resultSet.getString(UserDataColumnName.NAME));
        user1.setUserSurname(resultSet.getString(UserDataColumnName.SURNAME));
        user1.setUserEmail(resultSet.getString(UserDataColumnName.EMAIL));
        user1.setCreationTime(resultSet.getInt(UserDataColumnName.CREATION_TIME));
        user1.setDescription(resultSet.getString(UserDataColumnName.DESCRIPTION));

        return user1;
    }
}
