package by.vorobyov.training.dto.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String login;
    private String password;
    private String email;
    private Integer status;
    private boolean userEmpty = false;

    public User() {
    }


    public User(String login, String password, String email, Integer status, boolean userEmpty) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.status = status;
        this.userEmpty = userEmpty;
    }

    public static User emptyUser() {
        User user = new User();
        user.setUserEmpty(true);
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUserEmpty() {
        return userEmpty;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isEmpty() {
        return userEmpty;
    }

    public void setUserEmpty(boolean userEmpty) {
        this.userEmpty = userEmpty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userEmpty != user.userEmpty) return false;
        if (!userId.equals(user.userId)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        return status.equals(user.status);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + (userEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", userEmpty=" + userEmpty +
                '}';
    }
}
