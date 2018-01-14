package by.vorobyov.training.database.dao.preparedquery;

public class CommentQuery {
    private CommentQuery() {
    }

    public final static String SELECT_COMMENT_BY_AUTHOR_ID = "SELECT * FROM comment WHERE author_id = ?";

    public final static String SELECT_COMMENT_BY_ID = "SELECT * FROM comment WHERE id = ?";

    public final static String UPDATE_TEXT = "UPDATE comment SET text = ? WHERE id = ?";

    public final static String INSERT_COMMENT = "INSERT INTO comment(status, creationtime, text, author_id) VALUES (?, ?, ?, ?)";

    public final static String DELETE_COMMENT_BY_ID = "DELETE FROM comment WHERE id = ?";
}
