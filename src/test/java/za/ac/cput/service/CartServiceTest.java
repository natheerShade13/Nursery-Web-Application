package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;

    private static Customer customer;
    private static Cart cart;

    @Test
    @Order(0)
    void setup(){
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(1, customer);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
        Cart createCart = cartService.create(cart);
        assertNotNull(createCart);
        System.out.println(createCart);
    }

    @Test
    @Order(2)
    void read() {
        Cart findCart = cartService.read(cart.getCartId());
        assertNotNull(findCart);
        System.out.println(findCart);
    }

    @Test
    @Order(3)
    @Disabled //This method is pointless
    void update() {
        Cart newCart = new Cart.Builder().copy(cart).setCustomer(customer).build();
        assertNotNull(newCart);
        Cart updatedCart = cartService.update(newCart);
        assertNotNull(updatedCart);
        System.out.println(updatedCart);
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteCart = cartService.delete(cart.getCartId());
        assertTrue(deleteCart);
        System.out.println(deleteCart);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(cartService.getAll());
    }
}