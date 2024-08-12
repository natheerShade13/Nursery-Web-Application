package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.dto.SupplierProductRequest;
import za.ac.cput.factory.SupplierProductFactory;
import za.ac.cput.service.SupplierProductService;
import za.ac.cput.service.SupplierService;

import java.util.Optional;

@RestController
public class SupplierProductController {
private SupplierProductService _supplierProductService;
private SupplierService _supplierService;

@Autowired
    public SupplierProductController(SupplierProductService _supplierProductService, SupplierService _supplierService) {
        this._supplierProductService = _supplierProductService;
        this._supplierService = _supplierService;
    }

    // API to add a product after logging in
    @PostMapping("/{email}/{password}/products")
    public ResponseEntity<String> addProduct(@PathVariable String email, @PathVariable String password, @RequestBody SupplierProductRequest productRequest) {
        // Validate the supplier using email and password
        Supplier supplier = _supplierService.validateSupplier(email, password);

        if (supplier != null) {
            // Create the SupplierProduct using the factory method
            SupplierProduct supplierProduct = SupplierProductFactory.buildSupplierProduct(
                    supplier,
                    productRequest.getQuantity(),
                    productRequest.getSupplyPrice(),
                    productRequest.getProductName(),
                    productRequest.getSupplyDate(),
                    productRequest.getProductDescription(),
                    productRequest.getImageUrl()
            );

            if (supplierProduct != null) {
                _supplierProductService.create(supplierProduct); // Save the SupplierProduct
                return ResponseEntity.ok("Product added successfully.");
            } else {
                // Handle invalid product creation
                return ResponseEntity.badRequest().body("Invalid product details provided.");
            }
        } else {
            return ResponseEntity.status(404).body("Supplier not found.");
        }
    }

}



