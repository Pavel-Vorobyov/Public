package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.CommonServiceImpl;
import by.vorobyov.training.resource.AttributeName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * puts transfer object {@link by.vorobyov.training.dto.entity.User User}
 * into session.
 */
public class SingIn implements ICommand{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Integer MAIL_STATUS_CONFIRMED = 1;
    public static final String TRAINING_PAGE = "command?command=training_page";
    public final static String LOGIN = "login";
    public final static String PASSWORD = "password";

    /**
     * If the command is successful, then the user will be redirect
     * to the {@link by.vorobyov.training.controller.command.impl.page.common.TrainingPage TrainingPage}.<br>
     * The user's parameters, extracted from the request are packed
     * into a transfer object {@link User User} and
     * validates on the service layer. If the data is not correct,
     * then the control passed to the catch block of <tt>ValidatorException</tt>
     * and forwarding to the home page with message.<br>
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
        User user = new User();

        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(request.getParameter(PASSWORD));

        CommonServiceImpl commonServiceImpl = new CommonServiceImpl();

            try {
                User checkedUser = commonServiceImpl.checkUser(user);
                if (!checkedUser.isEmpty()) {
                    UserData userData = commonServiceImpl.getUserDataById(checkedUser.getUserId());

                    request.getSession(true).setAttribute(AttributeName.USER, checkedUser);
                    request.getSession().setAttribute(AttributeName.USER_DATA, userData);

                    if (checkedUser.getMailStatus() != MAIL_STATUS_CONFIRMED ) {
                        String statusMessage = "Your mail is still not checked!\n" +
                                "If you haven't got a verified mail yet, please con212 this link!";
                        request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
                    }

                    response.sendRedirect(TRAINING_PAGE);
                } else {
                    String statusMessage = "Invalid login or password!";
                    request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
                    request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
                }
            } catch (ServiceException e) {
                LOGGER.log(Level.ERROR, e);
            }
    }
}
