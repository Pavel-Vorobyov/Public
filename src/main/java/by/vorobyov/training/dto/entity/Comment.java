package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    private Integer commentId;
    private Integer status;
    private String creationTime;
    private String text;
    private Integer authorId;
    private boolean emptyComment = false;

    public Comment() {
    }

    public Comment(Integer commentId, Integer status, String creationTime
        , String text, Integer authorId) {
        this.commentId = commentId;
        this.status = status;
        this.creationTime = creationTime;
        this.text = text;
        this.authorId = authorId;
    }

    public static Comment emptyComment() {
        Comment comment = new Comment();
        comment.setEmptyComment(true);
        return comment;
    }

    public boolean isEmptyComment() {
        return emptyComment;
    }

    public void setEmptyComment(boolean emptyComment) {
        this.emptyComment = emptyComment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getText() {
        return text;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (!commentId.equals(comment.commentId)) return false;
        if (!status.equals(comment.status)) return false;
        if (!creationTime.equals(comment.creationTime)) return false;
        if (!text.equals(comment.text)) return false;
        return authorId.equals(comment.authorId);
    }

    @Override
    public int hashCode() {
        int result = commentId.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + authorId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", status=" + status +
                ", creationTime=" + creationTime +
                ", text='" + text + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
