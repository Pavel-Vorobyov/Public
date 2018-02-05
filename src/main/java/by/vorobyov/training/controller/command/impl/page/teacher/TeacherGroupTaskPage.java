package by.vorobyov.training.controller.command.impl.page.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.TeacherGroupTask;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.nameresource.AttributeName;
import by.vorobyov.training.nameresource.JspPageName;
import by.vorobyov.training.service.impl.TeacherService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherGroupTaskPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        TeacherService teacherService = new TeacherService();
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
