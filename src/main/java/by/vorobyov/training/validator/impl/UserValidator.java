package by.vorobyov.training.validator.impl;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.validator.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements IValidator<User> {
    public static final String USER_EMAIL_MATCHER = "^(\\w+@[a-zA-Z_]+?\\.[ru|com|ua|by|org]{2,6})$";
    public static final String USER_LOG_PASS_MATCHER = "^([\\w]{8,16})$";

    @Override
    public boolean checkEntity(User entity) {
        Pattern pattern = Pattern.compile(USER_LOG_PASS_MATCHER);

        String login = entity.getLogin();
        Matcher matcher = pattern.matcher(login);

        if (matcher.matches()) {

            String password = entity.getPassword();
            matcher = pattern.matcher(password);

            return matcher.matches() ? checkEmail(entity.getEmail()) : false;
        } else {
            return false;
        }

    }

    public boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(USER_EMAIL_MATCHER);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
