package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.impl.admin.CourseUpdate;
import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes object-command, which applied student for te course.
 */
public class ApplyForCourse implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Gets user id from session.
     * If user id is null forwards to the training portal page with status message.
     * If user id does not match the status of a student forwards to the
     * training portal page with status message.
     * Applies student for the course by
     * {@link by.vorobyov.training.service.impl.StudentServiceImpl StudentServiceImpl}
     * Checks in database if student applied for this course already.
     * If student applied forwards to the training portal page with status message.
     * If not Applied and than redirect to the training portal with status message.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentServiceImpl studentService = new StudentServiceImpl();

        User student = (User) request.getSession().getAttribute(AttributeName.USER);
        Integer courseId = Integer.parseInt(request.getParameter(CourseUpdate.COURSE_ID));
        String statusMessage;

        if (student == null) {
            statusMessage = "To apply for course please log in first!";
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(URLCommand.TRAINING_PORTAL).forward(request, response);
        }

        if (student.getStatus() != UserDAO.STATUS_STUDENT) {
            statusMessage = "Sorry, only student may apply for course!";
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(URLCommand.TRAINING_PORTAL).forward(request, response);
        }

        try {
            boolean applySuccess = studentService.applyForCourse(student, courseId);

            if (applySuccess) {
                statusMessage = "You have been applied successful!";
            } else {
                statusMessage = "You are already applied for this course!";
            }

            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.getRequestDispatcher(URLCommand.TRAINING_PORTAL).forward(request, response);

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
