package za.ac.cput.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer {

    @Id
    private long customerId;
    private String firstName;
    private String lastName;
    private String password;
    @Embedded
    private Contact contact;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

}
