package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Supplier;
import za.ac.cput.util.SupplierHelper;

public class SupplierFactory {

    public static Supplier buildSupplier(String firstName, String lastName, String password, String email, String phoneNumber){

        if (SupplierHelper.isNullorEmpty(firstName) || SupplierHelper.isNullorEmpty(lastName) || !SupplierHelper.isValidEmail(email)
                || !SupplierHelper.isValidPhoneNumber(phoneNumber)|| SupplierHelper.isNullorEmpty(password)){
            return null;
        }
        return new Supplier.Builder().setFirstName(firstName).setLastName(lastName)
                .setEmail(email).setPhoneNumber(phoneNumber).setPassword(password).build();
    }
}
