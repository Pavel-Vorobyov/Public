package by.vorobyov.training.tag.adminpage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class WorkGroupLine extends TagSupport {
    private Integer groupId;
    private String groupTitle;
    private String groupType;
    private String groupRegion;
    private String buttonModify;
    private Integer groupStatus;

    public void setButtonModify(String buttonModify) {
        this.buttonModify = buttonModify;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public void setGroupRegion(String groupRegion) {
        this.groupRegion = groupRegion;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<li class=\"item-body\">");
            pageContext.getOut().write("  <a href=\"#\">");
            pageContext.getOut().write("    <span class=\"tk-group-title\">" + groupTitle + "</span>");
            pageContext.getOut().write("    <span class=\"tk-group-type\">" + groupType + "</span>");
            pageContext.getOut().write("    <span class=\"tk-group-region\">" + groupRegion + "</span>");

            switch (groupStatus) {
                case 0:
                    pageContext.getOut().write("    <span class=\"tk-group-status\">Forming...</span>");
                    break;
                case 1:
                    pageContext.getOut().write("    <span class=\"tk-group-status\">Completed</span>");
                    break;
                default:
                    pageContext.getOut().write("    <span class=\"tk-group-status\">UNDEFINED</span>");
                    break;
            }

            pageContext.getOut().write("</a>");
            pageContext.getOut().write(" <a onclick=\"showUpdateBlock(groupUpdateBlock" + groupId + ")\" style=\"text-align: center;\">");
            pageContext.getOut().write("     <span class=\"tk-group-modify\">" + buttonModify + "</span>");
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
