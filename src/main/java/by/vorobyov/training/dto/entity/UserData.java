package by.vorobyov.training.dto.entity;

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
        if (!userId.equals(userData.userId)) return false;
        if (!name.equals(userData.name)) return false;
        if (!surname.equals(userData.surname)) return false;
        if (!creationTime.equals(userData.creationTime)) return false;
        return description.equals(userData.description);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (userDataEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", creationTime=" + creationTime +
                ", description='" + description + '\'' +
                ", userDataEmpty=" + userDataEmpty +
                '}';
    }
}
