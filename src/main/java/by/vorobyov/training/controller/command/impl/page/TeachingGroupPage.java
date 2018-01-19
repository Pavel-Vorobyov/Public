package by.vorobyov.training.controller.command.impl.page;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.dto.entity.Task;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
            List<Task> groupTask = commonService.takeGroupTaskListByGroupId(workGroupId);

            if (!groupTask.isEmpty()) {

                for (int i=0; i<groupTask.size(); i++) {
                    String taskHerf = URLCommand.TEACHING_TASK_PAGE + groupTask.get(i).getTaskId()
                            + "&" + WORK_GROUP_ID + "=" + workGroupId;
                    groupTask.get(i).setTaskHerf(taskHerf);
                }
                request.setAttribute(AttributeName.GROUP_TASK_LIST, groupTask);
            }

            request.getRequestDispatcher(JspPageName.TEACHING_GROUP_PAGE).include(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(JspPageName.TEACHING_GROUP_PAGE).forward(request, response);
    }
}
