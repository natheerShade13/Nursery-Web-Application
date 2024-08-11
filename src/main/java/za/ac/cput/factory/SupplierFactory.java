package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Supplier;
import za.ac.cput.util.SupplierHelper;

public class SupplierFactory {

    public static Supplier buildSupplier(String firstName, String lastName, String email,String password
            , String contactNumber){
        if (SupplierHelper.isNullOrEmpty(firstName)
                || SupplierHelper.isNullOrEmpty(lastName) || SupplierHelper.validateEmail(email)
                || SupplierHelper.checkNumber(contactNumber)|| SupplierHelper.isNullOrEmpty(password)){
            return null;
        }

        return new Supplier.Builder().setFirstName(firstName).setLastName(lastName)
                .setEmail(email).setContactNumber(contactNumber).setPassword(password).build();
    }
}
