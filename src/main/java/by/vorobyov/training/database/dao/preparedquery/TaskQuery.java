package by.vorobyov.training.database.dao.preparedquery;

public class TaskQuery {
    private TaskQuery() {
    }

    public final static String SELECT_TASK_BY_TASK_ID = "SELECT * FROM task";

    public final static String TITLE_UPDATE = "UPDATE task SET title = ? WHERE id = ?";

    public final static String DESCRIPTION_UPDATE = "UPDATE task SET description = ? WHERE id = ?";

    public final static String TASK_INSERT = "INSERT INTO task (title, description, author_id) VALUES (?, ?, ?)";

    public final static String DELETE_TASK = "DELETE FROM task WHERE id = ?";
}
