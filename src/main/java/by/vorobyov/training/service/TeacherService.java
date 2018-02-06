package by.vorobyov.training.service;

import by.vorobyov.training.dto.TeacherGroupTask;
import by.vorobyov.training.dto.TeacherUserTask;
import by.vorobyov.training.dto.entity.Task;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;

import java.util.List;

/**
 * Interface for {@link by.vorobyov.training.service.impl.TeacherServiceImpl TeacherServiceImpl}.
 */
public interface TeacherService {

    /**
     * Takes entity that contains {@link by.vorobyov.training.dto.entity.Task Task} parameters then
     * creates {@link by.vorobyov.training.dto.entity.UserTask UserTask} for every
     * student in the group. Returns true if all user tasks were created.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param task an entity contains Task parameters.
     * @param groupId ID of the work group.
     * @return true if a new task has been created successfully.
     * @throws ServiceException
     */
    boolean createTask (Task task, Integer groupId) throws ServiceException;

    /**
     * Takes entity that contains {@link by.vorobyov.training.dto.entity.Task Task} parameters then
     * tries to update task. If all are OK returns true.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param task an entity contains Task parameters.
     * @return true if task was updated successfully.
     * @throws ServiceException
     */
    boolean updateTask(Task task) throws ServiceException;

    /**
     * Gets entity that contains {@link by.vorobyov.training.dto.entity.UserTask UserTask}
     * then tries to update it. If all are successful returns true.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userTask task of the student.
     * @return true if user task eas updated successfully.
     * @throws ServiceException
     */
    boolean userTaskUpdate(UserTask userTask) throws ServiceException;

    /**
     * Gets {@link by.vorobyov.training.dto.entity.WorkGroup work  group} entities
     * by ID of the user and then tries to get their
     * {@link by.vorobyov.training.dto.entity.Task Task} entities.
     * If all are OK returns list of {@link by.vorobyov.training.dto.TeacherGroupTask TeacherGroupTask}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param userId ID of the user.
     * @return all user tasks.
     * @throws ServiceException
     */
    List<TeacherGroupTask> takeUserTaskByUserId(Integer userId) throws ServiceException;

    /**
     * Gets {@link by.vorobyov.training.dto.entity.WorkGroup work  group} entities
     * by ID of the user and then tries to get their
     * {@link by.vorobyov.training.dto.entity.UserTask UserTask} entities.
     * If all are OK returns list of {@link by.vorobyov.training.dto.TeacherGroupTask TeacherGroupTask}.<br>
     * If an error occurred during the command execution,
     * then the control is passed to the catch block of <tt>ServiceException</tt>
     * and forwarding to the server error page.
     *
     * @param taskId ID of the task.
     * @param groupId ID of the group.
     * @return a list of user tasks in current group by current task.
     * @throws ServiceException
     */
    List<TeacherUserTask> takeUserTaskList(Integer taskId, Integer groupId) throws ServiceException;

}
