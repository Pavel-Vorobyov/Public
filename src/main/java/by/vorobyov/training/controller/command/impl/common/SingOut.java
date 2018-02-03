package by.vorobyov.training.controller.command.impl.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.nameresource.AttributeName;
import by.vorobyov.training.controller.nameresource.JspPageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingOut implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(AttributeName.USER);
        request.getSession().removeAttribute(AttributeName.USER_DATA);

        request.getRequestDispatcher(JspPageName.HOME_PAGE).forward(request, response);
    }
}
