package by.vorobyov.training.service.creator.impl.entitycreator;

import by.vorobyov.training.database.dao.DAOFactory;
import by.vorobyov.training.database.dao.impl.CourseDAO;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CourseCreatorTest {
    CourseCreator courseCreator;
    CourseDAO courseDAO;

    @BeforeMethod
    public void setUp() throws Exception {
        courseCreator = new CourseCreator();
        courseDAO = DAOFactory.getINSTANCE().getCourseDAO();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        courseCreator = null;
        courseDAO = null;
    }

    @Test
    public void testCreateEntity() throws Exception {

    }

    @Test
    public void testCreateEntityList() throws Exception {
    }

}