package by.vorobyov.training.dto;

/**
 * Class describing the transfer object for information about the
 * user for admin page.<br>
 * Includes name, surname, time when user has been created, email,
 * user status.<br>
 * Has a link for user and user data (userId)
 *
 * @see by.vorobyov.training.dto.entity.User User
 * @see by.vorobyov.training.dto.entity.UserData UserData
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserForAdmin that = (UserForAdmin) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (creationTime != null ? !creationTime.equals(that.creationTime) : that.creationTime != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserForAdmin{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
