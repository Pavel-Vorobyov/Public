package by.vorobyov.training.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TaskLine extends TagSupport {
    private String taskHerf;
    private String taskTitle;
    private String startTime;
    private String deadline;
    private String description;

    public void setTaskHerf(String taskHerf) {
        this.taskHerf = taskHerf;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<li class=\"item-body\">");
            pageContext.getOut().write("<a href=\"" + taskHerf + "\">");
            pageContext.getOut().write("<span class=\"tk-task-name\" title=\"Lolli\">" + taskTitle + "</span>");
            pageContext.getOut().write("<span class=\"tk-start-time\" title=\"Lololol\">" + startTime + "</span>");
            pageContext.getOut().write("<span class=\"tk-deadline\" title=\"Lololol\">" + deadline + "</span>");
            pageContext.getOut().write("<span class=\"tk-courseDescription\" title=\"Kffsdf\">" + description + "</span>");
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
