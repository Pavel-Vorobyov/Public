package by.vorobyov.training.database.dao.impl;

import by.vorobyov.training.creator.impl.entitycreator.InternalMailCreator;
import by.vorobyov.training.database.dao.AbstractDAO;
import by.vorobyov.training.dto.entity.InternalMail;
import by.vorobyov.training.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InternalMailDAO extends AbstractDAO<InternalMail> {
    public static final String UPDATE_INTERNAL_MAIL = "UPDATE internal_mail" +
            " SET subject = ?, text = ?" +
            " WHERE id = ?";
    public static final String SELECT_INTERNAL_MAIL_BY_ID = "SELECT *" +
            " FROM internal_mail" +
            " WHERE id =?";

    public static final String DELETE_INTERNAL_MAIL = "DELETE FROM internal_mail" +
            " WHERE id = ?";

    public static final String INSERT_INTERNAL_MAIL = "INSERT INTO internal_mail " +
            " (recipient_id, author_id, subject, text) VALUES (?,?,?,?)";

    public static final String SELECT_INTERNAL_MAIL_BY_USER_ID_STATUS = "SELECT *" +
            " FROM internal_mail" +
            " WHERE internal_mail.recipient_id = ? AND internal_mail.checked = ?";

    public static final Integer MAIL_STATUS_UNCHECKED = 0;
    public static final Integer MAIL_STATUS_CHECKED = 1;


    @Override
    public boolean update(InternalMail entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(UPDATE_INTERNAL_MAIL);
            preparedStatement.setString(1, entity.getSubject());
            preparedStatement.setString(2, entity.getText());
            preparedStatement.setInt(3, entity.getId());

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
    public InternalMail getEntityById(Integer entityId) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        InternalMailCreator internalMailCreator = new InternalMailCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_INTERNAL_MAIL_BY_ID);
            preparedStatement.setInt(1, entityId);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next() ? internalMailCreator.createEntity(resultSet) : InternalMail.emptyEntity();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean delete(InternalMail entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(DELETE_INTERNAL_MAIL);
            preparedStatement.setInt(1, entity.getId());

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
    public boolean create(InternalMail entity) throws DAOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTERNAL_MAIL);
            preparedStatement.setInt(1, entity.getRecipientId());
            preparedStatement.setInt(2, entity.getAuthorId());
            preparedStatement.setString(3, entity.getSubject());
            preparedStatement.setString(4, entity.getText());

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


    public List<InternalMail> getUserInternalMailByStatus(Integer userId, Integer mailStatus) throws SQLException, DAOException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        InternalMailCreator internalMailCreator = new InternalMailCreator();

        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(SELECT_INTERNAL_MAIL_BY_USER_ID_STATUS);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, mailStatus);

            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return internalMailCreator.createEntityList(resultSet);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
