package by.vorobyov.training.dto.entity;

public class UserHasCourse {
    private Integer userId;
    private Integer courseId;
    private boolean empty = false;

    public static UserHasCourse emptyEntity(){
        UserHasCourse userHasCourse = new UserHasCourse();
        userHasCourse.setEmpty(true);

        return userHasCourse;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasCourse that = (UserHasCourse) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return courseId != null ? courseId.equals(that.courseId) : that.courseId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserHasCourseDAO{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                '}';
    }
}
