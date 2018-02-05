package by.vorobyov.training.controller.command.impl.page.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.UserForAdmin;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.nameresource.AttributeName;
import by.vorobyov.training.nameresource.JspPageName;
import by.vorobyov.training.service.impl.AdminService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminUserModifyPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Integer USER_STATUS_STUDENT = 0;
    public static final String FILTER_USER_STATUS = "filterUserStatus";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        List<UserForAdmin> userForAdminList;

        Integer userStatus = USER_STATUS_STUDENT;

        try {
            if (request.getParameter(FILTER_USER_STATUS) != null) {
                userStatus = Integer.parseInt(request.getParameter(FILTER_USER_STATUS));
            }

            userForAdminList = adminService.takeUserListByFilter(userStatus);

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
