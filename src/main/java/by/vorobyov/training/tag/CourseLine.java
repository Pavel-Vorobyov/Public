//package by.vorobyov.training.tag;
//
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.tagext.TagSupport;
//import java.io.IOException;
//
//public class CourseLine extends TagSupport {
//    private String courseTitle = null;
//    private String courseLocation = null;
//    private String courseLanguage = null;
//
//    public void setCourseTitle(String courseTitle) {
//        this.courseTitle = courseTitle;
//    }
//
//    public void setCourseLocation(String courseLocation) {
//        this.courseLocation = courseLocation;
//    }
//
//    public void setCourseLanguage(String courseLanguage) {
//        this.courseLanguage = courseLanguage;
//    }
//
//    @Override
//    public int doStartTag() throws JspException {
//        try {
//            pageContext.getOut().write("<li class=\"item-body\">");
//            pageContext.getOut().write("<span class=\"group-name\" title=\"Lolli\"><a href=\"#\">");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return
//    }
//
//    @Override
//    public int doEndTag() throws JspException {
//        try {
//            return super.doEndTag();
//
//        }
//        return super.doEndTag();
//    }
//}
