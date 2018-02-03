package by.vorobyov.training.database.connectionpool;

import by.vorobyov.training.exception.DAOException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    public static final String DB_DRIVER = "mysql.driver";
    public static final String DB_URL = "mysql.url";
    public static final String DB_USER = "mysql.user";
    public static final String DB_PASSWORD = "mysql.password";
    public static final String DB_POOL_SIZE = "mysql.connection-pool-size";
    public static final String DB_PROP_FILE_NAME = "db";


    private static ConnectionPool INSTANCE;

    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private BlockingQueue<Connection> availableConnections;
    private BlockingQueue<Connection> usedConnections;

    private ConnectionPool() throws DAOException {
        ResourceBundle res = ResourceBundle.getBundle(DB_PROP_FILE_NAME);
        this.driverName = res.getString(DB_DRIVER);
        this.url = res.getString(DB_URL);
        this.user = res.getString(DB_USER);
        this.password = res.getString(DB_PASSWORD);
        this.poolSize = Integer.parseInt(res.getString(DB_POOL_SIZE));

        init();
    }

    public static ConnectionPool getInstance() throws DAOException {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }

        return INSTANCE;
    }

    public void init() throws DAOException {
        availableConnections = new ArrayBlockingQueue<Connection>(poolSize);
        usedConnections = new ArrayBlockingQueue<Connection>(poolSize);

        try {
            Class.forName(driverName);
            for (int i = 0; i < poolSize; i++) {
                availableConnections.add(DriverManager.getConnection(url, user, password));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Connection hasn't been created!" + e);
        }
    }

    public Connection getConnection() throws DAOException {
        Connection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            throw new DAOException("Exception with connection manipulation!" + e);
        }
        return connection;
    }

    public void close(Connection connection) throws DAOException {
        if (connection == null) {
            throw new DAOException("Connection is null!");
        }
        availableConnections.add(connection);
        usedConnections.remove(connection);
    }

    public void closeConnections() throws DAOException {
        try {
            for (Connection connection : availableConnections) {
                connection.close();
            }
            for (Connection connection : usedConnections) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Connection hasn't been closed!" + e);
        }
        availableConnections.clear();
        usedConnections.clear();
    }
}
