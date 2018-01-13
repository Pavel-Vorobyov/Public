package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.entity.User;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AdminServiceTest {
    @Test
    public void testTakeUserListByStatus() throws Exception {
        AdminDAO adminDAO = new AdminDAO();
        ConnectionPool.getInstance().init();
        List<User> usersList = adminDAO.takeUserListByStatus(1);
        for (User user:usersList) {
            System.out.println(user);
        }
    }

}