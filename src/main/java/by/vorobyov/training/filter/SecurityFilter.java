package by.vorobyov.training.filter;

import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.security.Security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    public static final String PARAMETER_COMMAND = "command";
    public static Integer STATUS_STUDENT = 0;
    public static Integer STATUS_TEACHER = 1;
    public static Integer STATUS_ADMIN = 2;


    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(true);
        User currentUser = (User) session.getAttribute(AttributeName.USER);

        String command = httpServletRequest.getParameter(PARAMETER_COMMAND);
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
                httpServletRequest.getRequestDispatcher(page).forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
