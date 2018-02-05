package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.nameresource.URLCommand;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.StudentService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentSubmitTask implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String USER_TASK_ID = "userTaskId";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();

        Integer userTaskId = Integer.parseInt(request.getParameter(USER_TASK_ID));

        try {
            boolean taskSubmitSuccess = studentService.submitTask(userTaskId);

            if (taskSubmitSuccess) {
                request.getRequestDispatcher(URLCommand.STUDENT_TASK_LIST_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
