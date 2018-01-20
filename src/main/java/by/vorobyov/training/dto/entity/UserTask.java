package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class UserTask implements Serializable {
    private Integer userTaskId;
    private Integer userId;
    private Integer taskId;
    private String creationTime;
    private String deadLine;
    private Integer estimate;
    private Integer status;
    private Integer commentId;
    private Integer workGroupId;
    private boolean userTaskEmpty = false;

    public UserTask() {
    }

    public UserTask(Integer userTaskId, Integer userId, Integer taskId, String creationTime
        , String deadLine, Integer estimate, Integer status, Integer commentId, Integer workGroupId) {
        this.userTaskId = userTaskId;
        this.userId = userId;
        this.taskId = taskId;
        this.creationTime = creationTime;
        this.deadLine = deadLine;
        this.estimate = estimate;
        this.status = status;
        this.commentId = commentId;
        this.workGroupId = workGroupId;
    }

    public static UserTask emptyEntity() {
        UserTask userTask = new UserTask();
        userTask.setUserTaskEmpty(true);
        return userTask;
    }

    public Integer getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(Integer userTaskId) {
        this.userTaskId = userTaskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public boolean isUserTaskEmpty() {
        return userTaskEmpty;
    }

    public void setUserTaskEmpty(boolean userTaskEmpty) {
        this.userTaskEmpty = userTaskEmpty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTask userTask = (UserTask) o;

        if (userTaskEmpty != userTask.userTaskEmpty) return false;
        if (!userTaskId.equals(userTask.userTaskId)) return false;
        if (!userId.equals(userTask.userId)) return false;
        if (!taskId.equals(userTask.taskId)) return false;
        if (!creationTime.equals(userTask.creationTime)) return false;
        if (!deadLine.equals(userTask.deadLine)) return false;
        if (!estimate.equals(userTask.estimate)) return false;
        if (!status.equals(userTask.status)) return false;
        if (!commentId.equals(userTask.commentId)) return false;
        return workGroupId.equals(userTask.workGroupId);
    }

    @Override
    public int hashCode() {
        int result = userTaskId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + taskId.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + deadLine.hashCode();
        result = 31 * result + estimate.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + commentId.hashCode();
        result = 31 * result + workGroupId.hashCode();
        result = 31 * result + (userTaskEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "userTaskId=" + userTaskId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", creationTime='" + creationTime + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", estimate=" + estimate +
                ", status=" + status +
                ", commentId=" + commentId +
                ", workGroupId=" + workGroupId +
                ", userTaskEmpty=" + userTaskEmpty +
                '}';
    }
}
