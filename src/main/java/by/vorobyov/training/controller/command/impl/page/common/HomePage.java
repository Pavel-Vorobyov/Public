package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes object-command, which forwards to the home page.
 */
public class HomePage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Checks the availability status message and puts it into request.
     * Then forwards to the home page.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusMessage = request.getParameter(AttributeName.STATUS_MESSAGE);

        if (statusMessage != null) {
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
        }

        request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
    }
}
