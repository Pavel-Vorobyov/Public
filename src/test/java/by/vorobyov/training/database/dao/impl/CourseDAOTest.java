package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.dao.FactoryDAO;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CourseDAOTest {
    CourseDAO courseDAO;

    @BeforeMethod
    public void setUp() throws Exception {
        courseDAO = FactoryDAO.getINSTANCE().getCourseDAO();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        courseDAO = null;
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGetEntityById() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testCreate() throws Exception {
    }

    @Test
    public void testGetCourseListByUserId() throws Exception {
    }

    @Test
    public void testGetCourseListByStatus() throws Exception {
    }

    @Test
    public void testGetCourseListBySQLRequest() throws Exception {
    }

}