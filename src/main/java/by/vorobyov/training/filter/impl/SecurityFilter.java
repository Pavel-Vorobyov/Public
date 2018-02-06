package by.vorobyov.training.filter.impl;

import by.vorobyov.training.filter.AbstractFilter;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.security.Security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This filter validate the user status to execution certain request,
 * and if the request is forbidden, then forwarding to the page with error 403.
 *
 * @see by.vorobyov.training.filter.AbstractFilter
 */
public class SecurityFilter extends AbstractFilter implements Filter {
    public static final String PARAMETER_COMMAND = "command";
    public static Integer STATUS_STUDENT = 0;
    public static Integer STATUS_TEACHER = 1;
    public static Integer STATUS_ADMIN = 2;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        User currentUser = (User) session.getAttribute(AttributeName.USER);

        String command = request.getParameter(PARAMETER_COMMAND);
        String page = null;

        if (command != null && !command.isEmpty()) {

            if (currentUser != null) {

                if (currentUser.getStatus().equals(STATUS_STUDENT)) {
                    if (!Security.isAllowedToStudent(command)) {
                        page = JspPageName.ERROR_PAGE;
                    }
                }

                if (currentUser.getStatus().equals(STATUS_TEACHER)) {
                    if (!Security.isAllowedToTeacher(command)) {
                        page = JspPageName.ERROR_PAGE;
                    }
                }

                if (currentUser.getStatus().equals(STATUS_ADMIN)) {
                    if (!Security.isAllowedToAdmin(command)) {
                        page = JspPageName.ERROR_PAGE;
                    }
                }
            } else {
                if (!Security.isAllowedToGuest(command)) {
                    page = JspPageName.ERROR_PAGE;
                }
            }

            if (page != null) {
                request.getRequestDispatcher(page).forward(request, response);
            } else {
                filterChain.doFilter(request, response);
            }

        } else {
            String statusMessage = "Sorry, something goes bad!";
            String resultURL = URLCommand.HOME_PAGE + "&" +AttributeName.STATUS_MESSAGE + "=" + statusMessage;

            response.sendRedirect(resultURL);
        }
    }
}
