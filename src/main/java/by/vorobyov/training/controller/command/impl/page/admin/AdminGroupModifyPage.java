package by.vorobyov.training.controller.command.impl.page.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.AdminServiceImplImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGroupModifyPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Integer GROUP_FORMING = 0;
    public static final String ALL_VALUE = "All";
    public static final String GROUP_REGION = "groupRegion";
    public static final String GROUP_TYPE = "groupType";
    public static final String GROUP_STATUS = "groupStatus";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImplImpl adminServiceImpl = new AdminServiceImplImpl();
        List<WorkGroup> workGroupList;

        Integer groupStatus = GROUP_FORMING;
        String groupType = ALL_VALUE;
        String groupRegion = ALL_VALUE;

        try {

            if (request.getParameter(GROUP_STATUS) != null) {
                groupStatus = Integer.parseInt(request.getParameter(GROUP_STATUS));
            }
            if (request.getParameter(GROUP_TYPE) != null) {
                groupType = request.getParameter(GROUP_TYPE);
            }
            if (request.getParameter(GROUP_REGION) != null) {
                groupRegion = request.getParameter(GROUP_REGION);
            }

            workGroupList = adminServiceImpl.takeGroupListByFilter(groupStatus, groupType, groupRegion);

            request.setAttribute(AttributeName.GROUP_LIST, workGroupList);
            request.setAttribute(GROUP_STATUS, groupStatus);
            request.setAttribute(GROUP_TYPE, groupType);
            request.setAttribute(GROUP_REGION, groupRegion);

            if (!workGroupList.isEmpty()) {

                request.getRequestDispatcher(JspPageName.ADMIN_GROUP_MODIFY_PAGE).forward(request, response);

            } else {
                String statusMessage = "Sorry, coincidence has been found!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

                request.getRequestDispatcher(JspPageName.ADMIN_GROUP_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
