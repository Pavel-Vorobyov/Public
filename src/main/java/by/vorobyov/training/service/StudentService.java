package by.vorobyov.training.service;

import by.vorobyov.training.dto.StudentGroup;
import by.vorobyov.training.dto.StudentUserTask;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.exception.ServiceException;

import java.util.List;

public interface StudentService {

    List<StudentUserTask> takeUserTaskByUserId(Integer userId) throws ServiceException;

    List<StudentGroup> takeStudentGroupByUserId(Integer userId) throws ServiceException;

    boolean applyForCourse(User student, Integer courseId) throws ServiceException;

    boolean submitTask(Integer userTaskId) throws ServiceException;

}
