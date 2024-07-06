package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private long addressId;
    private String streetNumber;
    private String streetName;
    private String suburb;
    private String postalCode;
    private String city;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
