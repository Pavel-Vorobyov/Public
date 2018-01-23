package by.vorobyov.training.tag;

import by.vorobyov.training.dto.entity.UserData;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class StudentGroupMember extends TagSupport {
    private String name;
    private String surname;
    private String creationTime;
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<li class=\"item-body\">");
            pageContext.getOut().write("  <a onclick=\"\">");
            pageContext.getOut().write("    <span class=\"tk-user-name\">" + name + "</span>");
            pageContext.getOut().write("    <span class=\"tk-user-surname\">" + surname + "</span>");
            pageContext.getOut().write("          <span class=\"tk-user-creation-time\">" + creationTime + "</span>");
            pageContext.getOut().write("          <span class=\"tk-user-description\">" + description + "</span>");
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("  </a>");
            pageContext.getOut().write("</li>");
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
