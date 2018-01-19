package by.vorobyov.training.dto;

public class TeachingUserTask {
    private String studentName;
    private Integer startTime;
    private Integer deadline;
    private Integer estimate;
    private Integer status;


    public TeachingUserTask() {
    }

    public TeachingUserTask(String studentName, Integer startTime, Integer deadline
        , Integer estimate, Integer status) {
        this.studentName = studentName;
        this.startTime = startTime;
        this.deadline = deadline;
        this.estimate = estimate;
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
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
