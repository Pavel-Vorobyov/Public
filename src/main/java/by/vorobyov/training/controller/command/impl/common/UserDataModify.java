package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.CommonServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * updates a user data.
 */
public class UserDataModify implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";

    /**
     * If the command is successful, then the page is updated
     * and a new user data will be shown.<br>
     * The user's parameters, extracted from the request are packed
     * into a transfer object {@link User User} and
     * validates on the service layer. If the data is not correct,
     * validator returns "false" and request redirects to the current page
     * with message.<br>
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
        CommonServiceImpl commonServiceImpl = new CommonServiceImpl();

        User modifyingUser = (User) request.getSession().getAttribute(AttributeName.USER);
        UserData modifyingUserData = new UserData();

        try {
            modifyingUserData.setUserId(modifyingUser.getUserId());
            modifyingUserData.setName(request.getParameter(USER_NAME));
            modifyingUserData.setSurname(request.getParameter(USER_SURNAME));

            modifyingUser.setLogin(request.getParameter(USER_LOGIN));
            modifyingUser.setPassword(request.getParameter(USER_PASSWORD));
            modifyingUser.setEmail(request.getParameter(USER_EMAIL));

            boolean userDataUpdateSuccess = commonServiceImpl.userDataUpdate(modifyingUser, modifyingUserData);
            UserData currentUserData = commonServiceImpl.getUserDataById(modifyingUser.getUserId());

            if (userDataUpdateSuccess) {

                request.getSession().removeAttribute(AttributeName.USER);
                request.getSession().removeAttribute(AttributeName.USER_DATA);
                request.getSession().setAttribute(AttributeName.USER, modifyingUser);
                request.getSession().setAttribute(AttributeName.USER_DATA, currentUserData);

                response.sendRedirect(URLCommand.USER_HOME_PAGE);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
