package by.vorobyov.training.service.creator.impl.entitycreator;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserColumnName;
import by.vorobyov.training.dto.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreator extends AbstractCreator<User> implements ICreator<User> {
    @Override
    public User createEntity(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt(UserColumnName.ID));
        user.setLogin(resultSet.getString(UserColumnName.LOGIN));
        user.setPassword(resultSet.getString(UserColumnName.PASSWORD));
        user.setEmail(resultSet.getString(UserColumnName.EMAIL));
        user.setMailStatus(resultSet.getInt(UserColumnName.MAIL_CONFIRMED));
        user.setStatus(resultSet.getInt(UserColumnName.STATUS));

        return user;
    }

}
