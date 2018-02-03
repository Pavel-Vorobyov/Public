package by.vorobyov.training.security;

import java.security.SecureRandom;

public class Security {
    public static boolean isAllowedToAdmin(String command) {
        boolean isAllowed = false;

        for (CommandStorage.AdminCommand c : CommandStorage.AdminCommand.values()) {
            if (command.equals(c.toString().toLowerCase())) {
                isAllowed = true;
                break;
            }
        }

        return isAllowed ? true : Security.isAllowedToCommon(command);
    }

    public static boolean isAllowedToTeacher(String command) {
        boolean isAllowed = false;

        for (CommandStorage.TeacherCommand c : CommandStorage.TeacherCommand.values()) {
            if (command.equals(c.toString().toLowerCase())) {
                isAllowed = true;
                break;
            }
        }


        return isAllowed ? true : Security.isAllowedToCommon(command);
    }

    public static boolean isAllowedToStudent(String command) {
        boolean isAllowed = false;

        for (CommandStorage.StudentCommand c : CommandStorage.StudentCommand.values()) {
            if (command.equals(c.toString().toLowerCase())) {
                isAllowed = true;
                break;
            }
        }

        return isAllowed ? true : Security.isAllowedToCommon(command);
    }

    public static boolean isAllowedToGuest(String command) {
        boolean isAllowed = false;

        for (CommandStorage.GuestCommand c : CommandStorage.GuestCommand.values()) {
            if (command.equals(c.toString().toLowerCase())) {
                isAllowed = true;
                break;
            }
        }

        return isAllowed;
    }

    private static boolean isAllowedToCommon(String command) {
        boolean isAllowed = false;

        for (CommandStorage.CommonCommand c : CommandStorage.CommonCommand.values()) {
            if (command.equals(c.toString().toLowerCase())) {
                isAllowed = true;
                break;
            }
        }

        return isAllowed ? true : Security.isAllowedToGuest(command);
    }
}
