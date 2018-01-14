package by.vorobyov.training.entity;

import java.io.Serializable;

public class User1 implements Serializable {
    private Integer userId;
    private Integer status;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String description;
    private Integer creationTime;

    public User1() {
    }

    public User1(Integer userId, Integer status, String userName, String userSurname
            , String userEmail, Integer creationTime, String description) {
        this.userId = userId;
        this.status = status;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.description = description;
        this.creationTime = creationTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User1 user1 = (User1) o;

        if (!userId.equals(user1.userId)) return false;
        if (!status.equals(user1.status)) return false;
        if (!userName.equals(user1.userName)) return false;
        if (!userSurname.equals(user1.userSurname)) return false;
        if (!userEmail.equals(user1.userEmail)) return false;
        if (!description.equals(user1.description)) return false;
        return creationTime.equals(user1.creationTime);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userSurname.hashCode();
        result = 31 * result + userEmail.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + creationTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User1{" +
                "userId=" + userId +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", description='" + description + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
