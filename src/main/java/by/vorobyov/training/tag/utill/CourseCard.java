package by.vorobyov.training.tag.utill;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CourseCard extends TagSupport {
    private String onClick;
    private Integer courseId;
    private String cardTitle = null;
    private String location = null;
    private String status = null;
    private String buttonName = null;

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<div class=\"column\">");
            pageContext.getOut().write("<div class=\"card\">");
            pageContext.getOut().write("<div class=\"title\">");
            pageContext.getOut().write("<div class=\"logo\">");
            pageContext.getOut().write("<img src=\"../img/logo.png\" width=\"170px\" alt=\"Course logo\">");
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("<a href=\"#\">" + cardTitle + "</a>");
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("<div class=\"location\">");
            pageContext.getOut().write("<span>" + location + "</span>");
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("<div class=\"training-registration\">");
            pageContext.getOut().write("<div class=\"status\">");
            pageContext.getOut().write("<span>" + status + "</span>");
            pageContext.getOut().write("</div>");

            if (onClick != "#") {
                pageContext.getOut().write("<a onClick=\"" + onClick + "\" class=\"course-registration\">" + buttonName + "</a>");
            } else {
                pageContext.getOut().write("<a onClick=\"showUpdateBlock(courseUpdateBlock" + courseId + ")\" class=\"course-registration\">" + buttonName + "</a>");
            }

        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {

        try {
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("</div>");
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }


}
