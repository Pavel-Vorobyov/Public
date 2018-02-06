package by.vorobyov.training.service.impl;

import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.controller.command.impl.page.admin.AdminGroupModifyPage;
import by.vorobyov.training.database.dao.DAOFactory;
import by.vorobyov.training.database.dao.impl.CourseDAO;
import by.vorobyov.training.database.dao.impl.UserDAO;
import by.vorobyov.training.database.dao.impl.UserDataDAO;
import by.vorobyov.training.database.dao.impl.WorkGroupDAO;
import by.vorobyov.training.dto.UserForAdmin;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.filter.impl.SecurityFilter;
import by.vorobyov.training.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl extends CommonServiceImpl implements AdminService {
    public static final String SELECT_COURSE_BY_STATUS_REGION_TYPE = "SELECT *" +
            " FROM course" +
            " WHERE ";
    public static final String COURSE_STATUS = " course.status =";
    public static final String COURSE_REGION = " course.region =";
    public static final String COURSE_TYPE = " course.type =";

    public static final String SELECT_GROUP_BY_STATUS_REGION_TYPE = "SELECT *" +
            " FROM work_group" +
            " WHERE ";
    public static final String GROUP_STATUS = "work_group.status =";
    public static final String GROUP_REGION = "work_group.region =";
    public static final String GROUP_TYPE = "work_group.type =";

    public static final String SQL_AND = " AND ";

    public List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException {
       return super.takeCourseListByFilter(courseStatus, courseType, courseRegion);
    }

    public boolean createCourse(Course course) throws ServiceException {
        CourseDAO courseDAO = new CourseDAO();

        try {
            return courseDAO.create(course);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean updateCourse(Course course) throws ServiceException {
        CourseDAO courseDAO = new CourseDAO();
        UserDAO userDAO = DAOFactory.getINSTANCE().getUserDAO();

        try {
            User currentTeacher = userDAO.getEntityById(course.getLeadId());

            if (currentTeacher.isEmpty() || currentTeacher.getStatus() != SecurityFilter.STATUS_TEACHER) {
                return false;
            } else {
                return courseDAO.update(course);
            }
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean deleteCourse(Integer courseId) throws ServiceException {
        CourseDAO courseDAO = new CourseDAO();
        Course course = new Course();
        course.setCourseId(courseId);

        try {
            return courseDAO.delete(course);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public List<WorkGroup> takeGroupListByFilter(Integer groupStatus, String groupType, String groupRegion) throws ServiceException {
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();

        try {
            String sqlRequest = SELECT_GROUP_BY_STATUS_REGION_TYPE + GROUP_STATUS + groupStatus;
            if (!groupType.equals(AdminGroupModifyPage.ALL_VALUE)) {
                sqlRequest += SQL_AND + GROUP_TYPE + "'" + groupType + "'";
            }
            if (!groupRegion.equals(AdminCourseModifyPage.ALL_VALUE)) {
                sqlRequest += SQL_AND + GROUP_REGION + "'" + groupRegion + "'";
            }

            return workGroupDAO.getGroupListBySQLRequest(sqlRequest);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean createWorkGroup(WorkGroup workGroup) throws ServiceException {
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();

        try {
            return workGroupDAO.create(workGroup);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean updateWorkGroup(WorkGroup workGroup) throws ServiceException {
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();

        try {
            return workGroupDAO.update(workGroup);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public boolean deleteWorkGroup(Integer groupId) throws ServiceException {
        WorkGroupDAO workGroupDAO = new WorkGroupDAO();
        WorkGroup workGroup = new WorkGroup();
        workGroup.setWorkGroupId(groupId);

        try {
            return workGroupDAO.delete(workGroup);
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public List<UserForAdmin> takeUserListByFilter(Integer userStatus) throws ServiceException {
        UserDataDAO userDataDAO = new UserDataDAO();

        try {
            return userDataDAO.getUserDataListByStatus(userStatus);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean updateUser(User user, UserData userData) throws ServiceException {
        UserDataDAO userDataDAO = new UserDataDAO();
        UserDAO userDAO = new UserDAO();

        try {
            User currentUser = userDAO.getEntityById(user.getUserId());
            currentUser.setStatus(user.getStatus());
            currentUser.setEmail(user.getEmail());
            boolean userUpdateSuccess = userDAO.update(currentUser);

            if (userUpdateSuccess) {
                UserData currentUserData = userDataDAO.getEntityById(user.getUserId());
                currentUserData.setName(userData.getName());
                currentUserData.setSurname(userData.getSurname());
                boolean userDataUpdateSuccess = userDataDAO.update(currentUserData);

                return userDataUpdateSuccess;
            } else {
                return false;
            }
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e);
        }
    }
}
