package by.vorobyov.training.tag.student;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class StudentTaskLine extends TagSupport {
    private String href;
    private String taskTitle;
    private String taskCreationTime;
    private String deadline;
    private String comment;
    private Integer estimate;
    private Integer status;

    public void setHref(String href) {
        this.href = href;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskCreationTime(String taskCreationTime) {
        this.taskCreationTime = taskCreationTime;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
            pageContext.getOut().write("  <a onclick=\"" + href + "\">");
            pageContext.getOut().write("    <span class=\"tk-task-title\">" + taskTitle + "</span>");
            pageContext.getOut().write("    <span class=\"tk-task-creation-time\">" + taskCreationTime + "</span>");
            pageContext.getOut().write("    <span class=\"tk-task-deadline\">" + deadline + "</span>");
            if (estimate != null) {
                pageContext.getOut().write("    <span class=\"tk-task-estimate\">" + estimate + "</span>");
            } else {
                pageContext.getOut().write("    <span class=\"tk-task-estimate\"></span>");
            }
            switch (status) {
                case 0:
                    pageContext.getOut().write("    <span class=\"tk-task-status\">Not ready</span>");
                    break;
                case 1:
                    pageContext.getOut().write("    <span class=\"tk-task-status\">Done</span>");
                    break;
                case 2:
                    pageContext.getOut().write("    <span class=\"tk-task-status\">Submitted</span>");
                    break;
                default:
                    pageContext.getOut().write("    <span class=\"tk-task-status\">UNDEFINED</span>");
                    break;
            }
            pageContext.getOut().write("    <span class=\"tk-task-comment\">" + comment + "</span>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("  </a>");
            pageContext.getOut().write("</li>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
