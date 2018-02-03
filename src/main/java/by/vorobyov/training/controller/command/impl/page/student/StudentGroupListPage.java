package by.vorobyov.training.controller.command.impl.page.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.dto.StudentGroup;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.controller.nameresource.AttributeName;
import by.vorobyov.training.controller.nameresource.JspPageName;
import by.vorobyov.training.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentGroupListPage implements ICommand {
    public static final Integer USER_STATUS_STUDENT = 0;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        List<StudentGroup> studentGroupList;

        try {
            studentGroupList = studentService.takeStudentGroupByUserId(currentUser.getUserId());
            request.setAttribute(AttributeName.STUDENT_GROUP_LIST, studentGroupList);
            request.getRequestDispatcher(JspPageName.STUDENT_GROUP_LIST_PAGE).forward(request, response);

        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}
