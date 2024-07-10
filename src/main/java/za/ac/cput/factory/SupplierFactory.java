package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Supplier;
import za.ac.cput.util.SupplierHelper;

public class SupplierFactory {

    public static Supplier buildSupplier(long supplierId, String firstName, String lastName, Contact contact){
        if (SupplierHelper.validId(supplierId) || SupplierHelper.isNullOrEmpty(firstName)
                || SupplierHelper.isNullOrEmpty(lastName) || contact == null){
            return null;
        }

        return new Supplier.Builder().setSupplierID(supplierId).setFirstName(firstName).setLastName(lastName)
                .setContact(contact).build();

    }

}
