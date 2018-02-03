package by.vorobyov.training.tag.teacher;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class GroupTaskUpdate extends TagSupport {
    private Integer groupId;
    private Integer taskId;
    private String taskTitle;
    private String taskDescription;

    private String helpTaskTitle;
    private String helpTaskDescription;
    private String helpButtonClose;
    private String submitButtonTitle;
    private String blockTitle;

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setHelpTaskTitle(String helpTaskTitle) {
        this.helpTaskTitle = helpTaskTitle;
    }

    public void setHelpTaskDescription(String helpTaskDescription) {
        this.helpTaskDescription = helpTaskDescription;
    }

    public void setHelpButtonClose(String helpButtonClose) {
        this.helpButtonClose = helpButtonClose;
    }

    public void setSubmitButtonTitle(String submitButtonTitle) {
        this.submitButtonTitle = submitButtonTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (taskId != null) {
                pageContext.getOut().write("                <div id=\"updateTask" + taskId + "\" class=\"createTask\">");
            } else {
                pageContext.getOut().write("                <div id=\"createTask\" class=\"createTask\">");
            }

            pageContext.getOut().write("                    <div class=\"container\">");
            pageContext.getOut().write("                        <div class=\"creation\">");

            if (taskId != null) {
                pageContext.getOut().write("                            <a onclick=\"showUpdateBlock(updateTask" + taskId + ")\" title=\"Close\" class=\"close\">X</a>");
            } else {
                pageContext.getOut().write("                            <a onclick=\"showUpdateBlock(createTask)\" title=\"Close\" class=\"close\">X</a>");
            }

            pageContext.getOut().write("                            <h1>" + blockTitle + "</h1>");
            pageContext.getOut().write("                            <form method=\"post\" action=\"command\">");

            if (taskId != null) {
                pageContext.getOut().write("                                <input type=\"hidden\" name=\"command\" value=\"teacher-update-task\"/>");
            } else {
                pageContext.getOut().write("                                <input type=\"hidden\" name=\"command\" value=\"teacher-create-task\"/>");
            }

            if (groupId != null) {
                pageContext.getOut().write("                                <input type=\"hidden\" name=\"group-id\" value=\"" + groupId + "\"/>");
            }

            if (taskId != null) {
                pageContext.getOut().write("                                <input type=\"hidden\" name=\"task-id\" value=\"" + taskId + "\"/>");
            }

            if (taskTitle == null) {
                pageContext.getOut().write("                                <p><input type=\"text\" name=\"title\" required id=\"title\" value=\"\"");
            } else {
                pageContext.getOut().write("                                <p><input type=\"text\" name=\"title\" required id=\"title\" value=\"" + taskTitle + "\"");
            }
            pageContext.getOut().write("                                          pattern=\"^.{1,44}$\" placeholder=\"Enter task title\">");

            pageContext.getOut().write("                                    <input type=\"date\" name=\"deadline\" required=\"true\" id=\"deadline\" value=\"\"");
            pageContext.getOut().write("                                           placeholder=\"Time when a task should be done\"></p>");

            pageContext.getOut().write("                                <p><textarea required maxlength=\"1000\" rows=\"9\" cols=\"34\" name=\"description\"");
            if (taskDescription == null) {
                pageContext.getOut().write("                                             id=\"description\" placeholder=\"Enter task description\"></textarea></p>");
            } else {
                pageContext.getOut().write("                                             id=\"description\" placeholder=\"Enter task description\">" + taskDescription + "</textarea></p>");
            }

            pageContext.getOut().write("                                <p class=\"submit\">");
            pageContext.getOut().write("                                    <input type=\"submit\" name=\"modify\" value=\"Create task\">");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("                                </p>");
            pageContext.getOut().write("                            </form>");
            pageContext.getOut().write("                        </div>");
            pageContext.getOut().write("                    </div>");
            pageContext.getOut().write("                </div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
