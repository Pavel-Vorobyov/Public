package by.vorobyov.training.controller.command.impl.page.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class describes object-command, which forwards to the student course page.
 */
public class StudentCourseListPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Gets user id from session. Takes {@link by.vorobyov.training.dto.entity.Course course} list
     * from database by {@link by.vorobyov.training.service.impl.CommonServiceImpl CommonServiceImpl}.
     * Puts them into request. Than forwards to the student-course-list.jsp .
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentServiceImpl studentService = new StudentServiceImpl();

        User user = (User) request.getSession().getAttribute(AttributeName.USER);

        try {
            List<Course> courseList = studentService.takeCourseListByUserId(user.getUserId());

            if (!courseList.isEmpty()) {
                request.setAttribute(AttributeName.COURSE_LIST, courseList);
            } else {
                String statusMessage = "Sorry, coincidence has been found!";
                request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);
            }

            request.getRequestDispatcher(JspPageName.STUDENT_COURSE_LIST_PAGE).forward(request, response);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }

    }
}
