package by.vorobyov.training.database.service;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommonServiceTest {
    private CommonService commonService;

    @Before
    public void initUserDAO() {
        commonService = new CommonService();
    }

    @After
    public void clearUserDAO() {
        commonService = null;
    }


    @Test
    public void getUserByLogPassTest() throws ServiceException {
        User user = new User();
        user.setLogin("pavel");
        user.setPassword("pavelpavel");
        User checkedUser = commonService.checkUser(user);
        System.out.println(checkedUser);
    }
}
