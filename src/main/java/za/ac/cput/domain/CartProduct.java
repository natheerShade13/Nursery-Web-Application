package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    protected CartProduct(){}

}
