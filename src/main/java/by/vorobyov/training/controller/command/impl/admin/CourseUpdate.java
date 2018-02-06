package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.ServiceException;
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
 * updates a course.
 */
public class CourseUpdate implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private String updSucc = "Course was updated successful!";
    private String updUnSucc = "Pleas the id of real teacher!";

    public static final String COURSE_ID = "courseId";

    /**
     * If the command is successful, then the page is updated
     * and a course record is updated.
     * The course parameters, extracted from request puts into transfer object {@link by.vorobyov.training.dto.entity.Course Course}.
     * Then in service {@link AdminServiceImpl AdminServiceImpl} updates a course.
     * If course updated successful some filter parameters ate puts into request and
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
        Course course = new Course();

        try {
            course.setType(request.getParameter(CourseCreation.COURSE_TYPE));
            course.setTitle(request.getParameter(CourseCreation.COURSE_TITLE));
            course.setDescription(request.getParameter(CourseCreation.COURSE_DESCRIPTION));
            course.setRegion(request.getParameter(CourseCreation.COURSE_REGION));
            course.setLeadId(Integer.parseInt(request.getParameter(CourseCreation.COURSE_LEAD_ID)));
            course.setStatus(Integer.parseInt(request.getParameter(CourseCreation.COURSE_AVAILABILITY)));
            course.setCourseId(Integer.parseInt(request.getParameter(COURSE_ID)));

            boolean updateSuccess = adminServiceImpl.updateCourse(course);

            String statusMessage = updateSuccess ? updSucc : updUnSucc;

            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            request.setAttribute(AdminCourseModifyPage.COURSE_TYPE, course.getType());
            request.setAttribute(AdminCourseModifyPage.COURSE_AVAILABILITY, course.getStatus());
            request.setAttribute(AdminCourseModifyPage.COURSE_REGION, course.getRegion());

            request.getRequestDispatcher(URLCommand.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
