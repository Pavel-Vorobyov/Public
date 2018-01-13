package by.vorobyov.training.database.service.impl;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.database.service.CommonDAO;
import by.vorobyov.training.database.dao.preparedquery.CommentQuery;
import by.vorobyov.training.database.dao.preparedquery.TaskQuery;
import by.vorobyov.training.database.dao.preparedquery.UserTaskQuery;
import by.vorobyov.training.database.exception.DAOException;
import by.vorobyov.training.entity.Comment;
import by.vorobyov.training.entity.Task;
import by.vorobyov.training.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LecturerDAO extends CommonDAO {

    public void createTask (Task task) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(TaskQuery.TASK_INSERT);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, task.getAuthorId());
            preparedStatement.executeUpdate();

        } catch (SQLException  | DAOException e) {
            e.printStackTrace();
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }

    public void setEstimate(User user, Task task, Integer estimate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(UserTaskQuery.UPDATE_ESTIMATE_BY_ID);
            preparedStatement.setInt(1, estimate);
            preparedStatement.setInt(2, user.getUserId());
            preparedStatement.setInt(3, task.getTaskId());
            preparedStatement.executeUpdate();

        } catch (SQLException  | DAOException e) {
            e.printStackTrace();
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }

    public Integer addComment(Comment comment, Integer userId, Integer taskId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(CommentQuery.INSERT_COMMENT);
            preparedStatement.setInt(1, comment.getStatus());
            preparedStatement.setInt(2, comment.getCreationTime());
            preparedStatement.setString(3, comment.getText());
            preparedStatement.setInt(4, comment.getAuthorId());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(UserTaskQuery.UPDATE_COMMENT_BY_ID);
            preparedStatement.setInt(1, comment.getCommentId());
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, taskId);
            preparedStatement.executeUpdate();

            return comment.getCommentId();
        } catch (SQLException  | DAOException e) {
            e.printStackTrace();
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
        return null;
    }

    public void updateComment(Comment comment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(CommentQuery.UPDATE_TEXT);
            preparedStatement.setString(1, comment.getText());
            preparedStatement.executeUpdate();

        } catch (SQLException  | DAOException e) {
            e.printStackTrace();
        } finally {
            super.closePreparedStatement(preparedStatement);
            super.closeConnection(connection);
        }
    }
}
