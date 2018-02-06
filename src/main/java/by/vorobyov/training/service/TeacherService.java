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
     * @param task
     * @param groupId
     * @return
     * @throws ServiceException
     */
    boolean createTask (Task task, Integer groupId) throws ServiceException;

    /**
     * @param task
     * @return
     * @throws ServiceException
     */
    boolean updateTask(Task task) throws ServiceException;

    /**
     * @param userTask
     * @return
     * @throws ServiceException
     */
    boolean userTaskUpdate(UserTask userTask) throws ServiceException;

    /**
     * @param userId
     * @return
     * @throws ServiceException
     */
    List<TeacherGroupTask> takeUserTaskByUserId(Integer userId) throws ServiceException;

    /**
     * @param taskId
     * @param groupId
     * @return
     * @throws ServiceException
     */
    List<TeacherUserTask> takeUserTaskList(Integer taskId, Integer groupId) throws ServiceException;

}
