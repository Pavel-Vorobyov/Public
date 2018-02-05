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
        String login = entity.getLogin();

        Pattern pattern = Pattern.compile(USER_LOG_PASS_MATCHER);
        Matcher loginMatcher = pattern.matcher(login);

        if (loginMatcher.matches()) {

            String password = entity.getPassword();
            loginMatcher = pattern.matcher(password);

            return loginMatcher.matches() ? checkEmail(entity.getEmail()) : false;
        } else {
            return false;
        }

    }

    public boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(USER_EMAIL_MATCHER);
        Matcher mailMatcher = pattern.matcher(email);

        return mailMatcher.matches();
    }
}
