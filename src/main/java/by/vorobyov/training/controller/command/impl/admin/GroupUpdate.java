package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminGroupModifyPage;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GroupUpdate implements ICommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        WorkGroup workGroup = new WorkGroup();

        try {
            workGroup.setWorkGroupId(Integer.parseInt(request.getParameter(GroupCreation.GROUP_ID)));
            workGroup.setTitle(request.getParameter(GroupCreation.GROUP_TITLE));
            workGroup.setDescription(request.getParameter(GroupCreation.GROUP_DESCRIPTION));
            workGroup.setStatus(Integer.parseInt(request.getParameter(GroupCreation.GROUP_STATUS)));
            workGroup.setType(request.getParameter(GroupCreation.GROUP_TYPE));
            workGroup.setRegion(request.getParameter(GroupCreation.GROUP_REGION));
            workGroup.setCourseId(Integer.parseInt(request.getParameter(GroupCreation.GROUP_COURSE_ID)));
            workGroup.setLeadId(Integer.parseInt(request.getParameter(GroupCreation.GROUP_LEAD_ID)));

            boolean updateSuccess = adminService.updateWorkGroup(workGroup);

            if (updateSuccess) {
                String statusMessage = "Work group has been updated successful!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

                request.setAttribute(AdminGroupModifyPage.GROUP_STATUS, workGroup.getStatus());
                request.setAttribute(AdminGroupModifyPage.GROUP_TYPE, workGroup.getType());
                request.setAttribute(AdminGroupModifyPage.GROUP_REGION, workGroup.getRegion());

                request.getRequestDispatcher(URLCommand.ADMIN_GROUP_MODIFY_PAGE).include(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
