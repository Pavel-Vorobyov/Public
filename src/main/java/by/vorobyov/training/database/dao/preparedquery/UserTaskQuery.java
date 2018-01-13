package by.vorobyov.training.database.dao.preparedquery;

public class UserTaskQuery {
    private UserTaskQuery() {
    }

    public final static String SELECT_ALL_USER_TASK_BY_USER_ID = "SELECT * FROM user_task WHERE id = ?";

    public final static String UPDATE_DEADLINE_BY_ID = "UPDATE user_task SET deadline = ? WHERE user_id = ? AND task_id = ?";

    public final static String UPDATE_ESTIMATE_BY_ID = "UPDATE user_task SET estimate = ? WHERE user_id = ? AND task_id = ?";

    public final static String UPDATE_STATUS_BY_ID = "UPDATE user_task SET status = ? WHERE user_id = ? AND task_id = ?";

    public final static String UPDATE_COMMENT_BY_ID = "UPDATE user_task SET comment = ? WHERE user_id = ? AND task_id = ?";

    public final static String USER_TASK_INSERT = "INSERT INTO user_task (creationtime, deadline, estimate, comment, user_id, task_id, work_group_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public final static String DELETE_USER_TASK = "DELETE FROM user_task WHERE id = ?";
}
