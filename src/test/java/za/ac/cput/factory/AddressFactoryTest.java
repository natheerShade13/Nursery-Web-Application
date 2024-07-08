package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    private Contact contact;
    private Customer customer;
    private Customer customerNull;
    private Address addressA;
    private Address addressB;

    @Test
    void buildAddress() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        customer = CustomerFactory.buildCustomer(213654897, "Jake", "Long"
                , "jakeLong", LocalDate.of(2000, Month.JANUARY, 1), contact);
        addressA = AddressFactory.buildAddress(1, "10", "Church street"
                , "Strandfontein", "7798", "Cape Town", customer);
        assertNotNull(addressA);
        System.out.println(addressA);
    }

    @Test
    void buildAddressFail() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        customer = CustomerFactory.buildCustomer(213654897, "Jake", "Long"
                , "jakeLong", LocalDate.of(2000, Month.JANUARY, 1), contact);
        addressB = AddressFactory.buildAddress(1, "10", "Church street"
                , "Strandfontein", "7798", "Cape Town", customerNull);
        assertNotNull(addressB);
        System.out.println(addressB);
    }

}