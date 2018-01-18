package by.vorobyov.training.controller.command.impl.page;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.resource.parametername.WorkGroupParameterName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeachingGroupPage implements ICommand {
    public static final String  WORK_GROUP_ID = "group-id";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonService();

        Integer workGroupId = Integer.parseInt(request.getParameter(WORK_GROUP_ID));
        try {
            WorkGroup workGroup = commonService.takeWorkGroupById(workGroupId);
            if (!workGroup.isGroupEmpty()) {
                request.setAttribute(AttributeName.WORK_GROUP, workGroup);
            }
            request.getRequestDispatcher(JspPageName.TEACHING_GROUP_PAGE).include(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(JspPageName.TEACHING_GROUP_PAGE).forward(request, response);
    }
}
