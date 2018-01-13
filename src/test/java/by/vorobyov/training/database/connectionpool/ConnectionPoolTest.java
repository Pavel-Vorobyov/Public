package by.vorobyov.training.database.connectionpool;

import junit.framework.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConnectionPoolTest {
    @Test
    public void testGetInstance() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        Assert.assertTrue(connectionPool instanceof ConnectionPool);
    }

    @Test
    public void testInit() throws Exception {

    }

    @Test
    public void testGetConnection() throws Exception {
    }

    @Test
    public void testClose() throws Exception {
    }

    @Test
    public void testCloseConnections() throws Exception {
    }

}