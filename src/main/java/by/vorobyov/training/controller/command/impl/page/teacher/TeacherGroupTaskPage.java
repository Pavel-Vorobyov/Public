package by.vorobyov.training.controller.command.impl.page.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.TeacherGroupTask;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.TeacherServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class describes object-command, which forwards to the teacher group task page.
 */
public class TeacherGroupTaskPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Gets user id from session.
     * Gets {@link by.vorobyov.training.dto.TeacherGroupTask teacher group task} from database
     * by {@link by.vorobyov.training.service.impl.TeacherServiceImpl TeacherServiceImpl}.
     * Than puts them into request and forwards to the teacher-group-task.jsp .<br>
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
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        List<TeacherGroupTask> teacherGroupTaskList;

        try {
            teacherGroupTaskList = teacherService.takeUserTaskByUserId(currentUser.getUserId());
            request.setAttribute(AttributeName.TEACHER_GROUP_TASK_LIST, teacherGroupTaskList);
            request.getRequestDispatcher(JspPageName.TEACHER_GROUP_LIST_PAGE).forward(request, response);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
