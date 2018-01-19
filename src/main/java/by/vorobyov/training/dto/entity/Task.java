package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class Task implements Serializable {
    private String taskHerf;
    private Integer taskId;
    private String title;
    private String description;
    private Integer authorId;
    private Integer creationTime;
    private Integer deadline;
    private boolean taskEmpty = false;

    public Task() {
    }

    public Task(String taskHerf, Integer taskId, String title, String description, Integer authorId
        , Integer creationTime, Integer deadline) {
        this.taskHerf = taskHerf;
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.creationTime = creationTime;
        this.deadline = deadline;
    }

    public static Task emptyEntity() {
        Task task = new Task();
        task.taskEmpty = true;
        return task;
    }

    public boolean isTaskEmpty() {
        return taskEmpty;
    }

    public void setTaskEmpty(boolean taskEmpty) {
        this.taskEmpty = taskEmpty;
    }

    public String getTaskHerf() {
        return taskHerf;
    }

    public void setTaskHerf(String taskHerf) {
        this.taskHerf = taskHerf;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!taskId.equals(task.taskId)) return false;
        if (!title.equals(task.title)) return false;
        if (!description.equals(task.description)) return false;
        if (!authorId.equals(task.authorId)) return false;
        if (!creationTime.equals(task.creationTime)) return false;
        return deadline.equals(task.deadline);
    }

    @Override
    public int hashCode() {
        int result = taskId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + authorId.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + deadline.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                ", creationTime=" + creationTime +
                ", deadline=" + deadline +
                '}';
    }
}
