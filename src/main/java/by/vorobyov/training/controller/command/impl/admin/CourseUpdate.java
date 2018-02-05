package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.AdminServiceImplImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseUpdate implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String COURSE_ID = "courseId";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImplImpl adminServiceImpl = new AdminServiceImplImpl();
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

            if (updateSuccess) {
                request.setAttribute(AdminCourseModifyPage.COURSE_TYPE, course.getType());
                request.setAttribute(AdminCourseModifyPage.COURSE_AVAILABILITY, course.getStatus());
                request.setAttribute(AdminCourseModifyPage.COURSE_REGION, course.getRegion());

                request.getRequestDispatcher(URLCommand.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
