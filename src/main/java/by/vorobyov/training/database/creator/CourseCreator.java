package by.vorobyov.training.database.creator;

import by.vorobyov.training.database.dao.util.columnname.CourseColumnName;
import by.vorobyov.training.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CourseCreator {
    public CourseCreator() {
    }

    public List<Course> createCourseList(ResultSet resultSet) throws SQLException {
        List<Course> courseList = new LinkedList<>();

        while (resultSet.next()) {
            Course course = createCourse(resultSet);
            courseList.add(course);
        }
        return courseList;
    }

    public Course createCourse(ResultSet resultSet) throws SQLException {
        Course course = new Course();

        course.setCourseId(resultSet.getInt(CourseColumnName.ID));
        course.setTitle(resultSet.getString(CourseColumnName.TITLE));
        course.setRegion(resultSet.getString(CourseColumnName.REGION));
        course.setDescription(resultSet.getString(CourseColumnName.DESCRIPTION));
        course.setLeadId(resultSet.getInt(CourseColumnName.LEAD_ID));
        course.setStatus(resultSet.getInt(CourseColumnName.STATUS) );

        return course;
    }
}
