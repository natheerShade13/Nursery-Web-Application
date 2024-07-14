package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    private Contact contact;
    private Supplier supplierA;
    private Supplier supplierB;

    @Test
    void buildSupplier() {
        contact = ContactFactory.buildContact("Jack.Toys@gmail.com", "0677784626");
        supplierA = SupplierFactory.buildSupplier(1, "Jacks", "Toys", contact);
        assertNotNull(supplierA);
        System.out.println(supplierA);
    }

    @Test
    void buildSupplierFail() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        supplierA = SupplierFactory.buildSupplier(1, "Jacks", "", contact);
        assertNotNull(supplierA);
        System.out.println(supplierA);
    }

}