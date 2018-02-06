package by.vorobyov.training.controller.command.impl.server;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.exception.ServiceException;
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

/**
 * Class describes object-command, which verified user mail.
 */
public class VerifyMail implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_ID = "userId";

    /**
     * Gets user id from URL than updates mail status in user table by
     * {@link by.vorobyov.training.service.impl.ServerServiceImpl ServerServiceImpl}.
     * After forwards with status message to the home page.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServerServiceImpl serverServiceImpl = new ServerServiceImpl();
        String statusMessage;

        Integer userId = Integer.parseInt(request.getParameter(USER_ID));

        try {
            boolean mailStatusUpdateSuccess = serverServiceImpl.updateUserMailStatus(ServerServiceImpl.MAIL_STATUS_CHECKED, userId);

            statusMessage = mailStatusUpdateSuccess ? "Your mail has been verified successful!"
                    : "Happened some problem with verifying your mail...";

            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
