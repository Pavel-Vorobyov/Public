package by.vorobyov.training.controller;

import by.vorobyov.training.controller.command.CommandStorage;
import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.resource.parametername.ControllerParameterName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CommandStorage commandStorage = CommandStorage.getInstance();

        String commandName = request.getParameter(ControllerParameterName.COMMAND);

        ICommand command = commandStorage.getCommand(commandName);

        command.execute(request, response);
    }

}
