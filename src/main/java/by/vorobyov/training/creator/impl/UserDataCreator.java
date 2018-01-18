package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserDataColumnName;
import by.vorobyov.training.dto.entity.UserData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDataCreator implements ICreator<UserData> {
    @Override
    public List<UserData> createEntityList(ResultSet resultSet) throws SQLException {
        List<UserData> userDataList = new LinkedList<>();

        while (resultSet.next()) {
            UserData userData = createEntity(resultSet);
            userDataList.add(userData);
        }

        return userDataList;
    }

    @Override
    public UserData createEntity(ResultSet resultSet) throws SQLException {
        UserData userData = new UserData();

        userData.setUserId(resultSet.getInt(UserDataColumnName.USER_ID));
        userData.setName(resultSet.getString(UserDataColumnName.NAME));
        userData.setSurname(resultSet.getString(UserDataColumnName.SURNAME));
        userData.setCreationTime(resultSet.getInt(UserDataColumnName.CREATION_TIME));
        userData.setDescription(resultSet.getString(UserDataColumnName.DESCRIPTION));

        return userData;
    }
}
