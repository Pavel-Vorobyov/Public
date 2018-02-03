package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.nameresource.JspPageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePage implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagePath = JspPageName.HOME_PAGE;
        request.getRequestDispatcher(pagePath).forward(request, response);
    }
}
