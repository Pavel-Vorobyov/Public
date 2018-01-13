package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.database.connectionpool.ConnectionPool;
import by.vorobyov.training.database.creator.CourseCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.preparedquery.CourseQuery;
import by.vorobyov.training.database.exception.DAOException;
import by.vorobyov.training.entity.Course;
import com.mysql.cj.api.mysqla.result.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

            return resultSet != null ? courseCreator.createCourseList(resultSet) : null; // resultSet != null ????????

        } catch (SQLException e) {
            rollback(connection);
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    @Override
    public Course update(Course entity) {
        return null;
    }

    @Override
    public Course getEntityById(Integer entityId) {
        return null;
    }

    @Override
    public boolean delete(Course entity) {
        return false;
    }

    @Override
    public boolean create(Course entity) {
        return false;
    }
}
