package by.vorobyov.training.controller.command.impl.Common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.database.dao.impl.UserDataDAO;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.parametername.AccountParameterName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingIn implements ICommand{
    public static final String TRAINING_PAGE = "command?command=training-page";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setLogin(request.getParameter(AccountParameterName.LOGIN));
        user.setPassword(request.getParameter(AccountParameterName.PASSWORD));

        CommonService commonService = new CommonService();
        UserDataDAO userDataDAO = new UserDataDAO();

            try {
                User checkedUser = commonService.checkUser(user);
                if (!checkedUser.isEmpty()) {
                    UserData userData = commonService.getUserDataById(checkedUser.getUserId());

                    request.getSession(true).setAttribute(AttributeName.USER, checkedUser);
                    request.getSession().setAttribute(AttributeName.USER_DATA, userData);

                    response.sendRedirect(TRAINING_PAGE);
                } else {
                    response.sendError(403);
                }
            } catch (ServiceException e) {
                System.out.println(e);
            }
    }
}
