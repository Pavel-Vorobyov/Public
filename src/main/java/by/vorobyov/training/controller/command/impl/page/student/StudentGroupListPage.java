package by.vorobyov.training.controller.command.impl.page.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.StudentGroup;
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
 * Class describes object-command, which forwards to the student group page.
 */
public class StudentGroupListPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Integer USER_STATUS_STUDENT = 0;

    /**
     * Gets user id from session.
     * Gets {@link by.vorobyov.training.dto.StudentGroup student group} from database
     * by {@link by.vorobyov.training.service.impl.StudentServiceImpl StudentServiceImpl}.
     * Than puts them into request and forwards to the student-group-list.jsp .
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentServiceImpl studentService = new StudentServiceImpl();
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        List<StudentGroup> studentGroupList;

        try {
            studentGroupList = studentService.takeStudentGroupByUserId(currentUser.getUserId());
            request.setAttribute(AttributeName.STUDENT_GROUP_LIST, studentGroupList);
            request.getRequestDispatcher(JspPageName.STUDENT_GROUP_LIST_PAGE).forward(request, response);

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }

    }
}
