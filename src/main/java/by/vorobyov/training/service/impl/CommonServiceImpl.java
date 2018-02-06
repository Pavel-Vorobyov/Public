package by.vorobyov.training.service.impl;

import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.database.dao.DAOFactory;
import by.vorobyov.training.database.dao.impl.*;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CommonServiceImpl implements CommonService {
    public static final String SERVER_MAIL_ADDRESS = "pasha.vorobyov.by@gmail.com";
    private static final String SERVER_MAIL_PASSWORD_PROP = "mail.user.password";
    private static final String SERVER_MAIL_PROPERTIES = "mail.properties";

    public static final String DESCRIPTION_STUDENT = "Student";
    public static final String SELECT_COURSE_BY_STATUS_REGION_TYPE = "SELECT *" +
            " FROM course" +
            " WHERE ";
    public static final String COURSE_STATUS = " course.status =";
    public static final String COURSE_REGION = " course.region =";
    public static final String COURSE_TYPE = " course.type =";

    public static final String SQL_AND = " AND ";

    public User checkUser(User user) throws ServiceException {
        UserDAO userDAO = DAOFactory.getINSTANCE().getUserDAO();

        try {

            return userDAO.getUserByLogPass(user);

        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public UserData getUserDataById(Integer userId) throws ServiceException {
        UserDataDAO userDataDAO = DAOFactory.getINSTANCE().getUserDataDAO();

        try {

            UserData userData = userDataDAO.getEntityById(userId);
            return userData;

        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public User addUser(User user) throws ServiceException {
        UserDataDAO userDataDAO = DAOFactory.getINSTANCE().getUserDataDAO();
        UserDAO userDAO = DAOFactory.getINSTANCE().getUserDAO();

        try {
            User checkingUser = new User();

            checkingUser.setLogin(user.getLogin());
            checkingUser.setEmail(user.getEmail());

            checkingUser = userDAO.getUserByLog(checkingUser);

            if (checkingUser.isEmpty()) {
                User currentUser = new User();

                currentUser.setLogin(user.getLogin());
                currentUser.setPassword(user.getPassword());
                currentUser.setEmail(user.getEmail());

                boolean createUserSuccess = userDAO.create(currentUser);

                if (createUserSuccess) {
                    UserData currentUserData = new UserData();
                    currentUser = userDAO.getUserByLogPass(user);

                    String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                    currentUserData.setUserId(currentUser.getUserId());
                    currentUserData.setCreationTime(currentDate);
                    currentUserData.setDescription(DESCRIPTION_STUDENT);

                    return userDataDAO.create(currentUserData) ? currentUser : User.emptyUser();
                }
            }

            return User.emptyUser();

        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException {
        CourseDAO courseDAO = DAOFactory.getINSTANCE().getCourseDAO();

        try {
            String sqlRequest = SELECT_COURSE_BY_STATUS_REGION_TYPE + COURSE_STATUS + courseStatus;
            if (!courseType.equals(AdminCourseModifyPage.ALL_VALUE)) {
                sqlRequest += SQL_AND + COURSE_TYPE + "'" + courseType + "'";
            }
            if (!courseRegion.equals(AdminCourseModifyPage.ALL_VALUE)) {
                sqlRequest += SQL_AND + COURSE_REGION + "'" + courseRegion + "'";
            }

            return courseDAO.getCourseListBySQLRequest(sqlRequest);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean userDataUpdate(User user, UserData userData) throws ServiceException {
        UserDataDAO userDataDAO = DAOFactory.getINSTANCE().getUserDataDAO();
        UserDAO userDAO = DAOFactory.getINSTANCE().getUserDAO();

        try {
            User modifyingUser = userDAO.getEntityById(user.getUserId());
            UserData modifyingUserData = userDataDAO.getUserDataByUserId(user.getUserId());

            modifyingUserData.setName(userData.getName());
            modifyingUserData.setSurname(userData.getSurname());

            modifyingUser.setLogin(user.getLogin());
            modifyingUser.setPassword(user.getPassword());
            modifyingUser.setEmail(user.getEmail());

            modifyingUserData.setName(userData.getName());
            modifyingUserData.setSurname(userData.getSurname());

            boolean userUpdateSuccess = userDAO.update(modifyingUser);
            boolean userDataUpdateSuccess = userDataDAO.update(modifyingUserData);

            return userUpdateSuccess && userDataUpdateSuccess;

        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public List<Course> takeCourseListByUserId(Integer userId) throws ServiceException {
        CourseDAO courseDAO = DAOFactory.getINSTANCE().getCourseDAO();

        try {
            return courseDAO.getCourseListByUserId(userId);
        } catch (DAOException | SQLException e) {
            throw  new ServiceException(e);
        }
    }

    public boolean sendMail(String toMailAddress,String fromMailAddress, String subject, String text) throws IOException, MessagingException {
        Properties properties = new Properties();
        properties.load(CommonServiceImpl.class.getClassLoader().getResourceAsStream(SERVER_MAIL_PROPERTIES));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(fromMailAddress));
        message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(toMailAddress)));
        message.setSubject(subject);
        message.setText(text);

        Transport tr = mailSession.getTransport();
        tr.connect(null, properties.getProperty(SERVER_MAIL_PASSWORD_PROP));
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();

        return true;
    }
}
