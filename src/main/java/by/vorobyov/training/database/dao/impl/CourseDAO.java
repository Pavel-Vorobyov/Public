package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.CourseCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.CourseQuery;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.Course;

import java.sql.*;
import java.util.List;

public class CourseDAO extends AbstractDAO<Course> {
    public static final String SELECT_COURSE_BY_STATUS = "SELECT * FROM course WHERE status = ?";
    public static final String SELECT_COURSE_BY_STATUS_REGION_TYPE = "SELECT *" +
            " FROM course" +
            " WHERE status = 0 AND course.region = 'Minsk, Belarus' AND course.type = 'Java'";

    @Override
    public List<Course> getAll() throws DAOException, SQLException {
        Connection connection = getConnection();
        ResultSet resultSet;
        Statement statement = null;
        CourseCreator courseCreator = new CourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(CourseQuery.SELECT_ALL_COURSES);

            connection.commit();
            return resultSet != null ? courseCreator.createEntityList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean update(Course entity) throws DAOException, SQLException {
        Connection connection;
        connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(CourseQuery.UPDATE_COURSE);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getRegion());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getCourseId());

            preparedStatement.executeUpdate();
            connection.commit();
            return true;

        } catch (SQLException e) {
            rollback(connection);
            throw  new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public Course getEntityById(Integer entityId) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        CourseCreator courseCreator = new CourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(CourseQuery.SELECT_COURSE_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? courseCreator.createEntity(resultSet) : Course.emptyEntity(); // resultSet != null ????????

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(Course entity) throws SQLException, DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(CourseQuery.DELETE_COURSE);

            preparedStatement.setInt(1, entity.getCourseId());

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
    public boolean create(Course entity) throws SQLException, DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(CourseQuery.COURSE_INSERT);

            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getRegion());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getLeadId());

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

    public List<Course> getCourseListByUserId(Integer userId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        CourseCreator courseCreator = new CourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(CourseQuery.SELECT_COURSE_BY_USER_ID);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            if (resultSet != null) {
                return courseCreator.createEntityList(resultSet);
            } else {
                throw new DAOException("ResultSet is null! -> CourseQuery.SELECT_COURSE_BY_USER_ID ");
            }
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<Course> getCourseListByStatus(Integer status) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        CourseCreator courseCreator = new CourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_STATUS);
            preparedStatement.setInt(1, status);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return courseCreator.createEntityList(resultSet);
        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public List<Course> getCourseListBySQLRequest(String sqlRequest) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        CourseCreator courseCreator = new CourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);

        try {
            preparedStatement = connection.prepareStatement(sqlRequest);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return courseCreator.createEntityList(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
