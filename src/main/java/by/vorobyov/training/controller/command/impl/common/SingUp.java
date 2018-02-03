package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.nameresource.JspPageName;
import by.vorobyov.training.controller.nameresource.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.controller.nameresource.AttributeName;
import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.service.ServerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingUp implements ICommand {
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonService();
        ServerService serverService = new ServerService();

        try {
            User currentUser = new User();
            currentUser.setEmail(request.getParameter(USER_EMAIL));
            currentUser.setLogin(request.getParameter(USER_LOGIN));
            currentUser.setPassword(request.getParameter(USER_PASSWORD));


            currentUser = commonService.addUser(currentUser);

            if (!currentUser.isEmpty()) {

                try {
                    serverService.sendVerifyingLetter(currentUser.getEmail(), currentUser);
                } catch (DAOException e) {
                    e.printStackTrace();
                }

                request.getSession(true).setAttribute(AttributeName.USER, currentUser);
                request.getRequestDispatcher(URLCommand.TRAINING_PAGE).forward(request, response);
            } else {
                String statusMessage = "Sorry, this member is already regirsted!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
                request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
