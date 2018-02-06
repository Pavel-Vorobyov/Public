package by.vorobyov.training.controller.command;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Interface for implementing the Command template,
 * contains a single method {@link #execute(HttpServletRequest, HttpServletResponse) execute}
 */
public interface ICommand {
    /**
     * @param request request object that contains the request the client has made of the servlet
     * @param response response object that contains the response the servlet sends to the client
     * @throws ServletException
     * @throws IOException
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
