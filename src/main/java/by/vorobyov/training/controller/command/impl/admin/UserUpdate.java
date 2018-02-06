package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminUserModifyPage;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * updates a user.
 */
public class UserUpdate implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_ID = "userId";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_STATUS = "userStatus";

    /**
     * If the command is successful, then the page is updated
     * and a user record is updated.
     * The user parameters, extracted from request puts into transfer objects {@link by.vorobyov.training.dto.entity.User User}
     * and {@link by.vorobyov.training.dto.entity.UserData UserData}.
     * Then in service {@link AdminServiceImpl AdminServiceImpl} updates a user.
     * If user updated successful some filter parameters ate puts into request and
     * forwarding to the current page.<br>
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
        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

        UserData userData = new UserData();
        User user = new User();

        try {
            user.setUserId(Integer.parseInt(request.getParameter(USER_ID)));
            user.setStatus(Integer.parseInt(request.getParameter(USER_STATUS)));
            user.setEmail(request.getParameter(USER_EMAIL));
            userData.setName(request.getParameter(USER_NAME));
            userData.setSurname(request.getParameter(USER_SURNAME));

            boolean updateSuccess = adminServiceImpl.updateUser(user, userData);

            if (updateSuccess) {
                String statusMessage = "Work group has been updated successful!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

                request.setAttribute(AdminUserModifyPage.FILTER_USER_STATUS, request.getParameter(AdminUserModifyPage.FILTER_USER_STATUS));
                request.getRequestDispatcher(URLCommand.ADMIN_USER_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
