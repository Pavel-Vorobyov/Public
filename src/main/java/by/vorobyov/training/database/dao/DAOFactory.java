package by.vorobyov.training.database.dao;

import by.vorobyov.training.database.dao.impl.*;

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private final CourseDAO courseDAO = new CourseDAO();
    private final TaskDAO taskDAO = new TaskDAO();
    private final UserDAO userDAO = new UserDAO();
    private final UserDataDAO userDataDAO = new UserDataDAO();
    private final UserHasCourseDAO userHasCourseDAO = new UserHasCourseDAO();
    private final UserTaskDAO userTaskDAO = new UserTaskDAO();
    private final WorkGroupDAO workGroupDAO = new WorkGroupDAO();

    private DAOFactory() {
    }

    public static DAOFactory getINSTANCE() {
        return INSTANCE;
    }

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    public TaskDAO getTaskDAO() {
        return taskDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public UserDataDAO getUserDataDAO() {
        return userDataDAO;
    }

    public UserHasCourseDAO getUserHasCourseDAO() {
        return userHasCourseDAO;
    }

    public UserTaskDAO getUserTaskDAO() {
        return userTaskDAO;
    }

    public WorkGroupDAO getWorkGroupDAO() {
        return workGroupDAO;
    }

}
