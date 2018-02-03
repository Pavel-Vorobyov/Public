package by.vorobyov.training.creator.impl.entitycreator;

import by.vorobyov.training.creator.AbstractCreator;
import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.TaskColumnName;
import by.vorobyov.training.dto.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TaskCreator extends AbstractCreator<Task> implements ICreator<Task> {
    @Override
    public Task createEntity(ResultSet resultSet) throws SQLException {
        Task task = new Task();

        task.setTaskId(resultSet.getInt(TaskColumnName.ID));
        task.setTitle(resultSet.getString(TaskColumnName.TITLE));
        task.setCreationTime(resultSet.getString(TaskColumnName.CREATION_TIME));
        task.setDeadline(resultSet.getString(TaskColumnName.DEADLINE));
        task.setDescription(resultSet.getString(TaskColumnName.DESCRIPTION));
        task.setAuthorId(resultSet.getInt(TaskColumnName.AUTHOR_ID));

        return task;
    }
}
