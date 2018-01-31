package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TrainingPortalPage implements ICommand {
    public static final Integer COURSE_PLANING = 0;
    public static final String ALL_VALUE = "All";
    public static final String COURSE_REGION = "courseRegion";
    public static final String COURSE_TYPE = "courseType";
    public static final String COURSE_STATUS = "courseStatus";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonService();
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

            courseList = commonService.takeCourseListByFilter(courseStatus, courseType, courseRegion);
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
            e.printStackTrace();
        }
    }

}
