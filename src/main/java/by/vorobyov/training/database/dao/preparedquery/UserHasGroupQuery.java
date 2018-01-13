package by.vorobyov.training.database.dao.preparedquery;

public class UserHasGroupQuery {
    private UserHasGroupQuery() {
    }

    public final static String SELECT_All_GROUP_BY_USER_ID = "SELECT work_group.id, work_group.title, work_group.description, work_group.lead_id, work_group.course_id" +
            " FROM work_group, user_has_group" +
            " WHERE work_group.id = user_has_group.work_group_id AND user_has_group.user_id = ?";

    public final static String SELECT_USER_BY_GROUP_I = "SELECT * FROM user_has_group WHERE work_group_id = ?";

    public final static String USER_HAS_GROUP_INSERT = "INSERT INTO user_has_group (user_id, work_group_id) VALUES (?, ?)";

    public final static String DELETE_USER_HAS_GROUP = "DELETE FROM user_has_group WHERE user_has_group.user_id = ? AND user_has_group.work_group_id = ?";
}
