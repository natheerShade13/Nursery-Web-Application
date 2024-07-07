package za.ac.cput.domain;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    private long orderId;
    private double amount;
    private LocalDate orderDate;
    private String status;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "COUPON_ID")
    private Coupon coupon;

    protected Orders(){}

    private Orders(Builder builder){
        this.orderId = builder.orderId;
        this.amount = builder.amount;
        this.orderDate = builder.orderDate;
        this.status = builder.status;
        this.customer = builder.customer;
        this.coupon = builder.coupon;
    }

    public long getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Coupon getCoupon() {
        return coupon;
    }


    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", coupon=" + coupon +
                '}';
    }

    public static class Builder{

        private long orderId;
        private double amount;
        private LocalDate orderDate;
        private String status;
        private Customer customer;
        private Coupon coupon;

        public Builder setOrderId(long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCoupon(Coupon coupon) {
            this.coupon = coupon;
            return this;
        }

        public Builder copy(Orders order){
            this.orderId = order.orderId;
            this.amount = order.amount;
            this.orderDate = order.orderDate;
            this.status = order.status;
            this.customer = order.customer;
            this.coupon = order.coupon;
            return this;
        }

        public Orders build(){return new Orders(this);}

    }

}