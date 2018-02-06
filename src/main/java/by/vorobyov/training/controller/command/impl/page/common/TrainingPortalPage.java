package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.CommonServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class describes object-command, which forwards to the training portal page.
 */
public class TrainingPortalPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Integer COURSE_PLANING = 0;
    public static final String ALL_VALUE = "All";
    public static final String COURSE_REGION = "courseRegion";
    public static final String COURSE_TYPE = "courseType";
    public static final String COURSE_STATUS = "courseStatus";

    /**
     * Gets some filter parameters rom request. Gets {@link by.vorobyov.training.dto.entity.Course course} list
     * from database by {@link by.vorobyov.training.service.impl.CommonServiceImpl CommonServiceImpl}.
     * Puts filter parameters into request than forwards to the training portal jsp.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonServiceImpl commonServiceImpl = new CommonServiceImpl();
        List<Course> courseList;

        Integer courseStatus = COURSE_PLANING;
        String courseType = ALL_VALUE;
        String courseRegion = ALL_VALUE;

        try {

            if (request.getParameter(COURSE_STATUS) != null) {
                courseStatus = Integer.parseInt(request.getParameter(COURSE_STATUS));
            }
            if (request.getParameter(COURSE_TYPE) != null) {
                courseType = request.getParameter(COURSE_TYPE);
            }
            if (request.getParameter(COURSE_REGION) != null) {
                courseRegion = request.getParameter(COURSE_REGION);
            }

            courseList = commonServiceImpl.takeCourseListByFilter(courseStatus, courseType, courseRegion);
            request.setAttribute(COURSE_STATUS, courseStatus);
            request.setAttribute(COURSE_TYPE, courseType);
            request.setAttribute(COURSE_REGION, courseRegion);

            if (!courseList.isEmpty()) {
                request.setAttribute(AttributeName.COURSE_LIST, courseList);

                request.getRequestDispatcher(JspPageName.TRAINING_PORTAL_PAGE).forward(request, response);
            } else {
                request.getRequestDispatcher(JspPageName.TRAINING_PORTAL_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

}
