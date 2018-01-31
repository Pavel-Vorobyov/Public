package by.vorobyov.training.controller.command.impl.page.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.dto.TeacherUserTask;
import by.vorobyov.training.exception.DAOException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.impl.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherUserTaskPage implements ICommand {
    public static final String TASK_ID = "taskId";
    public static final String GROUP_ID = "groupId";
    public static final String GROUP_TITLE = "groupTitle";
    public static final String TASK_TITLE= "taskTitle";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        List<TeacherUserTask> studentUserTaskList;

        try {
            Integer taskId = Integer.parseInt(request.getParameter(TASK_ID));
            Integer groupId = Integer.parseInt(request.getParameter(GROUP_ID));
            String  groupTitle = request.getParameter(GROUP_TITLE);
            String  taskTitle = request.getParameter(TASK_TITLE);

            studentUserTaskList = teacherService.takeUserTaskList(taskId, groupId);

            if (!studentUserTaskList.isEmpty()) {
                request.setAttribute(AttributeName.STUDENT_USER_TASK_LIST, studentUserTaskList);
                request.setAttribute(GROUP_TITLE, groupTitle);
                request.setAttribute(TASK_TITLE, taskTitle);
                request.setAttribute(TASK_ID, taskId);
                request.setAttribute(GROUP_ID, groupId);

                request.getRequestDispatcher(JspPageName.TEACHER_USER_TASK_LIST_PAGE).forward(request, response);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }


    }
}
