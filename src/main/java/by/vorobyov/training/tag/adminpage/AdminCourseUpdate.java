package by.vorobyov.training.tag.adminpage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class AdminCourseUpdate extends TagSupport {
    private String href;
    private String courseTitle;
    private String courseDescription;
    private String courseAvailability;
    private String courseType;
    private String courseRegion;
    private String courseLeadId;
    private Integer courseId;

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setCourseAvailability(String courseAvailability) {
        this.courseAvailability = courseAvailability;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setCourseRegion(String courseRegion) {
        this.courseRegion = courseRegion;
    }

    public void setCourseLeadId(String courseLeadId) {
        this.courseLeadId = courseLeadId;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("                <div style=\"display: none\" id=\"courseUpdateBlock${course.courseId}\" class=\"courseModify\">");
            pageContext.getOut().write("                  <div class=\"container\">");
            pageContext.getOut().write("                    <div class=\"modify\">");
            pageContext.getOut().write("                      <a onclick=\"showUpdateBlock(courseUpdateBlock${course.courseId})\" title=\"Close\" class=\"close\">X</a>");
            pageContext.getOut().write("                      <h1>Course creating...</h1>");
            pageContext.getOut().write("                      <form name=\"courseCreation\" method=\"post\" action=\"command\">");
            pageContext.getOut().write("                        <input type=\"hidden\" name=\"command\" value=\"update-course\">");
            pageContext.getOut().write("                        <input type=\"hidden\" name=\"courseRegion\" value=\"${requestScope.courseRegion.toString()}\">");
            pageContext.getOut().write("                        <input type=\"hidden\" name=\"courseType\" value=\"${requestScope.courseType.toString()}\">");
            pageContext.getOut().write("                        <input type=\"hidden\" name=\"courseAvailability\" value=\"${requestScope.courseAvailability}\">");
            pageContext.getOut().write("                        <p align=\"left\">");
            pageContext.getOut().write("                          <input required style=\"\" name=\"title\"  type=\"text\" placeholder=\"Enter course title\">");
            pageContext.getOut().write("                        </p>");
            pageContext.getOut().write("                        <p align=\"left\">");
            pageContext.getOut().write("                    <textarea name=\"courseDescription\" value=\"\" required rows=\"12\" cols=\"29\" placeholder=\"Enter course description\">");
            pageContext.getOut().write("                    </textarea>");
            pageContext.getOut().write("                        </p>");
            pageContext.getOut().write("                        <div class=\"select-conteiner\">");
            pageContext.getOut().write("                          <select style=\"\" required name=\"availability\">");
            pageContext.getOut().write("                            <option selected value=\"0\">Available</option>");
            pageContext.getOut().write("                            <option value=\"1\">Not available</option>");
            pageContext.getOut().write("                          </select>");
            pageContext.getOut().write("                          <select style=\"\" required name=\"type\">");
            pageContext.getOut().write("                            <option value=\"Java\">Java</option>");
            pageContext.getOut().write("                            <option value=\"PHP\">PHP</option>");
            pageContext.getOut().write("                            <option value=\"Testing\">Testing</option>");
            pageContext.getOut().write("                          </select>");
            pageContext.getOut().write("                          <select style=\"\" required name=\"region\">");
            pageContext.getOut().write("                            <option selected value=\"Minsk, Belarus\">Minsk, Belarus</option>");
            pageContext.getOut().write("                            <option value=\"Brest, Belarus\">Brest, Belarus</option>");
            pageContext.getOut().write("                            <option value=\"Gomel, Belarus\">Gomel, Belarus</option>");
            pageContext.getOut().write("                          </select>");
            pageContext.getOut().write("                          <input name=\"leadId\" type=\"text\" placeholder=\"Teacher id\">");
            pageContext.getOut().write("                          <input name=\"commit\" type=\"submit\" value=\"Create\">");
            pageContext.getOut().write("                          <input name=\"commit\" type=\"submit\" value=\"Delete\">");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("              </div>");
            pageContext.getOut().write("            </form>");
            pageContext.getOut().write("          </div>");
            pageContext.getOut().write("        </div>");
            pageContext.getOut().write("      </div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
