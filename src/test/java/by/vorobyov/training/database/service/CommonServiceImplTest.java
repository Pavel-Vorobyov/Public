package by.vorobyov.training.database.service;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.CommonServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommonServiceImplTest {
    private CommonServiceImpl commonServiceImpl;

    @Before
    public void initUserDAO() {
        commonServiceImpl = new CommonServiceImpl();
    }

    @After
    public void clearUserDAO() {
        commonServiceImpl = null;
    }


    @Test
    public void getUserByLogPassTest() throws ServiceException {
        User user = new User();
        user.setLogin("pavel");
        user.setPassword("pavelpavel");
        User checkedUser = commonServiceImpl.checkUser(user);
        System.out.println(checkedUser);
    }
}
