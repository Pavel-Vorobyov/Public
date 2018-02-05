package by.vorobyov.training.service.creator.impl.entitycreator;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserHasCourseColumnName;
import by.vorobyov.training.dto.entity.UserHasCourse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHasCourseCreator extends AbstractCreator<UserHasCourse> implements ICreator<UserHasCourse> {
    @Override
    public UserHasCourse createEntity(ResultSet resultSet) throws SQLException {
        UserHasCourse userHasCourse = new UserHasCourse();

        userHasCourse.setUserId(resultSet.getInt(UserHasCourseColumnName.USER_ID));
        userHasCourse.setCourseId(resultSet.getInt(UserHasCourseColumnName.COURSE_ID));

        return userHasCourse;
    }
}
