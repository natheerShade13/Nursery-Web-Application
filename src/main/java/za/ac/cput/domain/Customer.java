package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate dateOfBirth;
    @Embedded
    private Contact contact;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    protected Customer(){}

    private Customer(Builder builder){
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.dateOfBirth = builder.dateOfBirth;
        this.contact = builder.contact;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(password, customer.password) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(contact, customer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, password, dateOfBirth, contact);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", date=" + dateOfBirth +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private long customerId;
        private String firstName;
        private String lastName;
        private String password;
        private LocalDate dateOfBirth;
        private Contact contact;

        public Builder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerId = customer.customerId;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.password = customer.password;
            this.dateOfBirth = customer.dateOfBirth;
            this.contact = customer.contact;
            return this;
        }

        public Customer build(){return new Customer(this);}

    }

}
