package by.vorobyov.training.database.connectionpool;

public class DBSettings {
    private DBSettings() {
    }

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/TrainingDB";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";
    public static final int DB_POOL_SIZE = 3;
}
