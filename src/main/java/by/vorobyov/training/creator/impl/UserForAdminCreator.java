package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.database.dao.util.columnname.UserDataColumnName;
import by.vorobyov.training.dto.UserForAdmin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserForAdminCreator implements ICreator<UserForAdmin> {
    @Override
    public List<UserForAdmin> createEntityList(ResultSet resultSet) throws SQLException {
        List<UserForAdmin> userForAdminList = new LinkedList<>();

        if (resultSet.next()) {
            do {
                UserForAdmin userForAdmin = createEntity(resultSet);
                userForAdminList.add(userForAdmin);
            } while (resultSet.next());
        } else {
            return Collections.emptyList();
        }
        return userForAdminList;
    }

    @Override
    public UserForAdmin createEntity(ResultSet resultSet) throws SQLException {
        UserForAdmin userForAdmin = new UserForAdmin();

        userForAdmin.setUserId(resultSet.getInt(UserColumnName.ID));
        userForAdmin.setName(resultSet.getString(UserDataColumnName.NAME));
        userForAdmin.setSurname(resultSet.getString(UserDataColumnName.SURNAME));
        userForAdmin.setCreationTime(resultSet.getString(UserDataColumnName.CREATION_TIME));
        userForAdmin.setEmail(resultSet.getString(UserColumnName.EMAIL));
        userForAdmin.setStatus(resultSet.getInt(UserColumnName.STATUS));

        return userForAdmin;
    }
}