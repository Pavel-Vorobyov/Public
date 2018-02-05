package by.vorobyov.training.controller.command.impl.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.dto.entity.Task;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.TeacherServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeacherCreateTask implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String TASK_TITLE = "title";
    public static final String DEADLINE = "deadline";
    public static final String TASK_DESCRIPTION = "description";
    public static final String GROUP_ID = "group-id";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskTitle = request.getParameter(TASK_TITLE);
        String deadline = request.getParameter(DEADLINE);
        String taskDescription = request.getParameter(TASK_DESCRIPTION);
        Integer groupId = Integer.parseInt(request.getParameter(GROUP_ID));
        User teacher = (User)request.getSession().getAttribute(AttributeName.USER);

        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        try {
            Task task = new Task();

            String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

            task.setTitle(taskTitle);
            task.setCreationTime(currentDate);
            task.setDeadline(deadline);
            task.setDescription(taskDescription);
            task.setAuthorId(teacher.getUserId());

            boolean result = teacherService.createTask(task, groupId);

            if (result) {
                request.getRequestDispatcher(URLCommand.TEACHER_GROUP_TASK_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
