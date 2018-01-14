package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.entity.Course;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.List;

public class StudentServiceTest {
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
        CommonService commonService = new CommonService();

        List<Course> courseList = commonService.takeCourseList();
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