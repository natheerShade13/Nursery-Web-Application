package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class SupplierProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierProductId;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID", nullable = false)
    private Supplier supplier;
    private String productName;
    private double price;
    private String imageUrl;
    private String productDescription;
    private int quantity;
    private LocalDate supplyDate; // Optional: to track when the product was supplied

    protected SupplierProduct() {
    }

    private SupplierProduct(Builder builder) {
        this.supplierProductId = builder.supplierProductId;
        this.supplier = builder.supplier;
        this.quantity = builder.quantity;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.price = builder.price;
        this.supplyDate = builder.supplyDate;
    }

    public long getSupplierProductId() {
        return supplierProductId;
    }

    public Supplier getSupplier() {
        return supplier;
    }


    public int getQuantity() {
        return quantity;
    }

    public double getSupplyPrice() {
        return price;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }


    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierProduct that = (SupplierProduct) o;
        return supplierProductId == that.supplierProductId && Double.compare(price, that.price) == 0 && quantity == that.quantity && Objects.equals(supplier, that.supplier) && Objects.equals(productName, that.productName) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(productDescription, that.productDescription) && Objects.equals(supplyDate, that.supplyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierProductId, supplier, productName, price, imageUrl, productDescription, quantity, supplyDate);
    }

    @Override
    public String toString() {
        return "SupplierProduct{" +
                "supplierProductId=" + supplierProductId +
                ", supplier=" + supplier +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantity=" + quantity +
                ", supplyDate=" + supplyDate +
                '}';
    }

    public static class Builder {
        private long supplierProductId;
        @ManyToOne
        @JoinColumn(name = "SUPPLIER_ID", nullable = false)
        private Supplier supplier;
        private String productName;
        private double price;
        private String imageUrl;
        private String productDescription;
        private int quantity;
        private LocalDate supplyDate; // Optional: to track when the product was supplied

        public Builder setSupplierProductId(long supplierProductId) {
            this.supplierProductId = supplierProductId;
            return this;
        }

        public Builder setSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }


        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setSupplyPrice(double supplyPrice) {
            this.price = supplyPrice;
            return this;
        }

        public Builder setSupplyDate(LocalDate supplyDate) {
            this.supplyDate = supplyDate;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder copy(SupplierProduct supplierProduct) {
            this.supplierProductId = supplierProduct.supplierProductId;
            this.supplier = supplierProduct.supplier;
            this.quantity = supplierProduct.quantity;
            this.price = supplierProduct.price;
         this.productName = supplierProduct.productName;
         this.productDescription = supplierProduct.productDescription;
            this.supplyDate = supplierProduct.supplyDate;
            return this;
        }

        public SupplierProduct build() {
            return new SupplierProduct(this);
        }
    }

}
