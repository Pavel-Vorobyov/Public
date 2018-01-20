package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.TaskCreator;
import by.vorobyov.training.creator.impl.TeachingUserTaskCreator;
import by.vorobyov.training.creator.impl.UserTaskCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.TaskQuery;
import by.vorobyov.training.dto.TeachingUserTask;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TaskDAO extends AbstractDAO<Task> {
    public static final String SELECT_GROUP_TASK_BY_GROUP_ID = "SELECT *" +
            " FROM task" +
            " WHERE task.id IN (SELECT task_id" +
            "             FROM user_task, task" +
            "             WHERE work_group_id = ?" +
            "             GROUP BY task_id)";

    public static final String SELECT_USER_TASK_BY_TASK_ID = "SELECT user_data.name, user_data.surname, user_task.creationtime, user_task.deadline" +
            ", user_task.estimate, user_task.status" +
            " FROM user_task, user_data" +
            " WHERE user_data.user_id = user_task.user_id AND task_id =? AND work_group_id = ?";

    public static final String INSERT_TASK = "INSERT INTO task (title, description, author_id, creationtime, deadline) VALUES (?, ?, ?, ?, ?)";

    public static final String SELECT_TASK_ID_BY_TASK = "SELECT *" +
            " FROM task WHERE title = ? AND description = ? AND" +
            "                author_id = ? AND creationtime = ? AND deadline = ?";


    @Override
    public List<Task> getAll() throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean update(Task entity) throws DAOException, SQLException {
        return false;
    }

    @Override
    public Task getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        TaskCreator taskCreator = new TaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(TaskQuery.SELECT_TASK_BY_TASK_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            if (resultSet != null) {
                return taskCreator.createEntity(resultSet);
            } else {
                throw new DAOException("ResultSet is null! -> TaskQuery.SELECT_TASK_BY_TASK_ID ");
            }
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(Task entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(TaskQuery.DELETE_TASK);
            preparedStatement.setInt(1, entity.getTaskId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean create(Task entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
//            preparedStatement = connection.prepareStatement(TaskQuery.TASK_INSERT);
            preparedStatement = connection.prepareStatement(INSERT_TASK);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getAuthorId());
            preparedStatement.setString(4, entity.getCreationTime());
            preparedStatement.setString(5, entity.getDeadline());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<Task> getGroupTaskByGroupId(Integer groupId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        TaskCreator taskCreator = new TaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_GROUP_TASK_BY_GROUP_ID);
            preparedStatement.setInt(1, groupId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return taskCreator.createEntityList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<TeachingUserTask> getUserTaskListByTaskId(Integer taskId, Integer groupId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        TeachingUserTaskCreator teachingUserTaskCreator = new TeachingUserTaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_TASK_BY_TASK_ID);
            preparedStatement.setInt(1, taskId);
            preparedStatement.setInt(2, groupId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return teachingUserTaskCreator.createEntityList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public Task getTaskByData(Task task) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        TaskCreator taskCreator = new TaskCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_TASK_ID_BY_TASK);
//            preparedStatement = connection.prepareStatement(INSERT_TASK);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, task.getAuthorId());
            preparedStatement.setString(4, task.getCreationTime());
            preparedStatement.setString(5, task.getDeadline());

            resultSet = preparedStatement.executeQuery();
            connection.commit();

            if (resultSet.next()) {
                return taskCreator.createEntity(resultSet);
            } else {
                return Task.emptyEntity();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
