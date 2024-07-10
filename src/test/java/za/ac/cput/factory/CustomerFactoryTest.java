package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private Contact contact;
    private Customer customerA;
    private Customer customerB;

    @Test
    void buildCustomer() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        customerA = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jakeLong",LocalDate.of(2000, Month.JANUARY, 1), contact);
        assertNotNull(customerA);
        System.out.println(customerA);
    }

    @Test
    void buildCustomerFail() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        customerB = CustomerFactory.buildCustomer(1, "", "Long"
                , "jakeLong",LocalDate.of(2000, Month.JANUARY, 1), contact);
        assertNotNull(customerB);
        System.out.println(customerB);
    }

}