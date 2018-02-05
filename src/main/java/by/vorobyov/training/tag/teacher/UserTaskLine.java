package by.vorobyov.training.tag.teacher;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserTaskLine extends TagSupport {
    private  Integer userTaskId;
    private String name;
    private String creationTime;
    private String deadline;
    private Integer estimate;
    private Integer status;

    public void setUserTaskId(Integer userTaskId) {
        this.userTaskId = userTaskId;
    }

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
            pageContext.getOut().write("<a onclick=\"showUpdateBlock(studentTaskUpdate" + userTaskId + ")\">");
            pageContext.getOut().write("<span class=\"tk-student-name\" title=\"Student name\">" + name + "</span>");
            pageContext.getOut().write("<span class=\"tk-task-creation-time\" title=\"Time when a task was created\">" + creationTime +"</span>");
            pageContext.getOut().write("<span class=\"tk-task-deadline\" title=\"Time when a task should be done\">" + deadline +"</span>");
            pageContext.getOut().write("<span class=\"tk-task-estimate\" title=\"A task estimate\">" + estimate +"</span>");

            switch (status) {
                case 0:
                    pageContext.getOut().write("<span class=\"tk-task-status\" title=\"Status of a task (done/in process...)\">Not ready</span>");
                    break;
                case 1:
                    pageContext.getOut().write("<span class=\"tk-task-status\" title=\"Status of a task (done/in process...)\">Done</span>");
                    break;
                case 2:
                    pageContext.getOut().write("<span class=\"tk-task-status\" title=\"Status of a task (done/in process...)\">Submitted</span>");
                    break;
                default:
                    pageContext.getOut().write("<span class=\"tk-task-status\" title=\"Status of a task (done/in process...)\">UNDEFINED</span>");
                    break;
            }
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
