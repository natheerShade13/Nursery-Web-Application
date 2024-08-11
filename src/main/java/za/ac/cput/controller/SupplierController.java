package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Supplier;
import za.ac.cput.dto.AuthenticateUser;
import za.ac.cput.factory.SupplierFactory;
import za.ac.cput.service.SupplierService;

import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService _supplierService;
    @Autowired
    public SupplierController(SupplierService supplierService) {
        this._supplierService = supplierService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody Supplier request) {
        // Use the factory method to create a User object
        Supplier supplier = SupplierFactory.buildSupplier(
                request.getFirstName(),
                request.getLastName(),
                request.getPassword(),
                request.getEmail(),
                request.getContactNumber()
        );

        if (supplier != null) {
            _supplierService.create(supplier);

        } else {
            // Handle invalid user creation
            throw new IllegalArgumentException("Invalid Supplier details provided.");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticateUser authenticateUser){
        Optional<Supplier> validateSupplier = _supplierService.validateSupplier(authenticateUser.getEmail(),authenticateUser.getPassword());
        System.out.println(_supplierService.validateSupplier(authenticateUser.getEmail(), authenticateUser.getPassword())+"here bro");
        if(validateSupplier.isPresent()) {
            return ResponseEntity.ok("Login Successful");
        }else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

    }
}
