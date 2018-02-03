package by.vorobyov.training.dto;

public class TeachingGroup {
    private String groupHerf;
    private String workGroupTitle;
    private String courseRegion;
    private String courseTitle;
    private String courseDescription;

    public TeachingGroup(String groupHerf, String workGroupTitle,
                         String courseRegion, String courseTitle, String courseDescription) {
        this.groupHerf = groupHerf;
        this.workGroupTitle = workGroupTitle;
        this.courseRegion = courseRegion;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
    }

    public String getGroupHerf() {
        return groupHerf;
    }

    public void setGroupHerf(String groupHerf) {
        this.groupHerf = groupHerf;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getWorkGroupTitle() {
        return workGroupTitle;
    }

    public void setWorkGroupTitle(String workGroupTitle) {
        this.workGroupTitle = workGroupTitle;
    }

    public String getCourseRegion() {
        return courseRegion;
    }

    public void setCourseRegion(String courseRegion) {
        this.courseRegion = courseRegion;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeachingGroup that = (TeachingGroup) o;

        if (groupHerf != null ? !groupHerf.equals(that.groupHerf) : that.groupHerf != null) return false;
        if (workGroupTitle != null ? !workGroupTitle.equals(that.workGroupTitle) : that.workGroupTitle != null)
            return false;
        if (courseRegion != null ? !courseRegion.equals(that.courseRegion) : that.courseRegion != null) return false;
        if (courseTitle != null ? !courseTitle.equals(that.courseTitle) : that.courseTitle != null) return false;
        return courseDescription != null ? courseDescription.equals(that.courseDescription) : that.courseDescription == null;
    }

    @Override
    public int hashCode() {
        int result = groupHerf != null ? groupHerf.hashCode() : 0;
        result = 31 * result + (workGroupTitle != null ? workGroupTitle.hashCode() : 0);
        result = 31 * result + (courseRegion != null ? courseRegion.hashCode() : 0);
        result = 31 * result + (courseTitle != null ? courseTitle.hashCode() : 0);
        result = 31 * result + (courseDescription != null ? courseDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeachingGroup{" +
                "groupHerf='" + groupHerf + '\'' +
                ", workGroupTitle='" + workGroupTitle + '\'' +
                ", courseRegion='" + courseRegion + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
