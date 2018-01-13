package by.vorobyov.training.database.dao.preparedquery;

public class CommentQuery {
    private CommentQuery() {
    }

    public final static String SELECT_COMMENT_BY_AUTHOR_ID = "SELECT * FROM comment WHERE author_id = ?";

    public final static String SELECT_AUTHOR_BY_COMMENT_ID = "SELECT * FROM comment WHERE id = ?";

    public final static String UPDATE_TEXT = "UPDATE comment SET text = ? WHERE id = ?";

    public final static String INSERT_COMMENT = "INSERT INTO comment(status, creationtime, text, author) VALUES (?, ?, ?, ?)";

    public final static String DELETE_COMMENT = "DELETE FROM comment WHERE id = ?";
}
