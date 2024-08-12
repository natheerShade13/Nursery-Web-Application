package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
//    @OneToMany(mappedBy = "supplier") // cascade = CascadeType.ALL
//    private List<SupplierProduct> supplierProducts;

    protected Supplier() {}

    private Supplier(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getSupplierID() {
        return id;
    }

    public void setSupplierID(Long supplierID) {
        this.id = supplierID;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
//                ", supplierProducts=" + supplierProducts +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) && Objects.equals(firstName, supplier.firstName) && Objects.equals(lastName, supplier.lastName) && Objects.equals(email, supplier.email) && Objects.equals(phoneNumber, supplier.phoneNumber) && Objects.equals(password, supplier.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, password);
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
      private String password;



        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Supplier supplier) {
            this.firstName = supplier.firstName;
            this.lastName = supplier.lastName;
            this.email = supplier.email;
            this.phoneNumber = supplier.phoneNumber;
            this.password = supplier.password;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }

}
