package by.vorobyov.training.service.creator.impl;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserColumnName;
import by.vorobyov.training.database.dao.columnname.UserDataColumnName;
import by.vorobyov.training.dto.UserForAdmin;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Crate an list of
 * {@link by.vorobyov.training.dto.UserForAdmin UserForAdmin} or just a UserForAdmin.
 *
 * @see by.vorobyov.training.service.creator.AbstractCreator AbstractEntityCreator
 * @see by.vorobyov.training.service.creator.ICreator ICreator
 */
public class UserForAdminCreator extends AbstractCreator<UserForAdmin> implements ICreator<UserForAdmin> {
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
