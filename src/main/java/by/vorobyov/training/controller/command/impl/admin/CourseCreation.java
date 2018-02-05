package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.impl.AdminServiceImplImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseCreation implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String COURSE_TITLE = "title";
    public static final String COURSE_AVAILABILITY = "availability";
    public static final String COURSE_TYPE = "type";
    public static final String COURSE_REGION = "region";
    public static final String COURSE_LEAD_ID = "leadId";
    public static final String COURSE_DESCRIPTION = "courseDescription";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImplImpl adminServiceImpl = new AdminServiceImplImpl();
        Course course = new Course();

        try {
            course.setTitle(request.getParameter(COURSE_TITLE));
            course.setRegion(request.getParameter(COURSE_REGION));
            course.setStatus(Integer.parseInt(request.getParameter(COURSE_AVAILABILITY)));
            course.setDescription(request.getParameter(COURSE_DESCRIPTION));
            course.setLeadId(Integer.parseInt(request.getParameter(COURSE_LEAD_ID)));
            course.setType(request.getParameter(COURSE_TYPE));

            boolean createSuccess = adminServiceImpl.createCourse(course);

            if (createSuccess) {
                request.setAttribute(AdminCourseModifyPage.COURSE_AVAILABILITY, course.getStatus());
                request.setAttribute(AdminCourseModifyPage.COURSE_TYPE, course.getType());
                request.setAttribute(AdminCourseModifyPage.COURSE_REGION, course.getRegion());
                request.setAttribute(AttributeName.STATUS_MESSAGE, "Course has been created successful!");

                request.getRequestDispatcher(URLCommand.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
