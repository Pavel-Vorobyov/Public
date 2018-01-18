package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class UserDAOTest {
    private UserDAO userDAO;

    @Before
    public void initUserDAO() {
        userDAO = new UserDAO();
    }

    @After
    public void clearUserDAO() {
        userDAO = null;
    }


    @Test
    public void getUserByLogPassTest() throws SQLException, DAOException {
        User user = new User();
        user.setLogin("pavel");
        user.setPassword("pavelpavel");
        User checkedUser = userDAO.getUserByLogPass(user);
        System.out.println(checkedUser);
    }
}
