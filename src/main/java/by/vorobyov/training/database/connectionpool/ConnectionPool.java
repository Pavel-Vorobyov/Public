package by.vorobyov.training.database.connectionpool;

import by.vorobyov.training.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static ConnectionPool INSTANCE;

    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private BlockingQueue<Connection> availableConnections;
    private BlockingQueue<Connection> usedConnections;

    private ConnectionPool() {
        this.driverName = DBSettings.DB_DRIVER;
        this.url = DBSettings.DB_URL;
        this.user = DBSettings.DB_USER;
        this.password = DBSettings.DB_PASSWORD;
        this.poolSize = DBSettings.DB_POOL_SIZE;
        try {
            init();
        } catch (DAOException e) {
            e.printStackTrace();            // Залогировать!!
        }
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }

        return INSTANCE;
    }

    public void init() throws DAOException {
        availableConnections = new ArrayBlockingQueue<Connection>(poolSize);
        usedConnections = new ArrayBlockingQueue<Connection>(poolSize);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < poolSize; i++) {
                availableConnections.add(DriverManager.getConnection(url, user, password));
            }
        } catch (SQLException |ClassNotFoundException e) {
            throw new DAOException("Connection hasn't been created!" + e);
        }
    }

    public Connection getConnection() throws DAOException {
        Connection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            throw new DAOException("Exception with connection monipulation!" + e);
        }
        return connection;
    }

    public void close(Connection connection) throws DAOException {
        if (connection == null) {
            throw new DAOException("Null_Pointer connection from-> " + this.getClass().toString());
        }
        availableConnections.add(connection);
        usedConnections.remove(connection);
    }

    public void closeConnections() throws DAOException {
        try {
            for (Connection connection : availableConnections) {  //Добавить метод аварийного закрытия всех коннектов
                connection.close();                             //Сделать этот метод закрытия только AvailableConnections
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
