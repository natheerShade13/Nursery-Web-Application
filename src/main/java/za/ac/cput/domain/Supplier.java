package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierID;
    private String firstName;
    private String lastName;
    @Embedded
    private Contact contact;
    @OneToMany(mappedBy = "supplier") // cascade = CascadeType.ALL
    private List<SupplierProduct> supplierProducts;

    protected Supplier() {}

    private Supplier(Builder builder) {
        this.supplierID = builder.supplierID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public long getSupplierID() {
        return supplierID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierID, supplier.supplierID) && Objects.equals(firstName, supplier.firstName) && Objects.equals(lastName, supplier.lastName) && Objects.equals(contact, supplier.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierID, firstName, lastName, contact);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private long supplierID;
        private String firstName;
        private String lastName;
        private Contact contact;

        public Builder setSupplierID(long supplierID) {
            this.supplierID = supplierID;
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

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Supplier supplier) {
            this.supplierID = supplier.supplierID;
            this.firstName = supplier.firstName;
            this.lastName = supplier.lastName;
            this.contact = supplier.contact;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }

}
