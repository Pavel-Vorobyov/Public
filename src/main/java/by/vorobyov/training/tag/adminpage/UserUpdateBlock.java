package by.vorobyov.training.tag.adminpage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserUpdateBlock extends TagSupport{
    private String blockType;
    private Integer userId;
    private Integer userStatus;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userCreationTime;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<div style=\"display: block;\" id=\"userUpdateBlock" + userId + "\" class=\"courseModify\">");
            pageContext.getOut().write("  <div class=\"container\">");
            pageContext.getOut().write("    <div class=\"modify\">");
            pageContext.getOut().write("      <a onclick=\"showUpdateBlock(userUpdateBlock" + userId + ")\" title=\"Close\" class=\"close\">X</a>");
            pageContext.getOut().write("       <h1>User updating...</h1>");
            pageContext.getOut().write("        <form name=\"userUpdate\" method=\"post\" action=\"command\">");
            pageContext.getOut().write("          <input type=\"hidden\" name=\"command\" value=\"update-user\">");
            pageContext.getOut().write("          <input type=\"hidden\" name=\"userStatus\" value=\"" + userStatus + "\">");
            pageContext.getOut().write("          <input type=\"hidden\" name=\"userId\" value=\"" + userId + "\">");
            pageContext.getOut().write("         <p align=\"left\">");
            pageContext.getOut().write("          Enter name:");
            pageContext.getOut().write("          <input style=\"float:right\" id=\"name\" name=\"name\" type=\"text\" value=\"" + userName + "\">");
            pageContext.getOut().write("         </p>");
            pageContext.getOut().write("         <p align=\"left\">");
            pageContext.getOut().write("           Enter surname:");
            pageContext.getOut().write("            <input style=\"float:right\" id=\"surname\" name=\"surname\" type=\"text\" value=\"" + userSurname + "\">");
            pageContext.getOut().write("          </p>");
            pageContext.getOut().write("          <p align=\"left\">");
            pageContext.getOut().write("            Enter email:");
            pageContext.getOut().write("            <input style=\"float:right\" id=\"email\" name=\"email\" type=\"text\" value=\"" + userEmail + "\">");
            pageContext.getOut().write("         </p>");
            pageContext.getOut().write("         <p align=\"left\">");
            pageContext.getOut().write("            Enter creation time:");
            pageContext.getOut().write("            <input style=\"float:right\" id=\"creationTime\" name=\"creationTime\" type=\"date\" value=\"\">");
            pageContext.getOut().write("          </p>");
            pageContext.getOut().write("          <p align=\"left\">");
            pageContext.getOut().write("           Enter status:");
            pageContext.getOut().write("          <select style=\"float:right\">");

            switch (userStatus) {
                case 0:
                    pageContext.getOut().write("            <option selected value=\"0\">Student</option>");
                    pageContext.getOut().write("            <option value=\"1\">Teacher</option>");
                    pageContext.getOut().write("            <option value=\"2\">Admin</option>");
                    break;
                case 1:
                    pageContext.getOut().write("            <option value=\"0\">Student</option>");
                    pageContext.getOut().write("            <option selected value=\"1\">Teacher</option>");
                    pageContext.getOut().write("            <option value=\"2\">Admin</option>");
                    break;
                case 2:
                    pageContext.getOut().write("            <option value=\"0\">Student</option>");
                    pageContext.getOut().write("            <option value=\"1\">Teacher</option>");
                    pageContext.getOut().write("            <option selected value=\"2\">Admin</option>");
                    break;
                default:
                    pageContext.getOut().write("            <option value=\"0\">Student</option>");
                    pageContext.getOut().write("            <option value=\"1\">Teacher</option>");
                    pageContext.getOut().write("            <option value=\"2\">Admin</option>");
            }

            pageContext.getOut().write("          </select>");
            pageContext.getOut().write("        </p>");
            pageContext.getOut().write("        <p class=\"submit\">");
            pageContext.getOut().write("          <a class=\"deleteButton\" onclick=\"deleteUser()\">Delete</a>");
            pageContext.getOut().write("          <input type=\"submit\" name=\"commit\" value=\"Update\">");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("        </p>");
            pageContext.getOut().write("      </form>");
            pageContext.getOut().write("    </div>");
            pageContext.getOut().write("  </div>");
            pageContext.getOut().write("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
