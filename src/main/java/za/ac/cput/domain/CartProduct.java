package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CartProduct {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    private int quantity;
    private double unitPrice;

    protected CartProduct(){}

    private CartProduct(Builder builder){
        this.cartProductId = builder.cartProductId;
        this.cart = builder.cart;

        this.quantity = builder.quantity;
        this.unitPrice =builder.unitPrice;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public Cart getCart() {
        return cart;
    }


    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return cartProductId == that.cartProductId && quantity == that.quantity && Double.compare(unitPrice, that.unitPrice) == 0 && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProductId, cart, quantity, unitPrice);
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "cartProductId=" + cartProductId +
                ", cart=" + cart +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public static class Builder{

        private long cartProductId;
        private Cart cart;
        private int quantity;
        private double unitPrice;

        public Builder setCartProductId(long cartProductId) {
            this.cartProductId = cartProductId;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice; // product.getPrice() this sets the unit price to the value of the
                                        // product price, will need to change factory also;
            return this;
        }

        public Builder copy(CartProduct cartProduct){
            this.cartProductId = cartProduct.cartProductId;
            this.cart = cartProduct.cart;

            this.quantity = cartProduct.quantity;
            this.unitPrice =cartProduct.unitPrice;
            return this;
        }

        public CartProduct build(){return new CartProduct(this);}

    }

}
