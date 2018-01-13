package by.vorobyov.training.database.creator;

import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountCreator {
    public Account createAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();

        account.setAccountId(resultSet.getInt(UserColumnName.ID));
        account.setLogin(resultSet.getString(UserColumnName.LOGIN));
        account.setPassword(resultSet.getString(UserColumnName.PASSWORD));
        account.setStatus(resultSet.getInt(UserColumnName.STATUS));

        return account;
    }
}
