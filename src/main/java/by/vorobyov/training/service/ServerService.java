package by.vorobyov.training.service;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;

/**
 * Interface to {@link by.vorobyov.training.service.impl.ServerServiceImpl ServerServiceImpl}
 */
public interface ServerService {

    /**
     * Gets user mail address and current user. Takes user ID from entity user
     * and makes a link for verifying. Then sends a mail to userMailAddress.
     * Returns true in case when mail has been sent successful.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userMailAddress address where you want to send a mail.
     * @param currentUser entity of user that wants to send a mail.
     * @return
     * @throws ServiceException
     */
    boolean sendVerifyingLetter(String userMailAddress, User currentUser) throws  ServiceException;

    /**
     * Gets mail status and Id of the user then if update has been completed successful
     * returns true. <br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param mailStatus status of the mail.
     * @param userId ID of the user.
     * @return true if mail status has been updated successful.
     * @throws ServiceException
     */
    boolean updateUserMailStatus(Integer mailStatus, Integer userId) throws  ServiceException;

}
