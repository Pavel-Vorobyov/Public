package by.vorobyov.training.controller.command.impl.Common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.entity.User;
import by.vorobyov.training.service.CommonService;
import by.vorobyov.training.entity.User1;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.UserStatus;
import by.vorobyov.training.resource.parametername.AccountParameterName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingIn implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setLogin(request.getParameter(AccountParameterName.LOGIN));
        user.setPassword(request.getParameter(AccountParameterName.PASSWORD));


            CommonService commonService = new CommonService();

            User1 user1 = commonService.singIn(user);
            if (user1 != null) {
                request.getSession(true).setAttribute(AttributeName.USER, user1);

                if (user1.getStatus().equals(UserStatus.STATUS_STUDENT)) {
                    response.sendRedirect(URLCommand.HOME_STUDENT);
                }
                if (user1.getStatus().equals(UserStatus.STATUS_LECTURE)) {
//                    response.sendRedirect();
                }
                if (user1.getStatus().equals(UserStatus.STATUS_ADMIN)) {
//                    response.sendRedirect();
                }
            } else {
                response.sendError(401);
            }

    }
}
