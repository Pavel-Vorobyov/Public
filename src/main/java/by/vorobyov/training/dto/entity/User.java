package by.vorobyov.training.dto.entity;

import java.io.Serializable;

/**
 * Class describing the transfer object for information about the
 * user: user ID, login, password, email, mail status and user status.
 */
public class User implements Serializable {
    private Integer userId;
    private String login;
    private String password;
    private String email;
    private Integer status;
    private Integer mailStatus;
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

    public Integer getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(Integer mailStatus) {
        this.mailStatus = mailStatus;
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
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        return mailStatus != null ? mailStatus.equals(user.mailStatus) : user.mailStatus == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (mailStatus != null ? mailStatus.hashCode() : 0);
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
                ", mailStatus=" + mailStatus +
                ", userEmpty=" + userEmpty +
                '}';
    }
}
