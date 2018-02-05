package by.vorobyov.training.security;

import org.omg.CORBA.PUBLIC_MEMBER;

public class CommandStorage {

    public enum AdminCommand {
        CREATE_COURSE,
        UPDATE_COURSE,
        DELETE_COURSE,
        CREATE_GROUP,
        UPDATE_GROUP,
        DELETE_GROUP,
        UPDATE_USER,
        ADMIN_COURSE_MODERATION_PAGE,
        ADMIN_GROUP_MODERATION_PAGE,
        ADMIN_USER_MODERATION_PAGE
    }

    public enum StudentCommand {
        STUDENT_SUBMIT_TASK,
        STUDENT_TASK_LIST_PAGE,
        STUDENT_GROUP_PAGE
    }

    public enum TeacherCommand {
        TEACHER_UPDATE_TASK,
        TEACHER_CREATE_TASK,
        TEACHER_USER_TASK_PAGE,
        TEACHER_USER_TASK_UPDATE,
        TRAINING_GROUP_LIST_PAGE,
        TRAINING_TASK_LIST_PAGE
    }

    public enum CommonCommand {
        USER_HOME_PAGE,
        STUDENT_USER_DATA_MODIFY,
        TRAINING_PAGE
    }

    public enum GuestCommand {
        SING_IN,
        SING_OUT,
        ADD_USER,
        HOME_PAGE,
        TRAINING_PORTAL_PAGE,
        CHANGE_LOCAL,
        STUDENT_APPLY_FOR_COURSE
    }
}
