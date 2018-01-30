package by.vorobyov.training.database.dao.preparedquery;

public class CourseQuery {
    private CourseQuery() {
    }

    public final static String SELECT_ALL_COURSES = "SELECT * FROM course";

    public final static String SELECT_COURSE_BY_ID = "SELECT * FROM course WHERE id = ?";

    public static final String SELECT_COURSE_BY_USER_ID = "SELECT course.id, course.title, course.region, course.status, course.description, course.lead_id FROM course, user_has_course" +
            " WHERE course.id = user_has_course.course_id AND user_has_course.user_id = ?";

    public final static String SELECT_COURSE_BY_STATUS = "SELECT * FROM course WHERE status = ?";

    public final static String SELECT_COURSE_BY_LEAD_ID = "SELECT * FROM course WHERE lead_id = ?";

    public final static String TITLE_UPDATE = "UPDATE course SET title = ? WHERE id = ?";

    public final static String REGION_UPDATE = "UPDATE course SET region = ? WHERE id = ?";

    public final static String DESCRIPTION_UPDATE = "UPDATE course SET description = ? WHERE id = ?";

    public final static String LEAD_UPDATE = "UPDATE course SET lead = ? WHERE id = ?";

    public final static String UPDATE_COURSE = "UPDATE course SET title = ?, region = ?, description = ?, lead_id = ? WHERE course.id = ?";
}
