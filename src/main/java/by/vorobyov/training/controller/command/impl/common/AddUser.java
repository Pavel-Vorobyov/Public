package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser implements ICommand {
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PASSWORD_2 = "login";
    public static final String USER_EMAIL = "email";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonService();

        try {

            User currentUser = new User();
            currentUser.setEmail(request.getParameter(USER_EMAIL));
            currentUser.setLogin(request.getParameter(USER_LOGIN));
            currentUser.setPassword(request.getParameter(USER_PASSWORD));


            currentUser = commonService.addUser(currentUser);

            if (!currentUser.isEmpty()) {
                request.getSession(true).setAttribute(AttributeName.USER, currentUser);
                request.getRequestDispatcher(URLCommand.TRAINING_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
