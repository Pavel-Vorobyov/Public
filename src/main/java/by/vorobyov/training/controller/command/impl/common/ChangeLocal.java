package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.nameresource.AttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLocal implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String LOCALE = "local";
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
