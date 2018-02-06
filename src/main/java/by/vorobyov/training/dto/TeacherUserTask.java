package by.vorobyov.training.dto;

/**
 * Class describing the transfer object for information about the
 * all students performing on of the group task.<br>
 * There are student name, time when task was created, time when task
 * should be done, estimate, status.<br>
 * Has a link for user task id (UserTaskID)
 *
 * @see by.vorobyov.training.dto.entity.UserTask UserTask
 */
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

        if (teachingUserTaskEmpty != that.teachingUserTaskEmpty) return false;
        if (userTaskId != null ? !userTaskId.equals(that.userTaskId) : that.userTaskId != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (estimate != null ? !estimate.equals(that.estimate) : that.estimate != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = userTaskId != null ? userTaskId.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (estimate != null ? estimate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (teachingUserTaskEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeacherUserTask{" +
                "userTaskId=" + userTaskId +
                ", studentName='" + studentName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", deadline='" + deadline + '\'' +
                ", estimate=" + estimate +
                ", status=" + status +
                ", teachingUserTaskEmpty=" + teachingUserTaskEmpty +
                '}';
    }
}
