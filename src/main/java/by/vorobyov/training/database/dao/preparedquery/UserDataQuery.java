package by.vorobyov.training.database.dao.preparedquery;

public class UserDataQuery {
    private UserDataQuery() {
    }

    public final static String SELECT_USER_DATA_BY_ID = "SELECT * FROM user_data WHERE user_id = ?";

    public final static String SELECT_ALL_USER_DATA_BY_STATUS_BETWEEN = "SELECT id, status, name, surname, creationtime, description" +
            " FROM user_data, user" +
            " WHERE user.id = user_data.user_id and user.status BETWEEN ? AND ?";

    public final static String SELECT_ALL_USER_DATA_BY_USER_ID = "SELECT user.id, user.status, user_data.name, user_data.surname, user_data.email, user_data.creationtime, user_data.description" +
            " FROM user, user_data WHERE user_data.user_id = user.id AND user.id = ?";

    public final static String SELECT_USER_DATA_BY_WORK_GROUP_ID = "SELECT user.id, user.status, user_data.name, user_data.surname, user_data.email, user_data.creationtime, user_data.description" +
            " FROM user, user_data, user_has_group" +
            " WHERE user_data.user_id = user.id" +
            "      AND user.id = user_has_group.user_id" +
            "      AND user_has_group.work_group_id = ?";

    public final static String UPDATE_USER_DATA_BY_USER_ID = "UPDATE user_data SET name = ?, surname = ?, creationtime = ?, description = ?" +
            " WHERE user_id = ?";

    public final static String NAME_SELECT = "SELECT name FROM user_data";

    public final static String SURNAME_SELECT = "SELECT surname FROM user_data";

    public final static String DESCRIPTION_SELECT = "SELECT description FROM user_data";

    public final static String NAME_UPDATE = "UPDATE user_data SET name = ? WHERE id = ?";

    public final static String SURNAME_UPDATE = "UPDATE user_data SET surname = ? WHERE id = ?";

    public final static String DESCRIPTION_UPDATE = "UPDATE user_data SET description = ? WHERE id = ?";

    public final static String INSERT_USER_DATA = "INSERT INTO user_data (user_id, name, surname, creationtime, description) VALUES (?, ?, ?, ?, ?)";

    public final static String DELETE_USER_DATA_BY_ID = "DELETE FROM user_data WHERE id = ?";
}
