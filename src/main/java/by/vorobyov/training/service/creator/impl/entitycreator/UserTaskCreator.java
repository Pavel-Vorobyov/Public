package by.vorobyov.training.service.creator.impl.entitycreator;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.entity.UserTask;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Crate an list of
 * {@link by.vorobyov.training.dto.entity.UserTask UserTask} or just a UserTask.
 *
 * @see by.vorobyov.training.service.creator.AbstractCreator AbstractEntityCreator
 * @see by.vorobyov.training.service.creator.ICreator ICreator
 */
public class UserTaskCreator extends AbstractCreator<UserTask> implements ICreator<UserTask> {
    @Override
    public UserTask createEntity(ResultSet resultSet) throws SQLException {
        UserTask userTask = new UserTask();

        userTask.setUserTaskId(resultSet.getInt(UserTaskColumnName.ID));
        userTask.setUserId(resultSet.getInt(UserTaskColumnName.USER_ID));
        userTask.setTaskId(resultSet.getInt(UserTaskColumnName.TASK_ID));
        userTask.setTaskTitle(resultSet.getString(UserTaskColumnName.TASK_TITLE));
        userTask.setCreationTime(resultSet.getString(UserTaskColumnName.CREATION_TIME));
        userTask.setDeadline(resultSet.getString(UserTaskColumnName.DEADLINE));
        userTask.setEstimate(resultSet.getInt(UserTaskColumnName.ESTIMATE));
        userTask.setStatus(resultSet.getInt(UserTaskColumnName.STATUS));
        userTask.setWorkGroupId(resultSet.getInt(UserTaskColumnName.WORK_GROUP_ID));
        userTask.setComment(resultSet.getString(UserTaskColumnName.COMMENT));

        return userTask;
    }
}
