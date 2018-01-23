package by.vorobyov.training.dto;

import by.vorobyov.training.dto.entity.UserData;

import java.util.List;

public class StudentGroup {
    private String workGroupTitle;
    private String studentName;
    private List<UserData> userDataList;

    public String getWorkGroupTitle() {
        return workGroupTitle;
    }

    public void setWorkGroupTitle(String workGroupTitle) {
        this.workGroupTitle = workGroupTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGroup that = (StudentGroup) o;

        if (workGroupTitle != null ? !workGroupTitle.equals(that.workGroupTitle) : that.workGroupTitle != null)
            return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        return userDataList != null ? userDataList.equals(that.userDataList) : that.userDataList == null;
    }

    @Override
    public int hashCode() {
        int result = workGroupTitle != null ? workGroupTitle.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (userDataList != null ? userDataList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "workGroupTitle='" + workGroupTitle + '\'' +
                ", studentName='" + studentName + '\'' +
                ", userDataList=" + userDataList +
                '}';
    }
}
