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
}
