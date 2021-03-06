package by.vorobyov.training.controller.command.impl.page.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.UserForAdmin;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class describes object-command, which forwards to the user modify page
 * to update user.
 */
public class AdminUserModifyPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Integer USER_STATUS_STUDENT = 0;
    public static final String FILTER_USER_STATUS = "filterUserStatus";


    /**
     * Gets by filter a {@link by.vorobyov.training.dto.entity.User user}
     * and {@link by.vorobyov.training.dto.entity.UserData user data}list
     * from database by {@link AdminServiceImpl admin service}.<br>
     * Then puts some filter data into request and forwards to the course modify page.<br>
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
        List<UserForAdmin> userForAdminList;

        Integer userStatus = USER_STATUS_STUDENT;

        try {
            if (request.getParameter(FILTER_USER_STATUS) != null) {
                userStatus = Integer.parseInt(request.getParameter(FILTER_USER_STATUS));
            }

            userForAdminList = adminServiceImpl.takeUserListByFilter(userStatus);

            if (!userForAdminList.isEmpty()) {
                request.setAttribute(AttributeName.USER_FOR_ADMIN_LIST, userForAdminList);
                request.setAttribute(FILTER_USER_STATUS, userStatus);

                request.getRequestDispatcher(JspPageName.ADMIN_USER_MODIFY_PAGE).forward(request, response);
            } else {
                String statusMessage = "Sorry, coincidence has been found!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

                request.getRequestDispatcher(JspPageName.ADMIN_USER_MODIFY_PAGE).forward(request, response);
            }



        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
