package by.vorobyov.training.controller.command;

public class URLCommand {
    private URLCommand() {
    }

    public final static String STUDENT_HOME_PAGE = "command?command=student-home-page";
    public final static String TRAINING_PORTAL = "command?command=training-portal-page";
    public static final String TRAINING_PAGE = "command?command=training-page";
    public static final String TRAINING_GROUP_PAGE = "command?command=training-group-page&group-id=";
    public static final String TRAINING_TASK_PAGE = "command?command=training-task-page&task-id=";
    public static final String TRAINING_GROUP_LIST = "command?command=training-group-list-page";
    public static final String ADMIN_HOME_PAGE = "command?command=admin-home-page";



}
