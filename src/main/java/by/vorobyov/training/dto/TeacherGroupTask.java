package by.vorobyov.training.dto;

import by.vorobyov.training.dto.entity.Task;

import java.util.List;

public class TeacherGroupTask {
    private String groupTitle;
    private Integer groupId;
    private List<Task> taskList;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherGroupTask that = (TeacherGroupTask) o;

        if (groupTitle != null ? !groupTitle.equals(that.groupTitle) : that.groupTitle != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        return taskList != null ? taskList.equals(that.taskList) : that.taskList == null;
    }

    @Override
    public int hashCode() {
        int result = groupTitle != null ? groupTitle.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (taskList != null ? taskList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeacherGroupTask{" +
                "groupTitle='" + groupTitle + '\'' +
                ", groupId=" + groupId +
                ", taskList=" + taskList +
                '}';
    }
}
