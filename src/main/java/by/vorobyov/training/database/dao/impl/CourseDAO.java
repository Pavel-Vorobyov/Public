package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.CourseCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.CourseQuery;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.entity.Course;

import java.sql.*;
import java.util.List;

public class CourseDAO extends AbstractDAO<Course> {

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
            return resultSet != null ? courseCreator.createEntity(resultSet) : null; // resultSet != null ????????

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
}
