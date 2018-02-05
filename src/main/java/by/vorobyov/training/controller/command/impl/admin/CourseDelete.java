package by.vorobyov.training.controller.command.impl.admin;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.nameresource.URLCommand;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.nameresource.AttributeName;
import by.vorobyov.training.service.impl.AdminService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseDelete implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String COURSE_ID = "courseId";
    public static final String DELETE_SUCCESS = "The course has been deleted successful!";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();

        Integer courseId = Integer.parseInt(request.getParameter(COURSE_ID));

        try {
            boolean result = adminService.deleteCourse(courseId);

            if (result) {
                request.setAttribute(AttributeName.STATUS_MESSAGE, DELETE_SUCCESS);

                request.getRequestDispatcher(URLCommand.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
