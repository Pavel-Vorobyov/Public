package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class UserTask implements Serializable {
    private Integer userTaskId;
    private Integer userId;
    private Integer taskId;
    private String taskTitle;
    private String creationTime;
    private String deadline;
    private Integer estimate;
    private Integer status;
    private String comment;
    private Integer workGroupId;
    private boolean userTaskEmpty = false;

    public UserTask() {
    }

    public UserTask(Integer userTaskId, Integer userId, Integer taskId, String taskTitle, String creationTime
        , String deadline, Integer estimate, Integer status, String comment, Integer workGroupId) {
        this.userTaskId = userTaskId;
        this.userId = userId;
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.creationTime = creationTime;
        this.deadline = deadline;
        this.estimate = estimate;
        this.status = status;
        this.comment = comment;
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

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String commentId) {
        this.comment = commentId;
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
        if (userTaskId != null ? !userTaskId.equals(userTask.userTaskId) : userTask.userTaskId != null) return false;
        if (userId != null ? !userId.equals(userTask.userId) : userTask.userId != null) return false;
        if (taskId != null ? !taskId.equals(userTask.taskId) : userTask.taskId != null) return false;
        if (taskTitle != null ? !taskTitle.equals(userTask.taskTitle) : userTask.taskTitle != null) return false;
        if (creationTime != null ? !creationTime.equals(userTask.creationTime) : userTask.creationTime != null)
            return false;
        if (deadline != null ? !deadline.equals(userTask.deadline) : userTask.deadline != null) return false;
        if (estimate != null ? !estimate.equals(userTask.estimate) : userTask.estimate != null) return false;
        if (status != null ? !status.equals(userTask.status) : userTask.status != null) return false;
        if (comment != null ? !comment.equals(userTask.comment) : userTask.comment != null) return false;
        return workGroupId != null ? workGroupId.equals(userTask.workGroupId) : userTask.workGroupId == null;
    }

    @Override
    public int hashCode() {
        int result = userTaskId != null ? userTaskId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (taskTitle != null ? taskTitle.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (estimate != null ? estimate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (workGroupId != null ? workGroupId.hashCode() : 0);
        result = 31 * result + (userTaskEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "userTaskId=" + userTaskId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", taskTitle='" + taskTitle + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", deadline='" + deadline + '\'' +
                ", estimate=" + estimate +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", workGroupId=" + workGroupId +
                ", userTaskEmpty=" + userTaskEmpty +
                '}';
    }
}
