package by.vorobyov.training.controller.command.impl.page.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.StudentUserTask;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentTaskListPage implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        StudentService studentService = new StudentService();
        List<StudentUserTask> studentUserTaskList;

        if (0 == currentUser.getStatus()) {

            try {
                studentUserTaskList = studentService.takeUserTaskByUserId(currentUser.getUserId());
                request.setAttribute(AttributeName.STUDENT_USER_TASK_LIST, studentUserTaskList);
                request.getRequestDispatcher(JspPageName.STUDENT_TASK_LIST_PAGE).forward(request, response);
            } catch (ServiceException e) {
                e.printStackTrace();
            }

        } else {
            request.getRequestDispatcher(JspPageName.ERROR_PAGE).forward(request, response);
        }
    }
}
