package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierID;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String password;
    @OneToMany(mappedBy = "supplier") // cascade = CascadeType.ALL
    private List<SupplierProduct> supplierProducts;

    protected Supplier() {}

    private Supplier(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.password = builder.password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPassword() {return password;}

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", password='" + password + '\'' +
                ", supplierProducts=" + supplierProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return supplierID == supplier.supplierID && Objects.equals(firstName, supplier.firstName) && Objects.equals(lastName, supplier.lastName) && Objects.equals(email, supplier.email) && Objects.equals(contactNumber, supplier.contactNumber) && Objects.equals(password, supplier.password) && Objects.equals(supplierProducts, supplier.supplierProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierID, firstName, lastName, email, contactNumber, password, supplierProducts);
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String contactNumber;
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

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
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
            this.contactNumber = supplier.contactNumber;
            this.password = supplier.password;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }

}
