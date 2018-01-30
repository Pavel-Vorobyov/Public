package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TrainingPage implements ICommand {
    public static final String TRAINING_GROUP = "command?command=training-group-list-page";
    public static final Integer STATUS_STUDENT = 0;
    public static final Integer STATUS_TEACHER = 1;
    public static final Integer STATUS_ADMIN = 3;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(AttributeName.USER);

        switch (user.getStatus()) {
            case 0:
                response.sendRedirect(URLCommand.STUDENT_HOME_PAGE);
                break;
            case 1:
                response.sendRedirect(URLCommand.TRAINING_GROUP_LIST);
                break;
            case 2:
                response.sendRedirect(URLCommand.ADMIN_COURSE_MODIFY_PAGE);
                break;
            default:
                request.getRequestDispatcher(JspPageName.ERROR_PAGE).forward(request, response);
                break;
        }
    }
}
