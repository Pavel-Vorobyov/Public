package by.vorobyov.training.controller.command.impl.page.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.nameresource.AttributeName;
import by.vorobyov.training.nameresource.JspPageName;
import by.vorobyov.training.service.impl.AdminService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminCourseModifyPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Integer COURSE_AVAILABLE = 0;
    public static final Integer USER_STATUS_ADMIN = 2;
    public static final String ALL_VALUE = "All";
    public static final String COURSE_REGION = "courseRegion";
    public static final String COURSE_TYPE = "courseType";
    public static final String COURSE_AVAILABILITY = "courseAvailability";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        List<Course> courseList;

        Integer courseAvailability = COURSE_AVAILABLE;
        String courseType = ALL_VALUE;
        String courseRegion = ALL_VALUE;

        try {

            if (request.getParameter(COURSE_AVAILABILITY) != null) {
                    courseAvailability = Integer.parseInt(request.getParameter(COURSE_AVAILABILITY));
            }
            if (request.getParameter(COURSE_TYPE) != null) {
                    courseType = request.getParameter(COURSE_TYPE);
            }
            if (request.getParameter(COURSE_REGION) != null) {
                    courseRegion = request.getParameter(COURSE_REGION);
            }

            courseList = adminService.takeCourseListByFilter(courseAvailability, courseType, courseRegion);

            request.setAttribute(AttributeName.COURSE_LIST, courseList);
            request.setAttribute(COURSE_AVAILABILITY, courseAvailability);
            request.setAttribute(COURSE_TYPE, courseType);
            request.setAttribute(COURSE_REGION, courseRegion);

            if (!courseList.isEmpty()) {

                request.getRequestDispatcher(JspPageName.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
            } else {
                request.getRequestDispatcher(JspPageName.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}