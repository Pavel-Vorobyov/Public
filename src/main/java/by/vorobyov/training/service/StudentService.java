package by.vorobyov.training.service;

import by.vorobyov.training.dto.StudentGroup;
import by.vorobyov.training.dto.StudentUserTask;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;

import java.util.List;

/**
 * Interface for {@link by.vorobyov.training.service.impl.StudentServiceImpl StudentServiceImpl}.
 */
public interface StudentService {

    /**
     * Gets userId then selects a list of {@link by.vorobyov.training.dto.entity.WorkGroup work group}
     * in which there is a student. Selects all {@link by.vorobyov.training.dto.entity.UserTask user task} by groupID
     * and puts them into {@link by.vorobyov.training.dto.StudentUserTask StudentUserTask}.<br>
     * Then makes a list of StudentUserTask and returns it.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userId ID of the student.
     * @return a list of student task.
     * @throws ServiceException
     */
    List<StudentUserTask> takeUserTaskByUserId(Integer userId) throws ServiceException;

    /**
     * By user ID gets all groups in which there is a student. Then by group ID
     * gets all data about other students and makes data transfer object
     * {@link by.vorobyov.training.dto.StudentGroup StudentGroup}.
     * Adds them into the list.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userId ID of the student.
     * @return a list contains entity StudentGroup.
     * @throws ServiceException
     */
    List<StudentGroup> takeStudentGroupByUserId(Integer userId) throws ServiceException;

    /**
     * Checks if user is not log in and user status if it's
     * does not match the student status. Forwards to the current
     * page whit status message. If all are ok applies student to
     * the course. Then forwards to the current page with
     * status message. <br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param student an entity that contains parameters of user.
     * @param courseId a courseID.
     * @return
     * @throws ServiceException
     */
    boolean applyForCourse(User student, Integer courseId) throws ServiceException;

    /**
     * Check if student can submit task. (The task is not submitted already
     * or done. Tries to submit task by
     * {@link by.vorobyov.training.database.dao.impl.UserTaskDAO UserTaskDAO}.
     * If all are ok returns true. <br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userTaskId ID of the user task.
     * @return true if user task was submitted successfully.
     * @throws ServiceException
     */
    boolean submitTask(Integer userTaskId) throws ServiceException;

}
