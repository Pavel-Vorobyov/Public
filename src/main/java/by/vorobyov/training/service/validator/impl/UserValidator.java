package by.vorobyov.training.service.validator.impl;

import by.vorobyov.training.dto.entity.User;
import by.vorobyov.training.service.validator.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class checks login, password and email from an entity
 * {@link by.vorobyov.training.dto.entity.User User}
 * by regex.
 */
public class UserValidator implements IValidator<User> {
    public static final String USER_EMAIL_MATCHER = "^(\\w+@[a-zA-Z_]+?\\.[ru|com|ua|by|org]{2,10})$";
    public static final String USER_PASS_MATCHER = "^(\\w{8,16})$";
    public static final String USER_LOGIN_MATCHER = "^(\\w{1,16})$";


    @Override
    public boolean checkEntity(User entity) {
        String login = entity.getLogin();

        Pattern pattern = Pattern.compile(USER_LOGIN_MATCHER);
        Matcher matcher = pattern.matcher(login);

        if (matcher.matches()) {

            String password = entity.getPassword();
            pattern = Pattern.compile(USER_PASS_MATCHER);
            matcher = pattern.matcher(password);

            return matcher.matches() ? checkEmail(entity.getEmail()) : false;
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
