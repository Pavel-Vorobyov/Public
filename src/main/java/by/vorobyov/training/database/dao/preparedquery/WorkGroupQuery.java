package by.vorobyov.training.database.dao.preparedquery;

public class WorkGroupQuery {
    private WorkGroupQuery() {
    }

    public final static String SELECT_WORK_GROUP_BY_ID = "SELECT * FROM work_group WHERE id = ?";

    public final static String SELECT_WORK_GROUP_BY_LEAD_ID = "SELECT * FROM work_group WHERE lead_id = ?";

    public final static String UPDATE_TITLE_BY_ID = "UPDATE work_group SET title = ? WHERE id = ?";

    public final static String UPDATE_DESCRIPTION_BY_ID = "UPDATE work_group SET description = ? WHERE id = ?";

    public final static String UPDATE_GROUP_LEAD_BY_GROUP_ID = "UPDATE work_group SET lead_id = ? WHERE id = ?";

    public final static String WORK_GROUP_INSERT = "INSERT INTO work_group (title, description, lead, course_id) VALUES (?, ?, ?, ?)";

    public final static String DELETE_WORK_GROUP_BY_ID = "DELETE FROM work_group WHERE id = ?";
}
