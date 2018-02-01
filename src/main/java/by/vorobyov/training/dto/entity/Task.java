package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class Task implements Serializable {
    private String taskHerf;
    private Integer taskId;
    private String title;
    private String description;
    private Integer authorId;
    private String creationTime;
    private String deadline;
    private boolean taskEmpty = false;

    public Task() {
    }

    public Task(String taskHerf, Integer taskId, String title, String description, Integer authorId
        , String creationTime, String deadline) {
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

    public boolean isTaskEmpty() {
        return taskEmpty;
    }

    public void setTaskEmpty(boolean taskEmpty) {
        this.taskEmpty = taskEmpty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskEmpty != task.taskEmpty) return false;
        if (taskHerf != null ? !taskHerf.equals(task.taskHerf) : task.taskHerf != null) return false;
        if (taskId != null ? !taskId.equals(task.taskId) : task.taskId != null) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (authorId != null ? !authorId.equals(task.authorId) : task.authorId != null) return false;
        if (creationTime != null ? !creationTime.equals(task.creationTime) : task.creationTime != null) return false;
        return deadline != null ? deadline.equals(task.deadline) : task.deadline == null;
    }

    @Override
    public int hashCode() {
        int result = taskHerf != null ? taskHerf.hashCode() : 0;
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (taskEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskHerf='" + taskHerf + '\'' +
                ", taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                ", creationTime='" + creationTime + '\'' +
                ", deadline='" + deadline + '\'' +
                ", taskEmpty=" + taskEmpty +
                '}';
    }
}
