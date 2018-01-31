package by.vorobyov.training.controller.command.impl.page.common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserHomePage implements ICommand{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute(AttributeName.USER);
        CommonService commonService = new CommonService();
        UserData userData;

        try {
            userData = commonService.getUserDataById(currentUser.getUserId());
            request.setAttribute(AttributeName.USER_DATA, userData);
            request.getRequestDispatcher(JspPageName.USER_HOME_PAGE).forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
            request.getRequestDispatcher(JspPageName.ERROR_PAGE).forward(request, response);
        }
    }
}
