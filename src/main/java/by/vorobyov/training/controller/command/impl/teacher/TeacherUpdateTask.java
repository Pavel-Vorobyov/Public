package by.vorobyov.training.controller.command.impl.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.dto.entity.Task;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.JspPageName;
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
 * updates a task for group.
 */
public class TeacherUpdateTask implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String TASK_ID = "task-id";

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
        String tskUpdSucc = "Task has been updated successful!";
        String tskUpdUnsecc = "Something goes bad...\n" +
                "Task hasn't been updated!";
        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        try {
            Task task = new Task();

            task.setTaskId(Integer.parseInt(request.getParameter(TASK_ID)));
            task.setTitle(request.getParameter(TeacherCreateTask.TASK_TITLE));
            task.setDeadline(request.getParameter(TeacherCreateTask.DEADLINE));
            task.setDescription(request.getParameter(TeacherCreateTask.TASK_DESCRIPTION));

            boolean updateSuccessful = teacherService.updateTask(task);

            String statusMessage = updateSuccessful ? tskUpdSucc : tskUpdUnsecc;
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

            request.getRequestDispatcher(URLCommand.TEACHER_GROUP_TASK_PAGE).forward(request, response);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
