package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.nameresource.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminUserModifyPage;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.controller.nameresource.AttributeName;
import by.vorobyov.training.service.impl.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdate implements ICommand {
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_CREATION_TIME = "creationTime";
    public static final String USER_STATUS = "userStatus";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();

        UserData userData = new UserData();
        User user = new User();

        try {
            user.setUserId(Integer.parseInt(request.getParameter(USER_ID)));
            user.setStatus(Integer.parseInt(request.getParameter(USER_STATUS)));
            user.setEmail(request.getParameter(USER_EMAIL));
            userData.setName(request.getParameter(USER_NAME));
            userData.setSurname(request.getParameter(USER_SURNAME));

            boolean updateSuccess = adminService.updateUser(user, userData);

            if (updateSuccess) {
                String statusMessage = "Work group has been updated successful!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

                request.setAttribute(AdminUserModifyPage.FILTER_USER_STATUS, request.getParameter(AdminUserModifyPage.FILTER_USER_STATUS));
                request.getRequestDispatcher(URLCommand.ADMIN_USER_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
