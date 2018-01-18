package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class WorkGroup implements Serializable {
    private Integer workGroupId;
    private String title;
    private String description;
    private Integer leadId;
    private Integer courseId;
    private boolean groupEmpty = false;

    public WorkGroup() {
    }

    public WorkGroup(Integer workGroupId, String title, String description
        , Integer leadId, Integer courseId) {
        this.workGroupId = workGroupId;
        this.title = title;
        this.description = description;
        this.leadId = leadId;
        this.courseId =courseId;
    }

    public static WorkGroup emptyEntity() {
        WorkGroup workGroup = new WorkGroup();
        workGroup.setGroupEmpty(true);
        return workGroup;
    }

    public boolean isGroupEmpty() {
        return groupEmpty;
    }

    public void setGroupEmpty(boolean groupEmpty) {
        this.groupEmpty = groupEmpty;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkGroup workGroup = (WorkGroup) o;

        if (!workGroupId.equals(workGroup.workGroupId)) return false;
        if (!title.equals(workGroup.title)) return false;
        if (!description.equals(workGroup.description)) return false;
        if (!leadId.equals(workGroup.leadId)) return false;
        return courseId.equals(workGroup.courseId);
    }

    @Override
    public int hashCode() {
        int result = workGroupId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + leadId.hashCode();
        result = 31 * result + courseId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WorkGroup{" +
                "workGroupId=" + workGroupId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", leadId=" + leadId +
                ", courseId=" + courseId +
                '}';
    }
}
