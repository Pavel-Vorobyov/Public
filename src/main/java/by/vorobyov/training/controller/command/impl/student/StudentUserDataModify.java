package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.service.impl.StudentService;
import org.w3c.dom.Attr;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentUserDataModify implements ICommand {
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        CommonService commonService = new CommonService();

        User modifyingUser = (User) request.getSession().getAttribute(AttributeName.USER);
        UserData modifyingUserData = new UserData();

        try {
            modifyingUserData.setUserId(modifyingUser.getUserId());
            modifyingUserData.setName(request.getParameter(USER_NAME));
            modifyingUserData.setSurname(request.getParameter(USER_SURNAME));

            modifyingUser.setLogin(request.getParameter(USER_LOGIN));
            modifyingUser.setPassword(request.getParameter(USER_PASSWORD));
            modifyingUser.setEmail(request.getParameter(USER_EMAIL));

            boolean userDataUpdateSuccess = studentService.userDataUpdate(modifyingUser, modifyingUserData);
            UserData currentUserData = commonService.getUserDataById(modifyingUser.getUserId());

            if (userDataUpdateSuccess) {

                request.getSession().removeAttribute(AttributeName.USER);
                request.getSession().removeAttribute(AttributeName.USER_DATA);
                request.getSession().setAttribute(AttributeName.USER, modifyingUser);
                request.getSession().setAttribute(AttributeName.USER_DATA, currentUserData);

                response.sendRedirect(URLCommand.STUDENT_HOME_PAGE);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
