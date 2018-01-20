package by.vorobyov.training.controller.command;

public class URLCommand {
    private URLCommand() {
    }

    public final static String HOME_STUDENT = "jsp/home-student.jsp";
    public final static String TRAINING_PORTAL = "command?command=training-portal-page";
    public static final String TRAINING_PAGE = "command?command=training-page";
    public static final String TRAINING_GROUP_PAGE = "command?command=training-group-page&group-id=";
    public static final String TRAINING_TASK_PAGE = "command?command=training-task-page&task-id=";
    public static final String TRAINING_GROUP_LIST = "command?command=training-group-list-page";



}
