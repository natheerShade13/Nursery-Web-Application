package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.CustomerHelper;

import java.time.LocalDate;

//Create factory for auto generated Id;
//Is valid imageURL needs to be checked;
//Consider values that allowed to be null;

public class CustomerFactory {

    public static Customer buildCustomer(long customerId, String firstName, String lastName, String password,
                                         LocalDate dateOfBirth, Contact contact){

        if(CustomerHelper.validId(customerId) || CustomerHelper.isNullOrEmpty(firstName) ||
                CustomerHelper.isNullOrEmpty(lastName) || CustomerHelper.isNullOrEmpty(password) ||
                CustomerHelper.isNull(dateOfBirth) || contact == null){
            return null;
        }

        return new Customer.Builder().setCustomerId(customerId).setFirstName(firstName).setLastName(lastName)
                .setPassword(password).setDateOfBirth(dateOfBirth).setContact(contact).build();
    }
}
