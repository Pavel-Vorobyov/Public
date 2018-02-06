package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminGroupModifyPage;
import by.vorobyov.training.dto.entity.WorkGroup;
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
 * adds a new group.
 */
public class GroupUpdate implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * If the command is successful, then the page is updated
     * and a group record is updated.
     * The group parameters, extracted from request puts into transfer object {@link by.vorobyov.training.dto.entity.WorkGroup WorkGroup}.
     * Then in service {@link AdminServiceImpl AdminServiceImpl} updates a group.
     * If group update successful some filter parameters ate puts into request and
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

            boolean updateSuccess = adminServiceImpl.updateWorkGroup(workGroup);

            if (updateSuccess) {
                String statusMessage = "Work group has been updated successful!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

                request.setAttribute(AdminGroupModifyPage.GROUP_STATUS, workGroup.getStatus());
                request.setAttribute(AdminGroupModifyPage.GROUP_TYPE, workGroup.getType());
                request.setAttribute(AdminGroupModifyPage.GROUP_REGION, workGroup.getRegion());

                request.getRequestDispatcher(URLCommand.ADMIN_GROUP_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
