package by.vorobyov.training.controller.command.impl.server;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.service.impl.ServerServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyMail implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_ID = "userId";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServerServiceImpl serverServiceImpl = new ServerServiceImpl();
        String statusMessage;

        Integer userId = Integer.parseInt(request.getParameter(USER_ID));

        try {
            boolean mailStatusUpdateSuccess = serverServiceImpl.updateUserMailStatus(ServerServiceImpl.MAIL_STATUS_CHECKED, userId);

            statusMessage = mailStatusUpdateSuccess ? "Your mail has been verified"
                    : "Happened some problem with varifying your mail...";

            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);

        } catch (DAOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
