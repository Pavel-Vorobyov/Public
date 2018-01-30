package by.vorobyov.training.creator.impl.entitycreator;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.entity.UserTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserTaskCreator  implements ICreator<UserTask> {
    public UserTaskCreator() {
    }

    @Override
    public List<UserTask> createEntityList(ResultSet resultSet) throws SQLException {
        List<UserTask> userTaskList = new LinkedList<>();

        if (resultSet.next()) {
            do {
                UserTask userTask = createEntity(resultSet);
                userTaskList.add(userTask);
            } while (resultSet.next());
        } else {
            return Collections.emptyList();
        }

        return userTaskList;
    }

    @Override
    public UserTask createEntity(ResultSet resultSet) throws SQLException {
        UserTask userTask = new UserTask();

        userTask.setUserTaskId(resultSet.getInt(UserTaskColumnName.ID));
        userTask.setUserId(resultSet.getInt(UserTaskColumnName.USER_ID));
        userTask.setTaskId(resultSet.getInt(UserTaskColumnName.TASK_ID));
        userTask.setTaskTitle(resultSet.getString(UserTaskColumnName.TASK_TITLE));
        userTask.setCreationTime(resultSet.getString(UserTaskColumnName.CREATION_TIME));
        userTask.setDeadline(resultSet.getString(UserTaskColumnName.DEADLINE));
        userTask.setStatus(resultSet.getInt(UserTaskColumnName.STATUS));
        userTask.setWorkGroupId(resultSet.getInt(UserTaskColumnName.WORK_GROUP_ID));
        userTask.setComment(resultSet.getString(UserTaskColumnName.COMMENT));

        return userTask;
    }
}