package by.vorobyov.training.database.dao.preparedquery;

public class CourseQuery {
    private CourseQuery() {
    }

    public final static String SELECT_ALL_COURSES = "SELECT * FROM course";

    public final static String SELECT_COURSE_BY_ID = "SELECT * FROM course WHERE id = ?";

    public final static String SELECT_COURSE_BY_STATUS = "SELECT * FROM course WHERE status = ?";

    public final static String SELECT_COURSE_BY_LEAD_ID = "SELECT * FROM course WHERE lead_id = ?";

    public final static String TITLE_UPDATE = "UPDATE course SET title = ? WHERE id = ?";

    public final static String REGION_UPDATE = "UPDATE course SET region = ? WHERE id = ?";

    public final static String DESCRIPTION_UPDATE = "UPDATE course SET description = ? WHERE id = ?";

    public final static String LEAD_UPDATE = "UPDATE course SET lead = ? WHERE id = ?";

    public final static String UPDATE_COURSE = "UPDATE course SET title = ?, region = ?, description = ?, lead_id = ? WHERE course.id = ?";

    public final static String COURSE_INSERT = "INSERT INTO course(title, region, description, lead_id) VALUES (?, ?, ?, ?)";

    public final static String DELETE_COURSE = "DELETE FROM course WHERE id = ?";
}
