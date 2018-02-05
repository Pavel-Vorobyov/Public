package by.vorobyov.training.creator.impl.entitycreator;

import by.vorobyov.training.creator.AbstractCreator;
import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserHasCourseColumnName;
import by.vorobyov.training.dto.entity.UserHasCourse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHasCourseCreator extends AbstractCreator<UserHasCourse> implements ICreator<UserHasCourse> {
    @Override
    public UserHasCourse createEntity(ResultSet resultSet) throws SQLException {
        UserHasCourse userHasCourse = new UserHasCourse();

        userHasCourse.setUserId(resultSet.getInt(UserHasCourseColumnName.USER_ID));
        userHasCourse.setUserId(resultSet.getInt(UserHasCourseColumnName.COURSE_ID));

        return userHasCourse;
    }
}
