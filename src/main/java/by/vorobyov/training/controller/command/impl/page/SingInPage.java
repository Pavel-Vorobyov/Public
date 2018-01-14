package by.vorobyov.training.controller.command.impl.page;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.JspPageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingInPage implements ICommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("").include(request, response);
    }
}
