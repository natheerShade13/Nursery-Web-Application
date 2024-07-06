package za.ac.cput.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Contact {

    private String email;
    private String mobileNumber;

}
