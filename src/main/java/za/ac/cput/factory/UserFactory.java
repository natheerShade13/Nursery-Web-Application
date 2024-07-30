package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.UserHelper;

public class UserFactory {

    public static User buildUser(String firstName, String lastName, String password, String email, String phoneNumber) {

        if (UserHelper.isNullorEmpty(firstName) || UserHelper.isNullorEmpty(lastName) || UserHelper.isNullorEmpty(password) ||
                UserHelper.isValidEmail(email) || UserHelper.isValidPhoneNumber(phoneNumber)) {
            return null;
        }
        return new User.Builder().setFirstName(firstName).setLastName(lastName).setEmail(email).setPassword(password).
                setPhoneNumber(phoneNumber).build();

    }
}