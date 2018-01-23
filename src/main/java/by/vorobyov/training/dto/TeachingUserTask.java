package by.vorobyov.training.dto;

public class TeachingUserTask {
    private Integer userTaskId;
    private String studentName;
    private String startTime;
    private String deadline;
    private Integer estimate;
    private Integer status;
    private Integer groupId;
    private Integer taskId;
    private boolean teachingUserTaskEmpty = false;

    public TeachingUserTask() {
    }

    public TeachingUserTask(String studentName, String startTime, String deadline
        , Integer estimate, Integer status) {
        this.studentName = studentName;
        this.startTime = startTime;
        this.deadline = deadline;
        this.estimate = estimate;
        this.status = status;
    }

    public TeachingUserTask emptyTeacherUserTask() {
        TeachingUserTask teachingUserTask = new TeachingUserTask();
        teachingUserTask.setTeachingUserTaskEmpty(true);
        return teachingUserTask;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public boolean isTeachingUserTaskEmpty() {
        return teachingUserTaskEmpty;
    }

    public void setTeachingUserTaskEmpty(boolean teachingUserTaskEmpty) {
        this.teachingUserTaskEmpty = teachingUserTaskEmpty;
    }

    public Integer getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(Integer userTaskId) {
        this.userTaskId = userTaskId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeachingUserTask that = (TeachingUserTask) o;

        if (!studentName.equals(that.studentName)) return false;
        if (!startTime.equals(that.startTime)) return false;
        if (!deadline.equals(that.deadline)) return false;
        if (!estimate.equals(that.estimate)) return false;
        return status.equals(that.status);
    }

    @Override
    public int hashCode() {
        int result = studentName.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + deadline.hashCode();
        result = 31 * result + estimate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TeachingUserTask{" +
                "studentName='" + studentName + '\'' +
                ", startTime=" + startTime +
                ", deadline=" + deadline +
                ", estimate=" + estimate +
                ", status=" + status +
                '}';
    }
}
