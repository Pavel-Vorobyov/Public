package by.vorobyov.training.database.dao.preparedquery;

public class UserQuery {
    private UserQuery(){
    }

    public final static String SELECT_ID_AND_STATUS = "SELECT id, status FROM user";

    public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";

    public static final String SELECT_USER_STATUS_BETWEEN = "SELECT * FROM user WHERE status BETWEEN ? AND ?";

    public final static String SELECT_USER_BY_LOG_PASS = "SELECT * FROM user WHERE login = ?, password = ?";

    public final static String SELECT_ID_AND_STATUS_BY_STATUS = "SELECT id, status FROM user WHERE status = ?";

    public final static String SELECT_PASSWORD_BY_LOGIN = "SELECT * FROM user WHERE login = ? AND password = ?";

    public final static String IS_UNIQUE_LOGIN_SELECT = "SELECT login FROM user WHERE login = ?";

    public final static String UPDATE_USER_BY_ID = "UPDATE user SET login = ?, password = ?, status = ? WHERE id = ?";

    public final static String UPDATE_USER_STATUS_BY_ID = "UPDATE user SET status = ? WHERE id = ?";

    public final static String INSERT_USER = "INSERT INTO user (login, password) VALUES (?, ?)";

    public final static String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";

}
