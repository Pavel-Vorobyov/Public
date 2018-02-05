package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.TaskCreator;
import by.vorobyov.training.creator.impl.TeachingUserTaskCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.IDAO;
import by.vorobyov.training.dto.TeacherUserTask;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TaskDAO extends AbstractDAO<Task> implements IDAO<Task> {
    public static final String SELECT_GROUP_TASK_BY_GROUP_ID = "SELECT *" +
            " FROM task" +
            " WHERE task.id IN (SELECT task_id" +
            "             FROM user_task, task" +
            "             WHERE work_group_id = ?" +
            "             GROUP BY task_id)";

    public static final String SELECT_USER_TASK_BY_TASK_ID = "SELECT user_task.id, user_data.name, user_data.surname, user_task.creationtime, user_task.deadline" +
            ", user_task.estimate, user_task.status" +
            " FROM user_task, user_data" +
            " WHERE user_data.user_id = user_task.user_id AND task_id =? AND work_group_id = ?";

    public static final String INSERT_TASK = "INSERT INTO task (title, description, author_id, creationtime, deadline) VALUES (?, ?, ?, ?, ?)";

    public static final String SELECT_TASK_ID_BY_TASK = "SELECT *" +
            " FROM task WHERE title = ? AND description = ? AND" +
            "                author_id = ? AND creationtime = ? AND deadline = ?";

    public static final String UPDATE_TASK = "UPDATE task" +
            " SET task.title = ?, task.deadline = ?, task.description = ?" +
            "  WHERE task.id = ?";

    public final static String SELECT_TASK_BY_TASK_ID = "SELECT * FROM task" +
            " WHERE task.id = ?";

    public final static String DELETE_TASK = "DELETE FROM task WHERE id = ?";



    @Override
    public boolean update(Task entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(UPDATE_TASK);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDeadline());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getTaskId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
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
            preparedStatement = connection.prepareStatement(SELECT_TASK_BY_TASK_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? taskCreator.createEntity(resultSet) : Task.emptyEntity();

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
            preparedStatement = connection.prepareStatement(DELETE_TASK);
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

    public List<TeacherUserTask> getUserTaskListByTaskId(Integer taskId, Integer groupId) throws SQLException, DAOException {
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
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, task.getAuthorId());
            preparedStatement.setString(4, task.getCreationTime());
            preparedStatement.setString(5, task.getDeadline());

            resultSet = preparedStatement.executeQuery();
            connection.commit();

            return resultSet.next() ? taskCreator.createEntity(resultSet) : Task.emptyEntity();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
