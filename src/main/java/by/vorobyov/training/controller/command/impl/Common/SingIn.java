package by.vorobyov.training.controller.command.impl.Common;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.database.service.CommonDAO;
import by.vorobyov.training.entity.Account;
import by.vorobyov.training.entity.User;
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
        Account account = new Account();

        account.setLogin(request.getParameter(AccountParameterName.LOGIN));
        account.setPassword(request.getParameter(AccountParameterName.PASSWORD));


            CommonDAO commonDAO = new CommonDAO();

            User user = commonDAO.singIn(account);
            if (user != null) {
                request.getSession(true).setAttribute(AttributeName.USER, user);

                if (user.getStatus().equals(UserStatus.STATUS_STUDENT)) {
                    response.sendRedirect(URLCommand.HOME_STUDENT);
                }
                if (user.getStatus().equals(UserStatus.STATUS_LECTURE)) {
//                    response.sendRedirect();
                }
                if (user.getStatus().equals(UserStatus.STATUS_ADMIN)) {
//                    response.sendRedirect();
                }
            } else {
                response.sendError(401);
            }

    }
}
