package by.vorobyov.training.service.impl;

import by.vorobyov.training.controller.command.impl.page.admin.AdminHomePage;
import by.vorobyov.training.database.dao.impl.CourseDAO;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.service.CommonService;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.SQLException;
import java.util.List;

public class AdminService extends CommonService {
    public static final String SELECT_COURSE_BY_STATUS_REGION_TYPE = "SELECT *" +
            " FROM course" +
            " WHERE ";
    public static final String COURSE_STATUS = " course.status =";
    public static final String COURSE_REGION = " course.region =";
    public static final String COURSE_TYPE = " course.type =";
    public static final String SQL_AND = " AND ";

    public List<Course> takeCourseListByFilter(Integer courseStatus, String courseType, String courseRegion) throws ServiceException {
        CourseDAO courseDAO = new CourseDAO();

        try {
            String sqlRequest = SELECT_COURSE_BY_STATUS_REGION_TYPE + COURSE_STATUS + courseStatus;
            if (!courseType.equals("All")) {
                sqlRequest += SQL_AND + COURSE_TYPE + "'" + courseType + "'";
            }
            if (!courseRegion.equals("All")) {
                sqlRequest += SQL_AND + COURSE_REGION + "'" + courseRegion + "'";
            }

            return courseDAO.getCourseListBySQLRequest(sqlRequest);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }
    }

}
