package by.vorobyov.training.service.creator.impl.entitycreator;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserDataColumnName;
import by.vorobyov.training.dto.entity.UserData;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Crate an list of
 * {@link by.vorobyov.training.dto.entity.UserData UserData} or just a UserData.
 *
 * @see by.vorobyov.training.service.creator.AbstractCreator AbstractEntityCreator
 * @see by.vorobyov.training.service.creator.ICreator ICreator
 */
public class UserDataCreator extends AbstractCreator<UserData> implements ICreator<UserData> {
    @Override
    public UserData createEntity(ResultSet resultSet) throws SQLException {
        UserData userData = new UserData();

        userData.setUserId(resultSet.getInt(UserDataColumnName.USER_ID));
        userData.setName(resultSet.getString(UserDataColumnName.NAME));
        userData.setSurname(resultSet.getString(UserDataColumnName.SURNAME));
        userData.setCreationTime(resultSet.getString(UserDataColumnName.CREATION_TIME));
        userData.setDescription(resultSet.getString(UserDataColumnName.DESCRIPTION));

        return userData;
    }
}
