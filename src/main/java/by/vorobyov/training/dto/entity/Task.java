package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class Task implements Serializable {
    private Integer taskId;
    private String title;
    private String description;
    private Integer authorId;

    public Task() {
    }

    public Task(Integer taskId, String title, String description, Integer authorId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!taskId.equals(task.taskId)) return false;
        if (!title.equals(task.title)) return false;
        if (!description.equals(task.description)) return false;
        return authorId.equals(task.authorId);
    }

    @Override
    public int hashCode() {
        int result = taskId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + authorId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
