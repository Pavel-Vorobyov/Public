package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.service.creator.impl.entitycreator.CourseCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.InterfaceDAO;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.Course;

import java.sql.*;
import java.util.List;

public class CourseDAO extends AbstractDAO<Course> implements InterfaceDAO<Course> {
    public static final String SELECT_COURSE_BY_STATUS = "SELECT * FROM course WHERE status = ?";

    public final static String INSERT_COURSE = "INSERT INTO course(title, region, description, type, status, lead_id) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_COURSE_BY_ID = "UPDATE course" +
            " SET course.type = ?, course.status = ?, course.region = ?" +
            "  , course.description = ?, course.title = ?, course.lead_id = ?" +
            " WHERE course.id = ?;";

    public final static String DELETE_COURSE = "DELETE FROM course" +
            " WHERE course.id = ?";

    public final static String SELECT_COURSE_BY_ID = "SELECT * FROM course WHERE id = ?";

    public static final String SELECT_COURSE_BY_USER_ID = "SELECT course.id, course.title, course.region, course.type, course.status, course.description, course.lead_id FROM course, user_has_course" +
            " WHERE course.id = user_has_course.course_id AND user_has_course.user_id = ?";



    @Override
    public boolean update(Course entity) throws DAOException, SQLException {
        Connection connection;
        connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(UPDATE_COURSE_BY_ID);
            preparedStatement.setString(1, entity.getType());
            preparedStatement.setInt(2, entity.getStatus());
            preparedStatement.setString(3, entity.getRegion());
            preparedStatement.setString(4, entity.getDescription());
            preparedStatement.setString(5, entity.getTitle());
            preparedStatement.setInt(6, entity.getLeadId());
            preparedStatement.setInt(7, entity.getCourseId());

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
            preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? courseCreator.createEntity(resultSet) : Course.emptyEntity();

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
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(DELETE_COURSE);
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
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(INSERT_COURSE);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getRegion());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setString(4, entity.getType());
            preparedStatement.setInt(5, entity.getStatus());
            preparedStatement.setInt(6, entity.getLeadId());

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
        return this.doRequestWithInteger(userId, SELECT_COURSE_BY_USER_ID);
    }

    public List<Course> getCourseListByStatus(Integer status) throws SQLException, DAOException {
       return this.doRequestWithInteger(status, SELECT_COURSE_BY_STATUS);
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

    private List<Course> doRequestWithInteger(Integer intSqlValue, String sqlRequest) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        CourseCreator courseCreator = new CourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, intSqlValue);

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
}
