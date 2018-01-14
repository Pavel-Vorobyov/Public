package by.vorobyov.training.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer accountId;
    private String login;
    private String password;
    private Integer status;

    public User() {
    }


    public User(String login, String password, Integer status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

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
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountId=" + accountId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
