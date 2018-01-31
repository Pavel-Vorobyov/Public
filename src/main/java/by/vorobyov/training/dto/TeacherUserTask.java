package by.vorobyov.training.dto;

public class TeacherUserTask {
    private Integer userTaskId;
    private String studentName;
    private String startTime;
    private String deadline;
    private Integer estimate;
    private Integer status;
    private boolean teachingUserTaskEmpty = false;

    public TeacherUserTask() {
    }

    public TeacherUserTask(String studentName, String startTime, String deadline
        , Integer estimate, Integer status) {
        this.studentName = studentName;
        this.startTime = startTime;
        this.deadline = deadline;
        this.estimate = estimate;
        this.status = status;
    }

    public TeacherUserTask emptyTeacherUserTask() {
        TeacherUserTask teacherUserTask = new TeacherUserTask();
        teacherUserTask.setTeachingUserTaskEmpty(true);
        return teacherUserTask;
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

        TeacherUserTask that = (TeacherUserTask) o;

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
        return "TeacherUserTask{" +
                "studentName='" + studentName + '\'' +
                ", startTime=" + startTime +
                ", deadline=" + deadline +
                ", estimate=" + estimate +
                ", status=" + status +
                '}';
    }
}
