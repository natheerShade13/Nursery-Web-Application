package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {

    private String email;
    private String mobileNumber;

}
