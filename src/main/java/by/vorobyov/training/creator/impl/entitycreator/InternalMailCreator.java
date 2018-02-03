package by.vorobyov.training.creator.impl.entitycreator;

import by.vorobyov.training.creator.AbstractCreator;
import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.InternalMailColumnName;
import by.vorobyov.training.dto.entity.InternalMail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InternalMailCreator extends AbstractCreator<InternalMail> implements ICreator<InternalMail> {
    @Override
    public InternalMail createEntity(ResultSet resultSet) throws SQLException {
        InternalMail internalMail = new InternalMail();

        internalMail.setId(resultSet.getInt(InternalMailColumnName.ID));
        internalMail.setRecipientId(resultSet.getInt(InternalMailColumnName.RECIPIENT_ID));
        internalMail.setAuthorId(resultSet.getInt(InternalMailColumnName.AUTHOR_ID));
        internalMail.setSubject(resultSet.getString(InternalMailColumnName.SUBJECT));
        internalMail.setText(resultSet.getString(InternalMailColumnName.TEXT));

        return internalMail;
    }
}
