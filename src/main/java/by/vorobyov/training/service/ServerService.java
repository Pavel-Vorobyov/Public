package by.vorobyov.training.service;

import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

public class ServerService {
    public static final Integer MAIL_STATUS_UNCHECKED = 0;
    public static final Integer MAIL_STATUS_CHECKED = 1;

    public boolean sendVerifyingLetter(String userMailAddress, User currentUser) throws DAOException {
        CommonService commonService = new CommonService();

        String subject = "Verifying letter...";
        String verifyLink = "http://localhost:8080/command?command=verify-mail&userId=" + currentUser.getUserId();
        String text = "Hello! To verify this email address please tap to this link.\n"
                + verifyLink;

        try {
            commonService.sendMail(userMailAddress, CommonService.SERVER_MAIL_ADDRESS, subject, text);
        } catch (MessagingException | IOException e) {
            throw new DAOException(e);
        }

        return true;
    }

    public boolean updateUserMailStatus(Integer mailStatus, Integer userId) throws DAOException {
        UserDAO userDAO = new UserDAO();

        try {
            return userDAO.updateUserMailStatus(mailStatus, userId);
        } catch (SQLException | DAOException e) {
            throw new DAOException(e);
        }
    }
}
