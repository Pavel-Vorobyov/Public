package by.vorobyov.training.service;

import by.vorobyov.training.dto.entity.*;
import by.vorobyov.training.exception.ServiceException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface CommonService {

    User checkUser(User user) throws ServiceException;

    UserData getUserDataById(Integer userId) throws ServiceException;

    User addUser(User user) throws ServiceException;

    List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException;

    boolean userDataUpdate(User user, UserData userData) throws ServiceException;

    List<Course> takeCourseListByUserId(Integer userId) throws ServiceException;

    Course takeCourseByCourseId(Integer courseId) throws ServiceException;

    List<WorkGroup> takeWorkGroupListByLeadId(Integer userId) throws ServiceException;

    WorkGroup takeWorkGroupById(Integer workGroupId) throws ServiceException;

    List<Task> takeGroupTaskListByGroupId(Integer groupId) throws ServiceException;

    boolean sendMail(String toMailAddress, String fromMailAddress, String subject, String text) throws IOException, MessagingException;

}
