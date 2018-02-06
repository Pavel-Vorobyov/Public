package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * delete course.
 */
public class CourseDelete implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String COURSE_ID = "courseId";
    public static final String DELETE_SUCCESS = "The course has been deleted successful!";

    /**
     * If the command is successful, then the page is updated
     * and a deleted course will not be visible.
     * The course parameters, extracted from request puts into transfer object {@link by.vorobyov.training.dto.entity.Course Course}.
     * Then in service {@link AdminServiceImpl AdminServiceImpl} deletes a course.
     * If course deleted successful some filter parameters ate puts into request and
     * forwarding to the current page.<br>
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
        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

        Integer courseId = Integer.parseInt(request.getParameter(COURSE_ID));

        try {
            boolean result = adminServiceImpl.deleteCourse(courseId);

            if (result) {
                request.setAttribute(AttributeName.STATUS_MESSAGE, DELETE_SUCCESS);

                request.getRequestDispatcher(URLCommand.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
