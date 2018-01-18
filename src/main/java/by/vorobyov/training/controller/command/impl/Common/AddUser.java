package by.vorobyov.training.controller.command.impl.Common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.resource.parametername.AccountParameterName;
import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.validator.impl.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser implements ICommand {
    public static final Integer STATUS_STUDENT = 0;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setLogin(request.getParameter(AccountParameterName.LOGIN).toString());
        user.setPassword(request.getParameter(AccountParameterName.PASSWORD).toString());
        user.setEmail(request.getParameter(AccountParameterName.EMAIL).toString());

        CommonService commonService = new CommonService();
        UserValidator userValidator = new UserValidator();

        try {
            if (userValidator.checkEntity(user) && userValidator.checkEmail(user.getEmail())
                    && commonService.checkUser(user).isEmpty()) {
                commonService.addUser(user);
                if (commonService.addUser(user)) {
                    user = commonService.checkUser(user);
                    request.getSession().setAttribute(AttributeName.USER, user);
                }
                request.getRequestDispatcher(JspPageName.TRAINING_PORTAL_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}
