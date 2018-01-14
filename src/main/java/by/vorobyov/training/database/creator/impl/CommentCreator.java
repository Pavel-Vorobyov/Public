package by.vorobyov.training.database.creator.impl;

import by.vorobyov.training.database.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.CommentColumnName;
import by.vorobyov.training.entity.Comment;
import by.vorobyov.training.resource.parametername.CommentParameterName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CommentCreator implements ICreator<Comment> {

    @Override
    public List<Comment> createEntityList(ResultSet resultSet) throws SQLException {
        List<Comment> commentList = new LinkedList<>();

        while (resultSet.next()) {
            Comment comment = createEntity(resultSet);
            commentList.add(comment);
        }

        return commentList;
    }

    @Override
    public Comment createEntity(ResultSet resultSet) throws SQLException {
        Comment comment = new Comment();

        comment.setCommentId(resultSet.getInt(CommentColumnName.ID));
        comment.setStatus(resultSet.getInt(CommentColumnName.STATUS));
        comment.setCreationTime(resultSet.getInt(CommentColumnName.CREATION_TIME));
        comment.setText(resultSet.getString(CommentColumnName.TEXT));
        comment.setAuthorId(resultSet.getInt(CommentColumnName.AUTHOR_ID));

        return comment;
    }

}
