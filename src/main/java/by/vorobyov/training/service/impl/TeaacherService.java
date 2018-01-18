package by.vorobyov.training.service.impl;

import by.vorobyov.training.service.CommonService;

public class TeaacherService extends CommonService {



//    public void createTask (Task task) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//
//            preparedStatement = connection.prepareStatement(TaskQuery.TASK_INSERT);
//            preparedStatement.setString(1, task.getTitle());
//            preparedStatement.setString(2, task.getCourseDescription());
//            preparedStatement.setInt(3, task.getAuthorId());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException  | DAOException e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void setEstimate(User1 user1, Task task, Integer estimate) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//
//            preparedStatement = connection.prepareStatement(UserTaskQuery.UPDATE_ESTIMATE_BY_ID);
//            preparedStatement.setInt(1, estimate);
//            preparedStatement.setInt(2, user1.getUserId());
//            preparedStatement.setInt(3, task.getTaskId());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException  | DAOException e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public Integer addComment(Comment comment, Integer userId, Integer taskId) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//
//            preparedStatement = connection.prepareStatement(CommentQuery.INSERT_COMMENT);
//            preparedStatement.setInt(1, comment.getStatus());
//            preparedStatement.setInt(2, comment.getCreationTime());
//            preparedStatement.setString(3, comment.getText());
//            preparedStatement.setInt(4, comment.getAuthorId());
//            preparedStatement.executeUpdate();
//
//            preparedStatement = connection.prepareStatement(UserTaskQuery.UPDATE_COMMENT_BY_ID);
//            preparedStatement.setInt(1, comment.getCommentId());
//            preparedStatement.setInt(2, userId);
//            preparedStatement.setInt(3, taskId);
//            preparedStatement.executeUpdate();
//
//            return comment.getCommentId();
//        } catch (SQLException  | DAOException e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//        return null;
//    }
//
//    public void updateComment(Comment comment) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//
//            preparedStatement = connection.prepareStatement(CommentQuery.UPDATE_TEXT);
//            preparedStatement.setString(1, comment.getText());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException  | DAOException e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
}
