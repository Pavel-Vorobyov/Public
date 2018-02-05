package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.impl.admin.CourseUpdate;
import by.vorobyov.training.controller.command.impl.common.ChangeLocal;
import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.nameresource.AttributeName;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.StudentService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplyForCourse implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();

        User student = (User) request.getSession().getAttribute(AttributeName.USER);
        Integer courseId = Integer.parseInt(request.getParameter(CourseUpdate.COURSE_ID));
        String currentURL = request.getParameter(AttributeName.CURRENT_URL);
        String statusMessage;

        if (student == null || student.getStatus() != UserDAO.STATUS_STUDENT) {
            statusMessage = "To apply for course please log in first!";
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(currentURL);
        }

        try {
            boolean applySuccess = studentService.applyForCourse(student, courseId);

            if (applySuccess) {
                statusMessage = "You have been applied successful!";
            } else {
                statusMessage = "You are already applied for this course!";
            }

            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(AttributeName.CURRENT_URL);

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
