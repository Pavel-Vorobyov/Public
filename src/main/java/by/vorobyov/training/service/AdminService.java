package by.vorobyov.training.service;

import by.vorobyov.training.dto.UserForAdmin;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.impl.AdminServiceImpl;

import java.util.List;

/**
 * Interface for {@link AdminServiceImpl AdminServiceImpl}
 */
public interface AdminService {

    /**
     * Method takes some filter parameters then selects list of course by
     * {@link by.vorobyov.training.database.dao.impl.CourseDAO CourseDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param courseStatus status of the course
     * @param courseType type if the course
     * @param courseRegion region of the course
     * @return list of {@link by.vorobyov.training.dto.entity.Course Course}
     * @throws ServiceException
     */
    List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException;

    /**
     * Takes entity that contains course parameters then
     * creates a new course by CourseDAO.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param course entity that contains {@link by.vorobyov.training.dto.entity.Course course} parameters.
     * @return true if course has been created successful.
     * @throws ServiceException
     */
    boolean createCourse(Course course) throws ServiceException;

    /**
     * Takes entity that contains course parameters then
     * updates a course by CourseDAO.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param course entity that contains {@link by.vorobyov.training.dto.entity.Course course} parameters.
     * @return true if course has been updated successful.
     * @throws ServiceException
     */
    boolean updateCourse(Course course) throws ServiceException;

    /**
     * Takes entity that contains course parameters then
     * deletes a course by CourseDAO.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param courseId ID of the course
     * @return true if course has been deleted successful.
     * @throws ServiceException
     */
    boolean deleteCourse(Integer courseId) throws ServiceException;

    /**
     *Takes some filter parameters and then selects list of
     * {@link by.vorobyov.training.dto.entity.WorkGroup WorkGroup} by
     * {@link by.vorobyov.training.database.dao.impl.WorkGroupDAO WorkGroupDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param groupStatus status of the group.
     * @param groupType a programming language that group is teaching for (Java, PHP, ...).
     * @param groupRegion a place where group held.
     * @return
     * @throws ServiceException
     */
    List<WorkGroup> takeGroupListByFilter(Integer groupStatus, String groupType, String groupRegion) throws ServiceException;

    /**
     * Takes entity that contains work group parameters then
     * creates a new work group by {@link by.vorobyov.training.database.dao.impl.WorkGroupDAO WorkGroupDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param workGroup entity that contains work group parameters.
     * @return true if work group has been created successful.
     * @throws ServiceException
     */
    boolean createWorkGroup(WorkGroup workGroup) throws ServiceException;

    /**
     * Takes entity that contains work group parameters then
     * updates a work group by {@link by.vorobyov.training.database.dao.impl.WorkGroupDAO WorkGroupDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param workGroup
     * @return true if work group has been updated successful.
     * @throws ServiceException
     */
    boolean updateWorkGroup(WorkGroup workGroup) throws ServiceException;

    /**
     * Takes work group ID and then deletes a work group by
     * {@link by.vorobyov.training.database.dao.impl.WorkGroupDAO WorkGroupDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param groupId ID of the work group.
     * @return true if work group has been deleted successful.
     * @throws ServiceException
     */
    boolean deleteWorkGroup(Integer groupId) throws ServiceException;

    /**
     * Takes user status and then selects a list of {@link by.vorobyov.training.dto.UserForAdmin UserForAdmin} by
     * {@link by.vorobyov.training.database.dao.impl.UserDataDAO UserDataDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userStatus status of user.
     * @return a list of UserForAdmin.
     * @throws ServiceException
     */
    List<UserForAdmin> takeUserListByFilter(Integer userStatus) throws ServiceException;

    /**
     * Takes user {@link by.vorobyov.training.dto.entity.User User} and
     * {@link by.vorobyov.training.dto.entity.UserData UserData} then updates them by
     * {@link by.vorobyov.training.database.dao.impl.UserDataDAO UserDataDAO}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param user entity with User parameters.
     * @param userData entity with UserData parameters.
     * @return true if user and user data have benn updated successful.
     * @throws ServiceException
     */
    boolean updateUser(User user, UserData userData) throws ServiceException;

}
