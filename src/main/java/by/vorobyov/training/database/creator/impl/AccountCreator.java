package by.vorobyov.training.database.creator.impl;

import by.vorobyov.training.database.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountCreator implements ICreator<Account> {
    public AccountCreator() {
    }

    @Override
    public List<Account> createEntityList(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Account createEntity(ResultSet resultSet) throws SQLException {
        Account account = new Account();

        account.setAccountId(resultSet.getInt(UserColumnName.ID));
        account.setLogin(resultSet.getString(UserColumnName.LOGIN));
        account.setPassword(resultSet.getString(UserColumnName.PASSWORD));
        account.setStatus(resultSet.getInt(UserColumnName.STATUS));

        return account;
    }

}
