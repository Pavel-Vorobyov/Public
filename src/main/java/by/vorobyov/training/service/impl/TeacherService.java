package by.vorobyov.training.service.impl;

import by.vorobyov.training.database.dao.impl.TaskDAO;
import by.vorobyov.training.database.dao.impl.UserTaskDAO;
import by.vorobyov.training.database.dao.impl.WorkGroupDAO;
import by.vorobyov.training.dto.entity.Task;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TeacherService extends CommonService {

    public boolean createTask (Task task, Integer groupId) throws ServiceException {
        TaskDAO taskDAO = new TaskDAO();
        UserTaskDAO userTaskDAO = new UserTaskDAO();
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();
        Task createdTask;

        try {
            boolean taskCreated = taskDAO.create(task);
            boolean flag = false;

            if (taskCreated) {
                createdTask = taskDAO.getTaskByData(task);
                System.out.println(createdTask);
                List<User> userList = workGroupDAO.getUserListByGroupId(groupId);

                for (int i=0; i<userList.size(); i++) {
                    UserTask userTask = new UserTask();

                    userTask.setUserId(userList.get(i).getUserId());
                    userTask.setCreationTime(createdTask.getCreationTime());
                    userTask.setDeadLine(createdTask.getDeadline());
                    userTask.setWorkGroupId(groupId);
                    userTask.setTaskId(createdTask.getTaskId());

                    boolean userTaskCreated = userTaskDAO.create(userTask);

                    if (!userTaskCreated) {
                        throw new ServiceException("User task hasn't been created!");
                    }
                }
                flag = true;
            }

            return flag;

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }
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
