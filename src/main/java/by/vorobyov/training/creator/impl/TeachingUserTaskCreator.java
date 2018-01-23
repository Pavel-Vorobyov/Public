package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserDataColumnName;
import by.vorobyov.training.database.dao.util.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.TeachingUserTask;
import by.vorobyov.training.dto.entity.UserTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TeachingUserTaskCreator implements ICreator<TeachingUserTask> {
    @Override
    public List<TeachingUserTask> createEntityList(ResultSet resultSet) throws SQLException {
        List<TeachingUserTask> teachingUserTaskList = new LinkedList<>();

        if (resultSet.next()) {
            do {
                TeachingUserTask teachingUserTask = createEntity(resultSet);
                teachingUserTaskList.add(teachingUserTask);
            } while (resultSet.next());
        } else {
            return Collections.emptyList();
        }
        return teachingUserTaskList;
    }

    @Override
    public TeachingUserTask createEntity(ResultSet resultSet) throws SQLException {
        TeachingUserTask teachingUserTask = new TeachingUserTask();

        String studentName = resultSet.getString(UserDataColumnName.NAME) + " "
                + resultSet.getString(UserDataColumnName.SURNAME);
        teachingUserTask.setStudentName(studentName);
        teachingUserTask.setUserTaskId(resultSet.getInt(UserTaskColumnName.ID));
        teachingUserTask.setStartTime(resultSet.getString(UserTaskColumnName.CREATION_TIME));
        teachingUserTask.setDeadline(resultSet.getString(UserDataColumnName.DEADLINE));
        teachingUserTask.setEstimate(resultSet.getInt(UserDataColumnName.ESTIMATE));
        teachingUserTask.setStatus(resultSet.getInt(UserDataColumnName.STATUS));

        return teachingUserTask;
    }
}
