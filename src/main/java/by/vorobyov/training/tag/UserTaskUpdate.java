package by.vorobyov.training.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserTaskUpdate extends TagSupport {
    private String updateBlockId;
    private String studentName;
    private Integer userTaskId;

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
            pageContext.getOut().write("<body onload=\"initUpdateBlock(" + updateBlockId + ")\">");
            pageContext.getOut().write("    <div id=\"" + updateBlockId + "\" class=\"" + updateBlockId + "\">\n");
            pageContext.getOut().write("        <div class=\"container\">");
            pageContext.getOut().write("            <div class=\"taskUpdate\">");
            pageContext.getOut().write("            <a onclick=\"showUpdateBlock(" + updateBlockId + ")\" title=\"Close\" class=\"close\">X</a>\n");
            pageContext.getOut().write("            <h1>Registration</h1>");
            pageContext.getOut().write("            <form method=\"post\" action=\"command\">");
            pageContext.getOut().write("                <input type=\"hidden\" name=\"command\" value=\"add-user\"/>");
            pageContext.getOut().write("                <p align=\"left\">");
            pageContext.getOut().write("                    Enter estimate:");
            pageContext.getOut().write("                    <input style=\"float:right\" type=\"number\" min=\"0\" max=\"10\">");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p align=\"left\">");
            pageContext.getOut().write("                    Enter deadline:");
            pageContext.getOut().write("                    <input type=\"date\" style=\"float:right\" name=\"deadline\" id=\"deadline\" value=\"\"");
            pageContext.getOut().write("                        placeholder=\"Time when a task should be done\">");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p align=\"left\">");
            pageContext.getOut().write("                    Select task status:");
            pageContext.getOut().write("                    <select name=\"taskStatus\" style=\"float:right\">");
            pageContext.getOut().write("                        <option selected value=\"3\">Revision</option>");
            pageContext.getOut().write("                        <option value=\"1\">Done</option>");
            pageContext.getOut().write("                    </select>");
            pageContext.getOut().write("                </p>");
            pageContext.getOut().write("                <p>");
            pageContext.getOut().write("                    <textarea maxlength=\"1000\" rows=\"12\" cols=\"30\" name=\"taskDescription\" id=\"taskDescription\"></textarea>");
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
            pageContext.getOut().write("</body>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}


