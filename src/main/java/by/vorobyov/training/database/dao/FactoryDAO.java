package by.vorobyov.training.database.dao;

import by.vorobyov.training.database.dao.impl.*;
import by.vorobyov.training.dto.entity.UserData;

public class FactoryDAO {
    private static final FactoryDAO INSTANCE = new FactoryDAO();

    private final CourseDAO courseDAO = new CourseDAO();
    private final TaskDAO taskDAO = new TaskDAO();
    private final UserDAO userDAO = new UserDAO();
    private final UserDataDAO userDataDAO = new UserDataDAO();
    private final WorkGroupDAO workGroupDAO = new WorkGroupDAO();

    private FactoryDAO() {
    }

    public static FactoryDAO getINSTANCE() {
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

    public WorkGroupDAO getWorkGroupDAO() {
        return workGroupDAO;
    }
}
