package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class describes the object-command, the execution of which
 * deletes transfer object {@link by.vorobyov.training.dto.entity.User User}
 * from session.
 */
public class SingOut implements ICommand {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Deletes transfer object {@link by.vorobyov.training.dto.entity.User User}
     * from session and redirects to the home page.
     *
     * @param request  request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(AttributeName.USER);
        request.getSession().removeAttribute(AttributeName.USER_DATA);

        request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
    }
}
