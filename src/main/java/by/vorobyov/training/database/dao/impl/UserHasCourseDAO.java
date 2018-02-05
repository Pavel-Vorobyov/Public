package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.UserHasCourseCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.database.dao.IDAO;
import by.vorobyov.training.dto.entity.UserHasCourse;
import by.vorobyov.training.exception.DAOException;

import javax.naming.InsufficientResourcesException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHasCourseDAO extends AbstractDAO<UserHasCourse> implements IDAO<UserHasCourse> {
    public static final String CREATE_USER_HAS_COURSE = "insert into user_has_course (user_id, course_id)" +
            " values (?, ?)";

    public static final String DELETE_USER_HAS_COURSE = "DELETE FROM user_has_course WHERE user_id = ? AND course_id = ?";

    public static final String SELECT_USER_HAS_COURSE_BY_ID = "select * from user_has_course " +
            " WHERE user_id = ? AND  course_id = ?";

    @Override
    public boolean update(UserHasCourse entity) throws DAOException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserHasCourse getEntityById(Integer entityId) throws DAOException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(UserHasCourse entity) throws DAOException, SQLException {

        return makeSqlRequest(entity.getUserId(), entity.getCourseId(), DELETE_USER_HAS_COURSE);

    }

    @Override
    public boolean create(UserHasCourse entity) throws DAOException, SQLException {

        return makeSqlRequest(entity.getUserId(), entity.getCourseId(), CREATE_USER_HAS_COURSE);

    }

    public UserHasCourse getUerHasCourseById(Integer userId, Integer courseID) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        UserHasCourseCreator userHasCourseCreator = new UserHasCourseCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_HAS_COURSE_BY_ID);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseID);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? userHasCourseCreator.createEntity(resultSet) : UserHasCourse.emptyEntity();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    private boolean makeSqlRequest(Integer firstInt
                , Integer secInt, String sqlRequest) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setInt(1, firstInt);
            preparedStatement.setInt(2, secInt);

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
}
