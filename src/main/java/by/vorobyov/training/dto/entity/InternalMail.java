package by.vorobyov.training.dto.entity;

import javax.resource.cci.IndexedRecord;
import java.security.SecureRandom;

public class InternalMail {
    private Integer id;
    private Integer recipientId;
    private Integer authorId;
    private String subject;
    private String text;
    private boolean emptyInternalMail = false;

    public static InternalMail emptyEntity() {
        InternalMail internalMail = new InternalMail();
        internalMail.setEmptyInternalMail(true);

        return internalMail;
    }

    public boolean isEmptyInternalMail() {
        return emptyInternalMail;
    }

    public void setEmptyInternalMail(boolean emptyInternalMail) {
        this.emptyInternalMail = emptyInternalMail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternalMail that = (InternalMail) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipientId != null ? !recipientId.equals(that.recipientId) : that.recipientId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipientId != null ? recipientId.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InternalMail{" +
                "id=" + id +
                ", recipientId=" + recipientId +
                ", authorId=" + authorId +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
