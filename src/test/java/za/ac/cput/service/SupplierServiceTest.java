package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    private static Supplier supplier;

    @Test
    @Order(0)
    void setUp() {

        supplier = SupplierFactory.buildSupplier("Manny", "Jacks", "Toys"
                , "JacksToys@gmail.com", "0677784626");
        assertNotNull(supplier);
        System.out.println(supplier);
    }


    @Test
    @Order(1)
    void create() {
        Supplier createSupplier = supplierService.create(supplier);
        assertNotNull(createSupplier);
        System.out.println(createSupplier);
    }
}



