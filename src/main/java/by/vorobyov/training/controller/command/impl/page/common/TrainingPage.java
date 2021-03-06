package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.URLCommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes object-command, which forwards to the training page.
 */
public class TrainingPage implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String TRAINING_GROUP = "command?command=training-group-list-page";
    public static final Integer STATUS_STUDENT = 0;
    public static final Integer STATUS_TEACHER = 1;
    public static final Integer STATUS_ADMIN = 3;

    /**
     * Checks the status of a user and forwards to the appropriate page.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(AttributeName.USER);

        switch (user.getStatus()) {
            case 0:
                request.getRequestDispatcher(URLCommand.USER_HOME_PAGE).forward(request, response);
                break;
            case 1:
                request.getRequestDispatcher(URLCommand.TRAINING_GROUP_LIST).forward(request, response);
                break;
            case 2:
                request.getRequestDispatcher(URLCommand.ADMIN_COURSE_MODIFY_PAGE).forward(request, response);
                break;
            default:
                request.getRequestDispatcher(JspPageName.ERROR_PAGE).forward(request, response);
                break;
        }
    }
}
