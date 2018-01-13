package by.vorobyov.training.database.creator;

import by.vorobyov.training.database.dao.util.columnname.UserTaskColumnName;
import by.vorobyov.training.database.dao.util.columnname.WorkGroupColumnName;
import by.vorobyov.training.entity.User;
import by.vorobyov.training.entity.UserTask;
import by.vorobyov.training.entity.WorkGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserTaskCreator {
    public UserTaskCreator() {
    }

    public List<UserTask> createUserTaskList(ResultSet resultSet) throws SQLException {
        List<UserTask> userTaskList = new LinkedList<>();

        while (resultSet.next()) {
            UserTask userTask = createUserTask(resultSet);
            userTaskList.add(userTask);
        }

        return userTaskList;
    }

    public UserTask createUserTask(ResultSet resultSet) throws SQLException {
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
