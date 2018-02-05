package by.vorobyov.training.controller.command.impl.teacher;

import by.vorobyov.training.controller.command.ICommand;
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

public class TeacherUpdateTask implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String TASK_ID = "task-id";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        try {
            Task task = new Task();

            task.setTaskId(Integer.parseInt(request.getParameter(TASK_ID)));
            task.setTitle(request.getParameter(TeacherCreateTask.TASK_TITLE));
            task.setDeadline(request.getParameter(TeacherCreateTask.DEADLINE));
            task.setDescription(request.getParameter(TeacherCreateTask.TASK_DESCRIPTION));

            boolean result = teacherService.updateTask(task);

            if (result) { ;
                request.getRequestDispatcher(URLCommand.TEACHER_GROUP_TASK_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }

        request.getRequestDispatcher(JspPageName.TEACHING_GROUP_PAGE).forward(request, response);
    }
}
