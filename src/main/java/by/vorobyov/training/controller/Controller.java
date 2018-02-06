package by.vorobyov.training.controller;

import by.vorobyov.training.controller.command.CommandStorage;
import by.vorobyov.training.controller.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Front application controller.
 */
@WebServlet(
        urlPatterns = "/command"
)

public class Controller extends HttpServlet{
    public static final String COMMAND = "command";

    /**
     * Called by the server (via the service method) to allow a servlet to handle a POST request.<br>
     * Delegates the request processing to
     * {@link #processRequest(HttpServletRequest, HttpServletResponse) processRequests} method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Called by the server (via the service method) to allow a servlet to handle a GET request.
     * <p>
     * Delegates the request processing to
     * {@link #processRequest(HttpServletRequest, HttpServletResponse) processRequest} method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Extracts the command name from the request and invoke the method.
     *
     * @param request request  object that contains the request the client has made of the servlet.
     * @param response response object that contains the response the servlet sends to the client.
     * @throws ServletException if the request for the GET could not be.
     * @throws IOException if an input or output error is detected when the servlet handles the request.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CommandStorage commandStorage = CommandStorage.getInstance();

        String commandName = request.getParameter(COMMAND);

        ICommand command = commandStorage.getCommand(commandName);

        command.execute(request, response);
    }

}
