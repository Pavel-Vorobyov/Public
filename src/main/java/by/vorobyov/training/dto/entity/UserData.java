package by.vorobyov.training.dto.entity;

/**
 * Class describing the transfer object for information about the
 * user data: name, surname, time when user has been created, description of the user.<br>
 * Has the link on user_id in class User
 *
 * @see by.vorobyov.training.dto.entity.User User
 */
public class UserData {
    private Integer userId;
    private String name;
    private String surname;
    private String creationTime;
    private String description;
    private boolean userDataEmpty = false;

    public UserData() {
    }

    public UserData(Integer userId, String name, String surname
            , String creationTime, String description) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.creationTime = creationTime;
        this.description = description;
    }

    public static UserData emptyUserData() {
        UserData userData = new UserData();
        userData.setUserDataEmpty(true);

        return userData;
    }

    public boolean isUserDataEmpty() {
        return userDataEmpty;
    }

    public void setUserDataEmpty(boolean userDataEmpty) {
        this.userDataEmpty = userDataEmpty;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (userDataEmpty != userData.userDataEmpty) return false;
        if (userId != null ? !userId.equals(userData.userId) : userData.userId != null) return false;
        if (name != null ? !name.equals(userData.name) : userData.name != null) return false;
        if (surname != null ? !surname.equals(userData.surname) : userData.surname != null) return false;
        if (creationTime != null ? !creationTime.equals(userData.creationTime) : userData.creationTime != null)
            return false;
        return description != null ? description.equals(userData.description) : userData.description == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (userDataEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", description='" + description + '\'' +
                ", userDataEmpty=" + userDataEmpty +
                '}';
    }
}
