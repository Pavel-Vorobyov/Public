package by.vorobyov.training.service.impl;

import by.vorobyov.training.database.dao.DAOFactory;
import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.service.ServerService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

public class ServerServiceImpl implements ServerService {
    public static final Integer MAIL_STATUS_UNCHECKED = 0;
    public static final Integer MAIL_STATUS_CHECKED = 1;

    public boolean sendVerifyingLetter(String userMailAddress, User currentUser) throws DAOException {
        CommonServiceImpl commonServiceImpl = new CommonServiceImpl();

        String subject = "Verifying letter...";
        String verifyLink = "http://localhost:8080/command?command=verify-mail&userId=" + currentUser.getUserId();
        String text = "Hello! To verify this email address please tap to this link.\n"
                + verifyLink;

        try {
            commonServiceImpl.sendMail(userMailAddress, CommonServiceImpl.SERVER_MAIL_ADDRESS, subject, text);
        } catch (MessagingException | IOException e) {
            throw new DAOException(e);
        }

        return true;
    }

    public boolean updateUserMailStatus(Integer mailStatus, Integer userId) throws DAOException {
        UserDAO userDAO = DAOFactory.getINSTANCE().getUserDAO();

        try {
            return userDAO.updateUserMailStatus(mailStatus, userId);
        } catch (SQLException | DAOException e) {
            throw new DAOException(e);
        }
    }
}
