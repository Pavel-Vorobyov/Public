package by.vorobyov.training.database.dao.preparedquery;

public class UserTaskQuery {
    private UserTaskQuery() {
    }

    public final static String SELECT_USER_TASK_BY_ID = "SELECT * FROM user_task WHERE id = ?";

    public static final String UPDATE_USER_TASK_BY_ID = "UPDATE user_task SET deadline = ?, estimate = ?, status = ?, comment_id = ?, work_group_id = ? WHERE id = ?";

    public final static String UPDATE_DEADLINE_BY_ID = "UPDATE user_task SET deadline = ? WHERE user_id = ? AND task_id = ?";

    public final static String UPDATE_ESTIMATE_BY_ID = "UPDATE user_task SET estimate = ? WHERE user_id = ? AND task_id = ?";

    public final static String UPDATE_STATUS_BY_ID = "UPDATE user_task SET status = ? WHERE user_id = ? AND task_id = ?";

    public final static String UPDATE_COMMENT_BY_ID = "UPDATE user_task SET comment = ? WHERE user_id = ? AND task_id = ?";

    public final static String INSERT_USER_TASK = "INSERT INTO user_task (creationtime, deadline, estimate, comment_id, user_id, task_id, work_group_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public final static String DELETE_USER_TASK_BY_ID = "DELETE FROM user_task WHERE id = ?";
}
