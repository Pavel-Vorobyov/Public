package by.vorobyov.training.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserTaskUpdate extends TagSupport {
    private String updateBlockId;
    private String studentName;
    private Integer userTaskId;
    private Integer groupId;
    private Integer taskId;

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public void setUpdateBlockId(String updateBlockId) {
        this.updateBlockId = updateBlockId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setUserTaskId(Integer userTaskId) {
        this.userTaskId = userTaskId;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
//            pageContext.getOut().write("<body onload=\"initUpdateBlock(studentTaskUpdate" + updateBlockId + ")\">");
            pageContext.getOut().write("    <div style=\"display:none\" id=\"studentTaskUpdate" + updateBlockId + "\" class=\"studentTaskUpdate\">");
            pageContext.getOut().write("        <div class=\"container\">");
            pageContext.getOut().write("            <div class=\"taskUpdate\">");
            pageContext.getOut().write("            <a onclick=\"showUpdateBlock(studentTaskUpdate" + updateBlockId + ")\" title=\"Close\" class=\"close\">X</a>");
            pageContext.getOut().write("            <h1>" + studentName + " task modifying...</h1>");
            pageContext.getOut().write("            <form method=\"post\" action=\"command\">");
            pageContext.getOut().write("                <input type=\"hidden\" name=\"command\" value=\"teacher-user-task-update\"/>");
            pageContext.getOut().write("                <input type=\"hidden\" name=\"user-task-id\" value=\"" + userTaskId + "\"/>");
            pageContext.getOut().write("                <input type=\"hidden\" name=\"group-id\" value=\"" + groupId + "\"/>");
            pageContext.getOut().write("                <input type=\"hidden\" name=\"task-id\" value=\"" + taskId + "\"/>");
            pageContext.getOut().write("                <p align=\"left\">");
            pageContext.getOut().write("                    Enter estimate:");
            pageContext.getOut().write("                    <input style=\"float:right\" name=\"estimate\" type=\"number\" min=\"0\" max=\"10\">");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p align=\"left\">");
            pageContext.getOut().write("                    Enter deadline:");
            pageContext.getOut().write("                    <input type=\"date\" style=\"float:right\" name=\"deadline\" id=\"deadline\" value=\"\"");
            pageContext.getOut().write("                        placeholder=\"Time when a task should be done\">");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p align=\"left\">");
            pageContext.getOut().write("                    Select task status:");
            pageContext.getOut().write("                    <select name=\"task-status\" style=\"float:right\">");
            pageContext.getOut().write("                        <option selected value=\"2\">Submitted</option>");
            pageContext.getOut().write("                        <option value=\"1\">Done</option>");
            pageContext.getOut().write("                    </select>");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p>");
            pageContext.getOut().write("                    <textarea maxlength=\"1000\" rows=\"7\" cols=\"30\" name=\"task-comment\" id=\"task-comment\"></textarea>");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Update\"></p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("</form>");
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("</div>");
            pageContext.getOut().write("</div>");
//            pageContext.getOut().write("</body>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}


