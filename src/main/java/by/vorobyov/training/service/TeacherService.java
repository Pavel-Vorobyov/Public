package by.vorobyov.training.service;

import by.vorobyov.training.dto.TeacherGroupTask;
import by.vorobyov.training.dto.TeacherUserTask;
import by.vorobyov.training.dto.entity.Task;
import by.vorobyov.training.dto.entity.UserTask;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;

import java.util.List;

public interface TeacherService {

    boolean createTask (Task task, Integer groupId) throws ServiceException;

    boolean updateTask(Task task) throws ServiceException;

    boolean userTaskUpdate(UserTask userTask) throws ServiceException;

    List<TeacherGroupTask> takeUserTaskByUserId(Integer userId) throws ServiceException;

    List<TeacherUserTask> takeUserTaskList(Integer taskId, Integer groupId) throws DAOException;

}
