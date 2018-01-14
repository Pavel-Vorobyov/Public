package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.entity.User1;
import org.testng.annotations.Test;

import java.util.List;

public class AdminServiceTest {
    @Test
    public void testTakeUserListByStatus() throws Exception {
        AdminDAO adminDAO = new AdminDAO();
        ConnectionPool.getInstance().init();
        List<User1> usersList = adminDAO.takeUserListByStatus(1);
        for (User1 user1 :usersList) {
            System.out.println(user1);
        }
    }

}