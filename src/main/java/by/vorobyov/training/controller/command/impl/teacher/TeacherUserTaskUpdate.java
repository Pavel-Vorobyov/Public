package by.vorobyov.training.controller.command.impl.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.database.dao.util.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherUserTaskUpdate implements ICommand {
    public static final String USER_TASK_ID = "userTaskId";
    public static final String TASK_COMMENT = "taskComment";
    public static final String USER_TASK_STATUS = "taskStatus";
    public static final String GROUP_TITLE = "groupTitle";
    public static final String TASK_TITLE = "taskTitle";
    public static final String GROUP_ID = "groupId";
    public static final String TASK_ID = "taskId";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        UserTask userTask = new UserTask();

        Integer groupId = Integer.parseInt(request.getParameter(GROUP_ID));
        Integer taskId = Integer.parseInt(request.getParameter(TASK_ID));
        String taskTitle = request.getParameter(TASK_TITLE);
        String groupTitle = request.getParameter(GROUP_TITLE);

        try {
                userTask.setUserTaskId(Integer.parseInt(request.getParameter(USER_TASK_ID)));
                userTask.setDeadline(request.getParameter(UserTaskColumnName.DEADLINE));
                userTask.setEstimate(Integer.parseInt(request.getParameter(UserTaskColumnName.ESTIMATE)));
                userTask.setStatus(Integer.parseInt(request.getParameter(USER_TASK_STATUS)));
                userTask.setComment(request.getParameter(TASK_COMMENT));

                boolean result = teacherService.userTaskUpdate(userTask);

                if (result) {
                    String resultURL = URLCommand.TEACHER_USER_TASK_PAGE + taskId + "&"
                            + GROUP_ID + "=" + groupId + "&" + GROUP_TITLE + "=" + groupTitle
                            + "&" + TASK_TITLE + "=" + taskTitle;
                    response.sendRedirect(resultURL);
                }

        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
