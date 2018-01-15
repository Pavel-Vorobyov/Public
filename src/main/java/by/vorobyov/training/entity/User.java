package by.vorobyov.training.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer accountId;
    private String login;
    private String password;
    private Integer status;
    private boolean userExist = true;

    public User() {
    }


    public User(String login, String password, Integer status, boolean userExist) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.userExist = userExist;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    public boolean isUserExist() {
        return userExist;
    }

    public void setUserExist(boolean userExist) {
        this.userExist = userExist;
    }

    public static User emptyUser() {
        User user = new User();
        user.setUserExist(false);
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userExist != user.userExist) return false;
        if (!accountId.equals(user.accountId)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        return status.equals(user.status);
    }

    @Override
    public int hashCode() {
        int result = accountId.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + (userExist ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountId=" + accountId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", userExist=" + userExist +
                '}';
    }
}
