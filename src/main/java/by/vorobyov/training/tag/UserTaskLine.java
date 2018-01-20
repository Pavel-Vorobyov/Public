package by.vorobyov.training.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserTaskLine extends TagSupport {
    private String name;
    private String creationTime;
    private String deadline;
    private Integer estimate;
    private Integer status;

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<li class=\"item-body\">");
            pageContext.getOut().write("<a onclick=\"showUpdateBlock(studentTaskUpdate)\">");
            pageContext.getOut().write("<span class=\"tk-student-name\" title=\"Student name\">" + name + "</span>");
            pageContext.getOut().write("<span class=\"tk-start-time\" title=\"Time when a task was created\">" + creationTime +"</span>");
            pageContext.getOut().write("<span class=\"tk-deadline\" title=\"Time when a task should be done\">" + deadline +"</span>");
            pageContext.getOut().write("<span class=\"tk-estimate\" title=\"A task estimate\">" + estimate +"</span>");
            pageContext.getOut().write("<span class=\"tk-status\" title=\"Status of a task (done/in process...)\">" + status +"</span>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("</a>");
            pageContext.getOut().write("</li>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
