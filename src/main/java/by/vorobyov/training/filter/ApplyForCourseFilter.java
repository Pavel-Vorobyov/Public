package by.vorobyov.training.filter;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.nameresource.AttributeName;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ApplyForCourseFilter implements Filter {
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
        String currentURL = httpServletRequest.getParameter(AttributeName.CURRENT_URL);

        if (currentUser == null) {
            String statusMessage = "To apply for course please log in first!";
            httpServletRequest.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            httpServletRequest.getRequestDispatcher(currentURL);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
