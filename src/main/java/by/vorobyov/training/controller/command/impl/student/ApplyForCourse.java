package by.vorobyov.training.controller.command.impl.student;

import by.vorobyov.training.controller.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplyForCourse implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        StudentService studentDAO = new StudentService();
//
//        Integer userId = Integer.valueOf(request.getParameter(UserParameterName.USER_ID));
//        Integer courseId = Integer.valueOf(request.getParameter(CourseParameterName.COURSE_ID));
//
//        try {
//            studentDAO.applyForCourse(userId, courseId);
//        } catch () {
//
//        }

    }
}
