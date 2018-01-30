package by.vorobyov.training.dto;

public class UserForAdmin {
    private Integer userId;
    private String name;
    private String surname;
    private String creationTime;
    private String email;
    private Integer status;

    public UserForAdmin() {
    }

    public UserForAdmin(Integer userId, String name, String surname
        , String creationTime, String email, Integer status) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.creationTime = creationTime;
        this.email = email;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
