package by.vorobyov.training.database.creator.impl;

import by.vorobyov.training.database.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserTaskColumnName;
import by.vorobyov.training.database.dao.util.columnname.WorkGroupColumnName;
import by.vorobyov.training.entity.User;
import by.vorobyov.training.entity.UserTask;
import by.vorobyov.training.entity.WorkGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserTaskCreator  implements ICreator<UserTask> {
    public UserTaskCreator() {
    }

    @Override
    public List<UserTask> createEntityList(ResultSet resultSet) throws SQLException {
        List<UserTask> userTaskList = new LinkedList<>();

        while (resultSet.next()) {
            UserTask userTask = createEntity(resultSet);
            userTaskList.add(userTask);
        }

        return userTaskList;
    }

    @Override
    public UserTask createEntity(ResultSet resultSet) throws SQLException {
        UserTask userTask = new UserTask();

        userTask.setUserTaskId(resultSet.getInt(UserTaskColumnName.ID));
        userTask.setUserId(resultSet.getInt(UserTaskColumnName.USER_ID));
        userTask.setTaskId(resultSet.getInt(UserTaskColumnName.TASK_ID));
        userTask.setCreationTime(resultSet.getInt(UserTaskColumnName.CREATION_TIME));
        userTask.setDeadLine(resultSet.getInt(UserTaskColumnName.DEADLINE));
        userTask.setStatus(resultSet.getInt(UserTaskColumnName.STATUS));
        userTask.setWorkGroup(resultSet.getInt(UserTaskColumnName.WORK_GROUP_ID));

        return userTask;
    }
}
