package by.vorobyov.training.service.validator.impl;

import by.vorobyov.training.dto.entity.UserData;
import by.vorobyov.training.service.validator.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class checks name and surname from an entity
 * {@link by.vorobyov.training.dto.entity.UserData UserData}
 * by regex.
 */
public class UserDataValidator implements IValidator<UserData> {
    public static final String USER_NAME_MATCHER = "^(\\w){1,40}";
    public static final String USER_SURNAME_MATCHER = "^(\\w){1,40}";

    @Override
    public boolean checkEntity(UserData entity) {
        String userName = entity.getName();

        Pattern pattern = Pattern.compile(USER_NAME_MATCHER);
        Matcher matcher = pattern.matcher(userName);

        if (matcher.matches()) {

            String surname = entity.getSurname();

            pattern = Pattern.compile(USER_SURNAME_MATCHER);
            matcher = pattern.matcher(surname);

            return matcher.matches();
        } else {
            return false;
        }
    }
}
