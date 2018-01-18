package by.vorobyov.training.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class GroupLine extends TagSupport {
    private String groupHerf;
    private String groupTitle;
    private String courseLocation;
    private String courseCourse;
    private String courseDescription;

    public void setGroupHerf(String groupHerf) {
        this.groupHerf = groupHerf;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public void setCourseCourse(String courseCourse) {
        this.courseCourse = courseCourse;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<li class=\"item-body\">");
            pageContext.getOut().write("<a href=\"" + groupHerf + "\">");
            pageContext.getOut().write("<span class=\"group-name\">" + groupTitle + "</span>");
            pageContext.getOut().write("<span class=\"group-region\">" + courseLocation + "</span>");
            pageContext.getOut().write("<span class=\"group-course\">" + courseCourse + "</span>");
            pageContext.getOut().write("<span class=\"group-lng\">" + courseDescription + "</span>");
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
