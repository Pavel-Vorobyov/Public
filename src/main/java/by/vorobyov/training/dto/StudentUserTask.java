package by.vorobyov.training.dto;

import by.vorobyov.training.dto.entity.UserTask;

import java.util.List;

/**
 * Class describing the transfer object for information about the
 * student task in a group: title of a group,  student name,
 * list of student tasks.
 */
public class StudentUserTask {
    private String workGroupTitle;
    private String studentName;
    private List<UserTask> userTaskList;

    public StudentUserTask() {
    }

    public StudentUserTask(String studentName, String workGroupTitle, List userTaskList) {
        this.studentName = studentName;
        this.workGroupTitle = workGroupTitle;
        this.userTaskList = userTaskList;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getWorkGroupTitle() {
        return workGroupTitle;
    }

    public void setWorkGroupTitle(String workGroupTitle) {
        this.workGroupTitle = workGroupTitle;
    }

    public List<UserTask> getUserTaskList() {
        return userTaskList;
    }

    public void setUserTaskList(List<UserTask> userTaskList) {
        this.userTaskList = userTaskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentUserTask that = (StudentUserTask) o;

        if (workGroupTitle != null ? !workGroupTitle.equals(that.workGroupTitle) : that.workGroupTitle != null)
            return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        return userTaskList != null ? userTaskList.equals(that.userTaskList) : that.userTaskList == null;
    }

    @Override
    public int hashCode() {
        int result = workGroupTitle != null ? workGroupTitle.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (userTaskList != null ? userTaskList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentUserTask{" +
                "workGroupTitle='" + workGroupTitle + '\'' +
                ", studentName='" + studentName + '\'' +
                ", userTaskList=" + userTaskList +
                '}';
    }
}
