package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GroupDelete implements ICommand {
    public static final String GROUP_ID = "groupId";
    public static final String DELETE_SUCCESS = "The group has been deleted successful!";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();

        Integer groupId = Integer.parseInt(request.getParameter(GROUP_ID));

        try {
            boolean deleteSuccess = adminService.deleteWorkGroup(groupId);

            if (deleteSuccess) {
                request.setAttribute(AttributeName.STATUS_MESSAGE, DELETE_SUCCESS);

                request.getRequestDispatcher(URLCommand.ADMIN_GROUP_MODIFY_PAGE).include(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
