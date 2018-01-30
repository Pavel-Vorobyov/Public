package by.vorobyov.training.tag.adminpage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserDataLine extends TagSupport {
    private Integer userId;
    private Integer userStatus;
    private String userName;
    private String userSurname;
    private String userCreationTime;
    private String userEmail;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setUserCreationTime(String userCreationTime) {
        this.userCreationTime = userCreationTime;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<li class=\"item-body\">");
            pageContext.getOut().write("  <a>");
            pageContext.getOut().write("    <span class=\"tk-user-name\">" + userName + "</span>");
            pageContext.getOut().write("    <span class=\"tk-user-surname\">" + userSurname + "</span>");
            pageContext.getOut().write("    <span class=\"tk-user-creation-time\">" + userCreationTime + "</span>");
            pageContext.getOut().write("    <span class=\"tk-user-email\">" + userEmail + "</span>");

            switch (userStatus) {
                case 0:
                    pageContext.getOut().write("    <span class=\"tk-user-status\">Student</span>");
                    break;
                case 1:
                    pageContext.getOut().write("    <span class=\"tk-user-status\">Teacher</span>");
                    break;
                case 2:
                    pageContext.getOut().write("    <span class=\"tk-user-status\">Admin</span>");
                    break;
                default:
                    pageContext.getOut().write("    <span class=\"tk-user-status\">UNDEFINED</span>");
            }

            pageContext.getOut().write("  </a>");
            pageContext.getOut().write("  <a onclick=\"showUpdateBlock(userUpdateBlock" + userId + ")\" style=\"text-align: center;\">");
            pageContext.getOut().write("    <span class=\"tk-group-modify\">Modify</span>");
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

