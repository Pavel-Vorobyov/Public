package by.vorobyov.training.service;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.DAOException;

public interface ServerService {

    boolean sendVerifyingLetter(String userMailAddress, User currentUser) throws DAOException;

    boolean updateUserMailStatus(Integer mailStatus, Integer userId) throws DAOException;

}
