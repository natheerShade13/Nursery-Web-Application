package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CartProductFactoryTest {

    private Contact contact;
    private Customer customer;
    private Cart cart;
    private Product product;
    private CartProduct cartProductA;
    private CartProduct cartProductB;

    @Test
    void buildCartProduct() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jakeLong", LocalDate.of(2000, Month.JANUARY, 1), contact);
        cart = CartFactory.buildCart(1, customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        cartProductA = CartProductFactory.buildCartProduct(1, cart, product, 3, 50);
        assertNotNull(cartProductA);
        System.out.println(cartProductA);
    }

    @Test
    void buildCartProductFail() {
        contact = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jakeLong", LocalDate.of(2000, Month.JANUARY, 1), contact);
        cart = CartFactory.buildCart(1, customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        cartProductB = CartProductFactory.buildCartProduct(1, cart, product, -1, 50);
        assertNotNull(cartProductB);
        System.out.println(cartProductB);
    }

}