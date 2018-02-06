package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.CommonServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes object-command, which forwards to the user home page.
 */
public class UserHomePage implements ICommand{
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Gets {@link by.vorobyov.training.dto.entity.User user} from session.
     * Gets {@link by.vorobyov.training.dto.entity.UserData user data} by
     * {@link by.vorobyov.training.service.impl.CommonServiceImpl CommonServiceImpl}
     * puts them into request than forwards to the user home jsp.
     *
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        CommonServiceImpl commonServiceImpl = new CommonServiceImpl();
        UserData userData;

        try {
            userData = commonServiceImpl.getUserDataById(currentUser.getUserId());
            request.setAttribute(AttributeName.USER_DATA, userData);
            request.getRequestDispatcher(JspPageName.USER_HOME_PAGE).forward(request, response);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
            request.getRequestDispatcher(JspPageName.ERROR_PAGE).forward(request, response);
        }
    }
}
