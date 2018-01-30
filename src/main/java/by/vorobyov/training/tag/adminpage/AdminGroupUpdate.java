//package by.vorobyov.training.tag.adminpage;
//
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.tagext.TagSupport;
//import java.io.IOException;
//
//public class AdminGroupUpdate extends TagSupport {
//    private String groupTitle;
//    private String groupDescription;
//    private Integer
//
//    @Override
//    public int doStartTag() throws JspException {
//        try {
//            pageContext.getOut().write("<div style=\"display: block;\" id=\"groupUpdateBlock" + groupId + "\" class=\"courseModify\">");
//            pageContext.getOut().write("  <div class=\"container\">");
//            pageContext.getOut().write("    <div class=\"modify\">");
//            pageContext.getOut().write(   "      <a onclick=\"showUpdateBlock(groupUpdateBlock" + groupId + ")\" title=\"Close\" class=\"close\">X</a>");
//            pageContext.getOut().write("       <h1>Work group updating...</h1>");
//            pageContext.getOut().write("       <form name=\"groupUpdate\" method=\"post\" action=\"command\">");
//            pageContext.getOut().write("          <input type=\"hidden\" name=\"command\" value=\"update-group\">");
//            pageContext.getOut().write("          <input type=\"hidden\" name=\"courseRegion\" value=\"${requestScope.courseRegion.toString()}\">");
//            pageContext.getOut().write("          <input type=\"hidden\" name=\"courseType\" value=\"${requestScope.courseType.toString()}\">");
//            pageContext.getOut().write("          <input type=\"hidden\" name=\"courseAvailability\" value=\"${requestScope.courseAvailability}\">");
//            pageContext.getOut().write("          <p align=\"left\">");
//            pageContext.getOut().write("             <input required style=\"\" name=\"title\" id=\"title\"  type=\"text\" placeholder=\"Enter group title\">");
//            pageContext.getOut().write("           </p>");
//            pageContext.getOut().write("          <p align=\"left\">");
//            pageContext.getOut().write("             <textarea id=\"courseDescription\" name=\"courseDescription\" required rows=\"12\" cols=\"29\" placeholder=\"Enter group description\"></textarea>");
//            pageContext.getOut().write("             <div class=\"select-conteiner\">");
//            pageContext.getOut().write("               <select required id=\"availability\" name=\"availability\">");
//            pageContext.getOut().write("                 <c:choose>");
//            pageContext.getOut().write("                    <c:when test=\"${workGroup.status eq 1}\">");
//            pageContext.getOut().write("                       <option selected value=\"0\">Forming...</option>");
//            pageContext.getOut().write("                       <option selected value=\"1\">Completed</option>");
//            pageContext.getOut().write("                    </c:when>");
//            pageContext.getOut().write("                    <c:otherwise>");
//            pageContext.getOut().write("                       <option selected value=\"0\">Forming...</option>");
//            pageContext.getOut().write("                       <option value=\"1\">Completed</option>");
//            pageContext.getOut().write("                    </c:otherwise>");
//            pageContext.getOut().write("                    </c:choose>");
//            pageContext.getOut().write("                </select>");
//            pageContext.getOut().write("                <select required id=\"type\" name=\"type\">");
//            pageContext.getOut().write("                  <c:choose>");
//            pageContext.getOut().write("                    <c:when test=\"${workGroup.type eq 'Java'}\">");
//            pageContext.getOut().write("                    <option selected value=\"Java\">Java</option>");
//            pageContext.getOut().write("                    <option value=\"PHP\">PHP</option>");
//            pageContext.getOut().write("                    <option value=\"Testing\">Testing</option>");
//            pageContext.getOut().write("                  </c:when>");
//            pageContext.getOut().write("                  <c:when test=\"${workGroup.type eq 'PHP'}\">");
//            pageContext.getOut().write("                    <option value=\"Java\">Java</option>");
//            pageContext.getOut().write("                    <option selected value=\"PHP\">PHP</option>");
//            pageContext.getOut().write("                    <option value=\"Testing\">Testing</option>");
//            pageContext.getOut().write("                  </c:when>");
//            pageContext.getOut().write("                  <c:otherwise>");
//            pageContext.getOut().write("                    <option value=\"Java\">Java</option>");
//            pageContext.getOut().write("                    <option value=\"PHP\">PHP</option>");
//            pageContext.getOut().write("                    <option selected value=\"Testing\">Testing</option>");
//            pageContext.getOut().write("                  </c:otherwise>");
//            pageContext.getOut().write("                    </c:choose>");
//            pageContext.getOut().write("                  </select>");
//            pageContext.getOut().write("                  <select required id=\"region\" name=\"region\">");
//            pageContext.getOut().write("                     <c:choose>");
//            pageContext.getOut().write("                        <c:when test=\"${workGroup.region eq 'Minsk, Belarus'}\">");
//            pageContext.getOut().write("                          <option selected value=\"Minsk, Belarus\">Minsk, Belarus</option>");
//            pageContext.getOut().write("                          <option value=\"Brest, Belarus\">Brest, Belarus</option>");
//            pageContext.getOut().write("                          <option value=\"Gomel, Belarus\">Gomel, Belarus</option>");
//            pageContext.getOut().write("                        </c:when>");
//            pageContext.getOut().write("                        <c:when test=\"${workGroup.region eq 'Brest, Belarus'}\">");
//            pageContext.getOut().write("                          <option value=\"Minsk, Belarus\">Minsk, Belarus</option>");
//            pageContext.getOut().write("                          <option selected value=\"Brest, Belarus\">Brest, Belarus</option>");
//            pageContext.getOut().write("                          <option value=\"Gomel, Belarus\">Gomel, Belarus</option>");
//            pageContext.getOut().write("                        </c:when>");
//            pageContext.getOut().write("                        <c:otherwise>");
//            pageContext.getOut().write("                          <option value=\"Minsk, Belarus\">Minsk, Belarus</option>");
//            pageContext.getOut().write("                          <option value=\"Brest, Belarus\">Brest, Belarus</option>");
//            pageContext.getOut().write("                          <option selected value=\"Gomel, Belarus\">Gomel, Belarus</option>");
//            pageContext.getOut().write("                        </c:otherwise>");
//            pageContext.getOut().write("                          </c:choose>");
//            pageContext.getOut().write("                   </select>");
//            pageContext.getOut().write("                     <input name=\"leadId\" id=\"courseId\" type=\"text\" placeholder=\"Course id\">");
//            pageContext.getOut().write("                     <input name=\"leadId\" id=\"leadId\" type=\"text\" placeholder=\"Teacher id\">");
//            pageContext.getOut().write("                     <input name=\"commit\" type=\"submit\" value=\"Create\">");
//            pageContext.getOut().write("                     <a onclick=\"\" class=\"deleteGroupButton\">Delete</a>");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return SKIP_BODY;
//    }
//
//    @Override
//    public int doEndTag() throws JspException {
//        try {
//            pageContext.getOut().write("           </div>");
//            pageContext.getOut().write("          </p>");
//            pageContext.getOut().write("        </form>");
//            pageContext.getOut().write("      </div>");
//            pageContext.getOut().write("    </div>");
//            pageContext.getOut().write("</div>");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return EVAL_PAGE;
//    }
//}
