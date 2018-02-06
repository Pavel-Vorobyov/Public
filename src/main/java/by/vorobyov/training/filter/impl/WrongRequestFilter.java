package by.vorobyov.training.filter.impl;

import by.vorobyov.training.filter.AbstractFilter;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.URLCommand;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The filter checks the input URL. If it's not the request of (js, css or img) files
 * the user will be redirected on home page with with the corresponding message.
 *
 * @see by.vorobyov.training.filter.AbstractFilter
 * @see by.vorobyov.training.controller.Controller
 */
public class WrongRequestFilter extends AbstractFilter implements Filter {
    private final static String viewRegExp = "^/(js|css|img).+$";
    private final static String servletRegExp = "^/command.*$";

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String URI = request.getRequestURI();

        if (test(viewRegExp, URI)) {

            filterChain.doFilter(request, response);

        } else if (test(servletRegExp, URI)) {

            filterChain.doFilter(request, response);

        } else {
            String statusMessage = "Sorry, something goes bad!";
            String resultURL = URLCommand.HOME_PAGE + "&" +AttributeName.STATUS_MESSAGE + "=" + statusMessage;

            response.sendRedirect(resultURL);
        }
    }

    /**
     * @param regExp regex expression with which the url will be compared
     * @param url URL which will be compare with regex
     * @return matcher of url to regExp
     */
    private boolean test(String regExp, String url) {
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(url);
        return m.matches();
    }

}
