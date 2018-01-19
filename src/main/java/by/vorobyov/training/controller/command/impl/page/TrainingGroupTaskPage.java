package by.vorobyov.training.controller.command.impl.page;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.TeachingUserTask;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TrainingGroupTaskPage implements ICommand {
    public static final String TASK_ID = "task-id";
    public static final String GROUP_ID = "group-id";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonService();
        Integer taskId = Integer.parseInt(request.getParameter(TASK_ID));
        Integer groupId = Integer.parseInt(request.getParameter(GROUP_ID));
        List<TeachingUserTask> teachingUserTaskList;

        try {
            teachingUserTaskList = commonService.takeTeacherUserTask(taskId, groupId);

            if (!teachingUserTaskList.isEmpty()) {
                request.setAttribute(AttributeName.TEACHING_USER_TASK, teachingUserTaskList);
                request.getRequestDispatcher(JspPageName.TEACHING_TASK_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher(JspPageName.TEACHING_TASK_PAGE).forward(request, response);
    }
}
