package by.vorobyov.training.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer courseId;
    private String title;
    private String region;
    private String description;
    private Integer leadId;
    private Integer status;

    public Course(){
    }

    public Course(Integer courseId, String title, String region
            , String description, Integer leadId, Integer status) {
        this.courseId = courseId;
        this.title = title;
        this.region = region;
        this.description = description;
        this.leadId = leadId;
        this.status = status;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return description;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!courseId.equals(course.courseId)) return false;
        if (!title.equals(course.title)) return false;
        if (!region.equals(course.region)) return false;
        if (!description.equals(course.description)) return false;
        if (!leadId.equals(course.leadId)) return false;
        return status != null ? status.equals(course.status) : course.status == null;
    }

    @Override
    public int hashCode() {
        int result = courseId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + leadId.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", leadId=" + leadId +
                ", status=" + status +
                '}';
    }
}