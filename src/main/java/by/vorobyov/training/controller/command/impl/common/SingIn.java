package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.nameresource.JspPageName;
import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.nameresource.AttributeName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingIn implements ICommand{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Integer MAIL_STATUS_CONFIRMED = 1;
    public static final String TRAINING_PAGE = "command?command=training_page";
    public final static String LOGIN = "login";
    public final static String PASSWORD = "password";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(request.getParameter(PASSWORD));

        CommonService commonService = new CommonService();

            try {
                User checkedUser = commonService.checkUser(user);
                if (!checkedUser.isEmpty()) {
                    UserData userData = commonService.getUserDataById(checkedUser.getUserId());

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
