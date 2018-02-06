package by.vorobyov.training.controller.command.impl.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.database.dao.columnname.UserTaskColumnName;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.TeacherServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * updates a task for student.
 */
public class TeacherUserTaskUpdate implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_TASK_ID = "userTaskId";
    public static final String TASK_COMMENT = "taskComment";
    public static final String USER_TASK_STATUS = "taskStatus";
    public static final String GROUP_TITLE = "groupTitle";
    public static final String TASK_TITLE = "taskTitle";
    public static final String GROUP_ID = "groupId";
    public static final String TASK_ID = "taskId";

    /**
     * If the command is successful, then the page is updated
     * and an updated task record is displayed.
     * The task parameters, extracted from request puts into transfer object {@link by.vorobyov.training.dto.entity.Task Task}.
     * Then updates in service {@link by.vorobyov.training.service.impl.TeacherServiceImpl TeacherServiceImpl}.
     * If task updated successful forwards to the current page.<br>
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
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
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
                            + GROUP_ID + "=" + groupId + "&" + GROUP_TITLE + "=" + groupTitle //!!!! Исправить
                            + "&" + TASK_TITLE + "=" + taskTitle;
                    response.sendRedirect(resultURL);
                }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }


    }
}
