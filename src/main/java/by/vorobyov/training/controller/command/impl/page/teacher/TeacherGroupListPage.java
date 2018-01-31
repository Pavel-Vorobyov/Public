package by.vorobyov.training.controller.command.impl.page.teacher;

import by.vorobyov.training.controller.command.ICommand;
import by.vorobyov.training.controller.command.URLCommand;
import by.vorobyov.training.dto.TeachingGroup;
import by.vorobyov.training.dto.entity.Course;
import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.dto.entity.WorkGroup;
import by.vorobyov.training.exception.ServiceException;
import by.vorobyov.training.resource.AttributeName;
import by.vorobyov.training.resource.JspPageName;
import by.vorobyov.training.service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TeacherGroupListPage implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User teacherUser = (User)request.getSession().getAttribute(AttributeName.USER);

        CommonService commonService = new CommonService();
        try {
            List<WorkGroup> workGroupList = commonService.takeWorkGroupListByLeadId(teacherUser.getUserId());
            List<TeachingGroup> teachingGroupList = new LinkedList<>();

            for (int i=0; i<workGroupList.size(); i++) {
                Integer courseId = workGroupList.get(i).getCourseId();
                Course course = commonService.takeCourseByCourseId(courseId);
                String groupHerf = URLCommand.TEACHER_GROUP_TASK_PAGE + workGroupList.get(i).getWorkGroupId();

                TeachingGroup teachingGroup = new TeachingGroup(groupHerf, workGroupList.get(i).getTitle()
                    , course.getRegion(), course.getTitle(), course.getDescription());
                teachingGroupList.add(teachingGroup);
            }

            request.setAttribute(AttributeName.TEACHING_GROUP_LIST, teachingGroupList);
            request.getRequestDispatcher(JspPageName.TEACHER_GROUP_LIST_PAGE).forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}
