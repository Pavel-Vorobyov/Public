package by.vorobyov.training.database.dao.preparedquery;

public class UserHasCourseQuery {
    private UserHasCourseQuery() {
    }

    public final static String SELECT_COURSE_BY_USER_ID = "SELECT course_id FROM user_has_course WHERE user_id = ?";

    public final static String SELECT_USER_BY_COURSE_ID = "SELECT user_id FROM user_has_course WHERE course_id = ?";

    public final static String DELETED_USER_FROM_COURSE = "DELETE FROM user_has_course WHERE user_id = ? AND course_id = ?";

    public final static String INSERT_USER_HAS_COURSE = "INSERT INTO user_has_course (user_id, course_id) VALUES (?, ?)";
}
