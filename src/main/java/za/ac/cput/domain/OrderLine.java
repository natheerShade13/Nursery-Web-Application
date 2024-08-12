package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderLineId;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders orders;
    private int quantity;
    private double quotedPrice;

    protected OrderLine(){}

    private OrderLine(Builder builder){
        this.orderLineId = builder.orderLineId;
        this.orders = builder.orders;

        this.quantity = builder.quantity;
        this.quotedPrice = builder.quotedPrice;
    }

    public long getOrderLineId() {
        return orderLineId;
    }

    public Orders getOrders() {
        return orders;
    }



    public int getQuantity() {
        return quantity;
    }

    public double getQuotedPrice() {
        return quotedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return orderLineId == orderLine.orderLineId && quantity == orderLine.quantity && Double.compare(quotedPrice, orderLine.quotedPrice) == 0 && Objects.equals(orders, orderLine.orders) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, orders, quantity, quotedPrice);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineId=" + orderLineId +
                ", orders=" + orders +

                ", quantity=" + quantity +
                ", quotedPrice=" + quotedPrice +
                '}';
    }

    public static class Builder{

        private long orderLineId;
        private Orders orders;
        private int quantity;
        private double quotedPrice;

        public Builder setOrderLineId(long orderLineId) {
            this.orderLineId = orderLineId;
            return this;
        }

        public Builder setOrders(Orders orders) {
            this.orders = orders;
            return this;
        }



        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setQuotedPrice(double quotedPrice) {
            this.quotedPrice = quotedPrice;
            return this;
        }

        public Builder copy(OrderLine orderLine){
            this.orderLineId = orderLine.orderLineId;
            this.orders = orderLine.orders;
            this.quantity = orderLine.quantity;
            this.quotedPrice = orderLine.quotedPrice;
            return this;
        }

        public OrderLine build(){return new OrderLine(this);}

    }

}
