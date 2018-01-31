package by.vorobyov.training.controller.command;

import by.vorobyov.training.controller.command.impl.common.AddUser;
import by.vorobyov.training.controller.command.impl.common.SingIn;
import by.vorobyov.training.controller.command.impl.common.SingOut;
import by.vorobyov.training.controller.command.impl.admin.*;
import by.vorobyov.training.controller.command.impl.page.admin.AdminCourseModifyPage;
import by.vorobyov.training.controller.command.impl.page.admin.AdminGroupModifyPage;
import by.vorobyov.training.controller.command.impl.page.admin.AdminUserModifyPage;
import by.vorobyov.training.controller.command.impl.page.teacher.TeacherUserTaskPage;
import by.vorobyov.training.controller.command.impl.student.StudentSubmitTask;
import by.vorobyov.training.controller.command.impl.student.StudentUserDataModify;
import by.vorobyov.training.controller.command.impl.teacher.TeacherCreateTask;
import by.vorobyov.training.controller.command.impl.page.common.*;
import by.vorobyov.training.controller.command.impl.page.student.StudentGroupListPage;
import by.vorobyov.training.controller.command.impl.page.common.UserHomePage;
import by.vorobyov.training.controller.command.impl.page.student.StudentTaskListPage;
import by.vorobyov.training.controller.command.impl.page.teacher.TeacherGroupPage;
import by.vorobyov.training.controller.command.impl.page.teacher.TeacherGroupTaskPage;
import by.vorobyov.training.controller.command.impl.teacher.TeacherUpdateTask;
import by.vorobyov.training.controller.command.impl.teacher.TeacherUserTaskUpdate;

import java.util.HashMap;
import java.util.Map;

public class CommandStorage {
    private final static CommandStorage INSTANCE = new CommandStorage();
    private final Map<String, ICommand> commandStorage = new HashMap<>();

    public static CommandStorage getInstance() {
        return INSTANCE;
    }

    private CommandStorage() {

        commandStorage.put(CommandName.HOME_PAGE, new HomePage());
        commandStorage.put(CommandName.TRAINING_PORTAL, new TrainingPortalPage());
        commandStorage.put(CommandName.SING_IN, new SingIn());
        commandStorage.put(CommandName.TRAINING_PAGE, new TrainingPage());
        commandStorage.put(CommandName.SING_OUT, new SingOut());
        commandStorage.put(CommandName.ADD_USER, new AddUser());
//        commandStorage.put(CommandName.TRAINING_GROUP_LIST_PAGE, new TeacherGroupListPage());
        commandStorage.put(CommandName.TRAINING_GROUP_LIST_PAGE, new TeacherGroupTaskPage());
        commandStorage.put(CommandName.TRAINING_GROUP_PAGE, new TeacherGroupPage());
        commandStorage.put(CommandName.TEACHER_USER_TASK_PAGE, new TeacherUserTaskPage());
        commandStorage.put(CommandName.GROUP_TASK_PAGE, new TeacherGroupTaskPage());
        commandStorage.put(CommandName.TEACHER_CREATE_TASK, new TeacherCreateTask());
        commandStorage.put(CommandName.TEACHER_UPDATE_TASK, new TeacherUpdateTask());
        commandStorage.put(CommandName.TEACHER_USER_TASK_UPDATE, new TeacherUserTaskUpdate());
        commandStorage.put(CommandName.USER_HOME_PAGE, new UserHomePage());
        commandStorage.put(CommandName.STUDENT_TASK_LIST_PAGE, new StudentTaskListPage());
        commandStorage.put(CommandName.STUDENT_GROUP_LIST_PAGE, new StudentGroupListPage());
        commandStorage.put(CommandName.STUDENT_USER_DATA_MODIFY, new StudentUserDataModify());
        commandStorage.put(CommandName.STUDENT_SUBMIT_TASK, new StudentSubmitTask());
        commandStorage.put(CommandName.CREATE_COURSE, new CourseCreation());
        commandStorage.put(CommandName.UPDATE_COURSE, new CourseUpdate());
        commandStorage.put(CommandName.DELETE_COURSE, new CourseDelete());
        commandStorage.put(CommandName.ADMIN_COURSE_MODIFY_PAGE, new AdminCourseModifyPage());
        commandStorage.put(CommandName.ADMIN_GROUP_MODIFY_PAGE, new AdminGroupModifyPage());
        commandStorage.put(CommandName.ADMIN_USER_MODIFY_PAGE, new AdminUserModifyPage());
        commandStorage.put(CommandName.CREATE_GROUP, new GroupCreation());
        commandStorage.put(CommandName.UPDATE_GROUP, new GroupUpdate());
        commandStorage.put(CommandName.DELETE_GROUP, new GroupDelete());
        commandStorage.put(CommandName.UPDATE_USER, new UserUpdate());

    }

    public ICommand getCommand(String commandName) {
        ICommand command = commandStorage.get(commandName);

        return command;
    }
}
