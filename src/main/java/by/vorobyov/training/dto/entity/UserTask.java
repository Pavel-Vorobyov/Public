package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class UserTask implements Serializable {
    private Integer userTaskId;
    private Integer userId;
    private Integer taskId;
    private Integer creationTime;
    private Integer deadLine;
    private Integer estimate;
    private Integer status;
    private Integer commentId;
    private Integer workGroupId;

    public UserTask() {
    }

    public UserTask(Integer userTaskId, Integer userId, Integer taskId, Integer creationTime
        , Integer deadLine, Integer estimate, Integer status, Integer commentId, Integer workGroupId) {
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

    public Integer getUserTaskId() {
        return userTaskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public Integer getDeadLine() {
        return deadLine;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    public void setDeadLine(Integer deadLine) {
        this.deadLine = deadLine;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public void setUserTaskId(Integer userTaskId) {
        this.userTaskId = userTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTask userTask = (UserTask) o;

        if (!userTaskId.equals(userTask.userTaskId)) return false;
        if (!userId.equals(userTask.userId)) return false;
        if (!taskId.equals(userTask.taskId)) return false;
        if (!creationTime.equals(userTask.creationTime)) return false;
        if (!deadLine.equals(userTask.deadLine)) return false;
        if (estimate != null ? !estimate.equals(userTask.estimate) : userTask.estimate != null) return false;
        if (!status.equals(userTask.status)) return false;
        if (commentId != null ? !commentId.equals(userTask.commentId) : userTask.commentId != null) return false;
        return workGroupId.equals(userTask.workGroupId);
    }

    @Override
    public int hashCode() {
        int result = userTaskId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + taskId.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + deadLine.hashCode();
        result = 31 * result + (estimate != null ? estimate.hashCode() : 0);
        result = 31 * result + status.hashCode();
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        result = 31 * result + workGroupId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "userTaskId=" + userTaskId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", creationTime=" + creationTime +
                ", deadLine=" + deadLine +
                ", estimate=" + estimate +
                ", status=" + status +
                ", commentId=" + commentId +
                ", workGroupId=" + workGroupId +
                '}';
    }
}
