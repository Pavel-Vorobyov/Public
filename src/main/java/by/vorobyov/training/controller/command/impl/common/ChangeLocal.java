package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * changes the language.
 */
public class ChangeLocal implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String LOCALE = "local";

    /**
     * If the command is successful, then the page is updated
     * and a new language will be shown.<br>
     * Puts a new local "ru" or "en" from request to session object.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lng = request.getParameter(LOCALE);
        String currentUrl = request.getParameter(AttributeName.CURRENT_URL);

        if (lng == null || lng.isEmpty()) {
            String statusMessage = "Sorry, can't change language.\n" +
                    "Something goes wrong...";
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
        } else {
            request.getSession().setAttribute(LOCALE, lng);
        }

        response.sendRedirect(currentUrl);
    }
}
