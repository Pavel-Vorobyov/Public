//package by.vorobyov.training.service.impl;
//
//import by.vorobyov.training.creator.impl.UserCreator1;
//import by.vorobyov.training.database.connectionpool.ConnectionPool;
//import by.vorobyov.training.creator.impl.CourseCreator;
//import by.vorobyov.training.creator.impl.WorkGroupCreator;
//import by.vorobyov.training.dto.entity.User1;
//import by.vorobyov.training.service.CommonService;
//import by.vorobyov.training.database.dao.preparedquery.*;
//import by.vorobyov.training.exception.DAOException;
//import by.vorobyov.training.dto.entity.Course;
//import by.vorobyov.training.dto.entity.WorkGroup;
//
//import java.sql.*;
//import java.util.List;
//
//public class AdminService extends CommonService {
//
//    public List<User1> takeUserList() {
//
//    }
//
//    public List<User1> takeUserListByStatus(Integer status) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        UserCreator1 userCreator1 = new UserCreator1();
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//
//            preparedStatement = connection.prepareStatement(UserDataQuery.SELECT_ALL_USER_DATA_BY_STATUS_BETWEEN);
//            preparedStatement.setInt(1, status);
//            preparedStatement.setInt(2, status);
//
//            resultSet = preparedStatement.executeQuery();
//
//            return userCreator1.createUsersList(resultSet);
//
//        } catch (DAOException |SQLException e) {
//            e.printStackTrace();                //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//        return null;
//    }
//
//    public void deleteAccount(Integer accountId) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        UserCreator1 userCreator1 = new UserCreator1();
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(UserQuery.DELETE_USER_BY_ID);
//
//            preparedStatement.setInt(1, accountId);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException | DAOException e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public List<Course> takeCourseListByLeadId(Integer leadId) {
//        Connection connection = null;
//        Statement statement = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        CourseCreator courseCreator = new CourseCreator();
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(CourseQuery.SELECT_COURSE_BY_LEAD_ID);
//            preparedStatement.setInt(1, leadId);
//            resultSet = preparedStatement.executeQuery();
//
//            return courseCreator.createCourseList(resultSet);
//
//        } catch (SQLException | DAOException e) {
//            e.printStackTrace();       //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//        return null;
//    }
//
//    public void addCourse(Course course) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(CourseQuery.COURSE_INSERT);
//
//            preparedStatement.setString(1, course.getTitle());
//            preparedStatement.setString(2, course.getRegion());
//            preparedStatement.setString(3, course.getCourseDescription());
//            preparedStatement.setInt(4, course.getLeadId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException |DAOException e) {
//            e.printStackTrace();                    //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void updateCourse(Course course) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(CourseQuery.UPDATE_COURSE);
//
//            preparedStatement.setString(1, course.getTitle());
//            preparedStatement.setString(2, course.getRegion());
//            preparedStatement.setString(3, course.getCourseDescription());
//            preparedStatement.setInt(4, course.getCourseId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException | DAOException e) {
//            e.printStackTrace();                                 //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void deleteCourse(Course course) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(CourseQuery.DELETE_COURSE);
//
//            preparedStatement.setInt(1, course.getCourseId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException | DAOException  e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
////    public void takeWorkGroupList() {
////
////    }
//
//    public void addWorkGroup(WorkGroup workGroup) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(WorkGroupQuery.WORK_GROUP_INSERT);
//
//            preparedStatement.setString(1, workGroup.getTitle());
//            preparedStatement.setString(2, workGroup.getCourseDescription());
//            preparedStatement.setInt(3, workGroup.getLeadId());
//            preparedStatement.setInt(4, workGroup.getCourseId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException |DAOException e) {
//            e.printStackTrace();                    //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void updateWorkGroup(WorkGroup workGroup) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(CourseQuery.UPDATE_COURSE);
//
//            preparedStatement.setString(1, workGroup.getTitle());
//            preparedStatement.setString(2, workGroup.getCourseDescription());
//            preparedStatement.setInt(3, workGroup.getLeadId());
//            preparedStatement.setInt(4, workGroup.getCourseId());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException |DAOException e) {
//            e.printStackTrace();                    //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void deleteWorkGroup(WorkGroup workGroup) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(WorkGroupQuery.DELETE_WORK_GROUP_BY_ID);
//
//            preparedStatement.setInt(1, workGroup.getWorkGroupId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException | DAOException  e) {
//            e.printStackTrace();
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void addStudentInWorkGroupById(Integer userId, Integer workGroupId) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(UserHasGroupQuery.USER_HAS_GROUP_INSERT);
//
//            preparedStatement.setInt(1, userId);
//            preparedStatement.setInt(2, workGroupId);
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException |DAOException e) {
//            e.printStackTrace();                    //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void deleteStudentFromWorkGroup(Integer userId, Integer workGroupId) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(UserHasGroupQuery.DELETE_USER_HAS_GROUP);
//
//            preparedStatement.setInt(1, userId);
//            preparedStatement.setInt(2, workGroupId);
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException |DAOException e) {
//            e.printStackTrace();                    //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//    public void updateWorkGroupLead(Integer leadId) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet;
//        WorkGroupCreator workGroupCreator = new WorkGroupCreator();
//
//        try {
//            connection = ConnectionPool.getInstance().getConnection();
//            preparedStatement = connection.prepareStatement(WorkGroupQuery.UPDATE_GROUP_LEAD_BY_GROUP_ID);
//
//            preparedStatement.setInt(1, leadId);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException |DAOException e) {
//            e.printStackTrace();                    //Залогировать
//        } finally {
//            super.closePreparedStatement(preparedStatement);
//            super.closeConnection(connection);
//        }
//    }
//
//}