package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.service.CommonDAO;
import by.vorobyov.training.entity.Course;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.List;

public class StudentDAOTest {
    StudentDAO studentDAO = null;

    @Before
    public void initStudentDAO() {
        studentDAO = new StudentDAO();
    }

    @After
    public void clearStudentDAO() {
        studentDAO = null;
    }

    @Test
    public void testApplyForCourse() throws Exception {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.applyForCourse(11, 5);
        CommonDAO commonDAO = new CommonDAO();

        List<Course> courseList = commonDAO.takeCourseList();
        for (Course course:courseList) {
            System.out.println(course);
        }

    }

    @Test
    public void testCancelCourseApplication() throws Exception {
    }

    @Test
    public void testPerformTask() throws Exception {
    }

}