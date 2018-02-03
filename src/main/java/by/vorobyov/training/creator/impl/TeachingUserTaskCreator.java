package by.vorobyov.training.creator.impl;

import by.vorobyov.training.creator.AbstractCreator;
import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserDataColumnName;
import by.vorobyov.training.database.dao.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.TeacherUserTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TeachingUserTaskCreator extends AbstractCreator<TeacherUserTask> implements ICreator<TeacherUserTask> {
    @Override
    public TeacherUserTask createEntity(ResultSet resultSet) throws SQLException {
        TeacherUserTask teacherUserTask = new TeacherUserTask();

        String studentName = resultSet.getString(UserDataColumnName.NAME) + " "
                + resultSet.getString(UserDataColumnName.SURNAME);
        teacherUserTask.setStudentName(studentName);
        teacherUserTask.setUserTaskId(resultSet.getInt(UserTaskColumnName.ID));
        teacherUserTask.setStartTime(resultSet.getString(UserTaskColumnName.CREATION_TIME));
        teacherUserTask.setDeadline(resultSet.getString(UserDataColumnName.DEADLINE));
        teacherUserTask.setEstimate(resultSet.getInt(UserDataColumnName.ESTIMATE));
        teacherUserTask.setStatus(resultSet.getInt(UserDataColumnName.STATUS));

        return teacherUserTask;
    }
}
