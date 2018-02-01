package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer courseId;
    private String title;
    private String region;
    private String description;
    private String type;
    private Integer leadId;
    private Integer status;
    private boolean courseEmpty = false;

    public Course(){
    }

    public Course(Integer courseId, String title, String region
            , String description,String type, Integer leadId, Integer status) {
        this.courseId = courseId;
        this.title = title;
        this.region = region;
        this.description = description;
        this.type = type;
        this.leadId = leadId;
        this.status = status;
    }

    public static Course emptyEntity() {
        Course course = new Course();
        course.setCourseEmpty(true);
        return course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCourseEmpty() {
        return courseEmpty;
    }

    public void setCourseEmpty(boolean courseEmpty) {
        this.courseEmpty = courseEmpty;
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

        if (courseEmpty != course.courseEmpty) return false;
        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        if (region != null ? !region.equals(course.region) : course.region != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (type != null ? !type.equals(course.type) : course.type != null) return false;
        if (leadId != null ? !leadId.equals(course.leadId) : course.leadId != null) return false;
        return status != null ? status.equals(course.status) : course.status == null;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (leadId != null ? leadId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (courseEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", leadId=" + leadId +
                ", status=" + status +
                ", courseEmpty=" + courseEmpty +
                '}';
    }
}