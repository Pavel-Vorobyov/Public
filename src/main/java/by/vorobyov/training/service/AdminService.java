package by.vorobyov.training.service;

import by.vorobyov.training.dto.UserForAdmin;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;

import java.util.List;

public interface AdminService {

    List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException;

    boolean createCourse(Course course) throws ServiceException;

    boolean updateCourse(Course course) throws ServiceException;

    boolean deleteCourse(Integer courseId) throws ServiceException;

    List<WorkGroup> takeGroupListByFilter(Integer groupStatus, String groupType, String groupRegion) throws ServiceException;

    boolean createWorkGroup(WorkGroup workGroup) throws ServiceException;

    boolean updateWorkGroup(WorkGroup workGroup) throws ServiceException;

    boolean deleteWorkGroup(Integer groupId) throws ServiceException;

    List<UserForAdmin> takeUserListByFilter(Integer userStatus) throws ServiceException;

    boolean updateUser(User user, UserData userData) throws ServiceException;

}
