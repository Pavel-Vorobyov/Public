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

        if (!groupHerf.equals(that.groupHerf)) return false;
        if (!workGroupTitle.equals(that.workGroupTitle)) return false;
        if (!courseRegion.equals(that.courseRegion)) return false;
        if (!courseTitle.equals(that.courseTitle)) return false;
        return courseDescription.equals(that.courseDescription);
    }

    @Override
    public int hashCode() {
        int result = groupHerf.hashCode();
        result = 31 * result + workGroupTitle.hashCode();
        result = 31 * result + courseRegion.hashCode();
        result = 31 * result + courseTitle.hashCode();
        result = 31 * result + courseDescription.hashCode();
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
