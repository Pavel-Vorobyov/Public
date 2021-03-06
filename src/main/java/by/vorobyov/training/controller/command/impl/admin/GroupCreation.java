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
public class GroupCreation implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String GROUP_ID = "groupId";
    public static final String GROUP_TITLE = "title";
    public static final String GROUP_DESCRIPTION = "groupDescription";
    public static final String GROUP_STATUS = "status";
    public static final String GROUP_TYPE = "type";
    public static final String GROUP_REGION = "region";
    public static final String GROUP_COURSE_ID = "courseId";
    public static final String GROUP_LEAD_ID = "leadId";

    /**
     * If the command is successful, then the page is updated
     * and a new group record is displayed.
     * The group parameters, extracted from request puts into transfer object {@link by.vorobyov.training.dto.entity.WorkGroup WorkGroup}.
     * Then in service {@link AdminServiceImpl AdminServiceImpl} creates a new group.
     * If group created successful some filter parameters ate puts into request and
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
            workGroup.setTitle(request.getParameter(GROUP_TITLE));
            workGroup.setDescription(request.getParameter(GROUP_DESCRIPTION));
            workGroup.setStatus(Integer.parseInt(request.getParameter(GROUP_STATUS)));
            workGroup.setType(request.getParameter(GROUP_TYPE));
            workGroup.setRegion(request.getParameter(GROUP_REGION));
            workGroup.setCourseId(Integer.parseInt(request.getParameter(GROUP_COURSE_ID)));
            workGroup.setLeadId(Integer.parseInt(request.getParameter(GROUP_LEAD_ID)));

            boolean createSuccess = adminServiceImpl.createWorkGroup(workGroup);

            if (createSuccess) {
                request.setAttribute(AdminGroupModifyPage.GROUP_STATUS, workGroup.getStatus());
                request.setAttribute(AdminGroupModifyPage.GROUP_TYPE, workGroup.getType());
                request.setAttribute(AdminGroupModifyPage.GROUP_REGION, workGroup.getRegion());
                request.setAttribute(AttributeName.STATUS_MESSAGE, "Group has been created successful!");

                request.getRequestDispatcher(URLCommand.ADMIN_GROUP_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }

    }
}
