package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentSubmitTask implements ICommand {
    public static final String USER_TASK_ID = "userTaskId";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();

        Integer userTaskId = Integer.parseInt(request.getParameter(USER_TASK_ID));

        try {
            boolean taskSubmitSuccess = studentService.submitTask(userTaskId);

            if (taskSubmitSuccess) {
                response.sendRedirect(URLCommand.STUDENT_TASK_LIST_PAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
