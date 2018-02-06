package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.CommonServiceImpl;
import by.vorobyov.training.service.impl.ServerServiceImpl;
import by.vorobyov.training.service.validator.IValidator;
import by.vorobyov.training.service.validator.impl.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * adds a new user.
 */
public class SingUp implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";

    /**
     * If the command is successful, then the user wil be redirected
     * to the {@link by.vorobyov.training.controller.command.impl.page.common.UserHomePage user home page}.<br>
     * The user's parameters, extracted from the request are packed
     * into a transfer object {@link User User} and
     * validates on the service layer. If the data is not correct,
     * then the control passed to the catch block of <tt>ValidatorException</tt>
     * and forwarding to the bad request page.<br>
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
        ServerServiceImpl serverServiceImpl = new ServerServiceImpl();
        IValidator<User> userValidator = new UserValidator();

        try {
            User currentUser = new User();
            currentUser.setEmail(request.getParameter(USER_EMAIL));
            currentUser.setLogin(request.getParameter(USER_LOGIN));
            currentUser.setPassword(request.getParameter(USER_PASSWORD));

            boolean userCheck = userValidator.checkEntity(currentUser);

            if (userCheck) {
                currentUser = commonServiceImpl.addUser(currentUser);

                if (!currentUser.isEmpty()) {

                    serverServiceImpl.sendVerifyingLetter(currentUser.getEmail(), currentUser);

                    request.getSession(true).setAttribute(AttributeName.USER, currentUser);
                    request.getRequestDispatcher(URLCommand.TRAINING_PAGE).forward(request, response);

                } else {
                    String statusMessage = "Sorry, this member is already registered!";
                    request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
                    request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
                }

            } else {
                String statusMessage = "Please enter correct parameters!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
                request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
            }


        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
