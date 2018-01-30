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
    public static final String COURSE_STATUS_NAME = "courseStatus";
    public static final Integer COURSE_STATUS_VALUE_ALL = 2;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonService commonService = new CommonService();
        List<Course> courseList;
        Integer courseStatus;

        try {
            if (request.getParameter(AttributeName.COURSE_STATUS) != null) {

                courseStatus = Integer.valueOf(request.getParameter(COURSE_STATUS_NAME));
                if (courseStatus == 1 || courseStatus == 0) {
                    courseList = commonService.takeCourseListByStatus(courseStatus);
                } else {
                    courseList = commonService.takeCourseList();
                }
                request.getSession().setAttribute(AttributeName.COURSE_STATUS, courseStatus);
                request.getSession().setAttribute(AttributeName.COURSE_LIST, courseList);
            } else {
                courseList = commonService.takeCourseList();
                request.getSession().setAttribute(AttributeName.COURSE_STATUS, COURSE_STATUS_VALUE_ALL);
                request.getSession().setAttribute(AttributeName.COURSE_LIST, courseList);
            }
            request.getRequestDispatcher(JspPageName.TRAINING_PORTAL_PAGE).include(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
