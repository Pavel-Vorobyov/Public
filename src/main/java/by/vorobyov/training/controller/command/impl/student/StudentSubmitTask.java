package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes object-command, which submitted student task.
 */
public class StudentSubmitTask implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private String subSuccessful = "Your task was submitted successful!";
    private String subUnsuccessfully = "Your task has been done or submitted already!";

    public static final String USER_TASK_ID = "userTaskId";


    /**
     * Gets userTaskId from session.
     * Tries to update user task by
     * {@link by.vorobyov.training.service.impl.StudentServiceImpl StudentServiceImpl}.
     * If update successful sets statusMessage value "...success" else "unsuccessful".
     * Then forwards to the student-task-list.jsp .<br>
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
        StudentServiceImpl studentService = new StudentServiceImpl();

        Integer userTaskId = Integer.parseInt(request.getParameter(USER_TASK_ID));

        try {
            boolean taskSubmitSuccess = studentService.submitTask(userTaskId);

            String statusMessage = taskSubmitSuccess ? subSuccessful : subUnsuccessfully;
            request.setAttribute(AttributeName.STATUS_MESSAGE, statusMessage);

            request.getRequestDispatcher(URLCommand.STUDENT_TASK_LIST_PAGE).forward(request, response);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
