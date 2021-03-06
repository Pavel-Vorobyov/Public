package by.vorobyov.training.service.creator.impl;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.UserDataColumnName;
import by.vorobyov.training.database.dao.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.TeacherUserTask;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Crate an list of
 * {@link by.vorobyov.training.dto.TeacherUserTask TeacherUserTask} or just a TeacherUserTask.
 *
 * @see by.vorobyov.training.service.creator.AbstractCreator AbstractEntityCreator
 * @see by.vorobyov.training.service.creator.ICreator ICreator
 */
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
