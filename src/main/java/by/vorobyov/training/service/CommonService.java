package by.vorobyov.training.service;

import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.ServiceException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Interface for {@link by.vorobyov.training.service.impl.CommonServiceImpl CommonServiceImpl}.
 */
public interface CommonService {

    /**
     * Gets user entity with mail, login, password.
     * This transfer object {@link User User} validates on the service layer.
     * If it's OK tries to get this User from database.
     * If there are no matches returns empty entity User.
     * In other cases returns User from database.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param user entity that contains user parameters.
     * @return user entity.
     * @throws ServiceException
     */
    User checkUser(User user) throws ServiceException;

    /**
     * Gets {@link by.vorobyov.training.dto.entity.UserData data} of the user by user ID.
     * If there are no matches returns empty entity User.
     * In other cases returns User from database.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userId ID of the user.
     * @return data of the user.
     * @throws ServiceException
     */
    UserData getUserDataById(Integer userId) throws ServiceException;

    /**
     * The transfer object {@link User User} validates on the service layer.
     * If all parameters are OK tries to add a new user to database.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param user entity that contains user parameters.
     * @return created user.
     * @throws ServiceException
     */
    User addUser(User user) throws ServiceException;

    /**
     * Tries to get a list of {@link by.vorobyov.training.dto.entity.Course Course}
     * by some filter parameters from database. If there are no matches
     * returns empty entity User.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param courseStatus Status of the course.
     * @param courseType a programming language that course is teaching for (Java, PHP, ...).
     * @param courseRegion  place where course held.
     * @return a list of groups.
     * @throws ServiceException
     */
    List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException;

    /**
     * Gets current {@link by.vorobyov.training.dto.entity.UserData data}
     * from database by ID of the user. Then replaces all available parameters
     * from current user data by parameter userData.<br>
     * Tries to update user data. If it's OK returns true.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param user entity that contains user parameters.
     * @param userData data of the user.
     * @return true if update was successful.
     * @throws ServiceException
     */
    boolean userDataUpdate(User user, UserData userData) throws ServiceException;

    /**
     * Tries to get a list of {@link by.vorobyov.training.dto.entity.Course Course}
     * by ID of the user. If there are no matches returns empty entity lst.
     * In other cases returns a list of courses from database.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userId ID of the user.
     * @return a list of courses.
     * @throws ServiceException
     */
    List<Course> takeCourseListByUserId(Integer userId) throws ServiceException;

    /**
     * Tries to send a mail by recipient mail address.
     * If it,s OK returns true.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param toMailAddress recipient mail address.
     * @param fromMailAddress author mail address.
     * @param subject a subject of a mail.
     * @param text a text of a mail.
     * @return true if mail was sent successfully.
     * @throws IOException
     * @throws MessagingException
     */
    boolean sendMail(String toMailAddress, String fromMailAddress, String subject, String text) throws IOException, MessagingException;

}
