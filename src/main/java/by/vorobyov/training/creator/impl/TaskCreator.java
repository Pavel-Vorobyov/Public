package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.TaskColumnName;
import by.vorobyov.training.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TaskCreator implements ICreator<Task> {
    @Override
    public List<Task> createEntityList(ResultSet resultSet) throws SQLException {
        List<Task> taskList = new LinkedList<>();

        while (resultSet.next()) {
            Task task = createEntity(resultSet);
            taskList.add(task);
        }

        return taskList;
    }

    @Override
    public Task createEntity(ResultSet resultSet) throws SQLException {
        Task task = new Task();

        task.setTaskId(resultSet.getInt(TaskColumnName.ID));
        task.setTitle(resultSet.getString(TaskColumnName.TITLE));
        task.setDescription(resultSet.getString(TaskColumnName.DESCRIPTION));
        task.setAuthorId(resultSet.getInt(TaskColumnName.AUTHOR_ID));

        return task;
    }
}
