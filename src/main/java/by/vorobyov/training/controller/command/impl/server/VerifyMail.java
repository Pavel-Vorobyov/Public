package by.vorobyov.training.controller.command.impl.server;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.impl.common.SingIn;
import by.vorobyov.training.controller.nameresource.AttributeName;
import by.vorobyov.training.controller.nameresource.JspPageName;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.service.ServerService;

import javax.mail.search.IntegerComparisonTerm;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyMail implements ICommand {
    public static final String USER_ID = "userId";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServerService serverService = new ServerService();
        String statusMessage;

        Integer userId = Integer.parseInt(request.getParameter(USER_ID));

        try {
            boolean mailStatusUpdateSuccess = serverService.updateUserMailStatus(ServerService.MAIL_STATUS_CHECKED, userId);

            statusMessage = mailStatusUpdateSuccess ? "Your mail has been verified"
                    : "Happened some problem with varifying your mail...";

            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
