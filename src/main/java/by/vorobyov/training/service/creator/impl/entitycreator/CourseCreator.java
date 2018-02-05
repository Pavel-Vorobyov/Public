package by.vorobyov.training.service.creator.impl.entitycreator;

import by.vorobyov.training.service.creator.AbstractCreator;
import by.vorobyov.training.service.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.CourseColumnName;
import by.vorobyov.training.dto.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseCreator extends AbstractCreator<Course> implements ICreator<Course> {
    @Override
    public Course createEntity(ResultSet resultSet) throws SQLException {
        Course course = new Course();

        course.setCourseId(resultSet.getInt(CourseColumnName.ID));
        course.setTitle(resultSet.getString(CourseColumnName.TITLE));
        course.setRegion(resultSet.getString(CourseColumnName.REGION));
        course.setType(resultSet.getString(CourseColumnName.TYPE));
        course.setDescription(resultSet.getString(CourseColumnName.DESCRIPTION));
        course.setLeadId(resultSet.getInt(CourseColumnName.LEAD_ID));
        course.setStatus(resultSet.getInt(CourseColumnName.STATUS) );

        return course;
    }
}
