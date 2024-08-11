package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.dto.AuthenticateUser;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User request) {
        // Use the factory method to create a User object
        User user = UserFactory.buildUser(
                request.getFirstName(),
                request.getLastName(),
                request.getPassword(),
                request.getEmail(),
                request.getPhoneNumber()
        );

        if (user != null) {
            userService.registerUser(user);

        } else {
            // Handle invalid user creation
            throw new IllegalArgumentException("Invalid user details provided.");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticateUser authenticateUser){
        Optional<User>  user = userService.validateUser(authenticateUser.getEmail(),authenticateUser.getPassword());
        System.out.println(userService.validateUser(authenticateUser.getEmail(), authenticateUser.getPassword())+"here bro");
        if(user.isPresent()) {
           return ResponseEntity.ok("Login Successful");
        }else {
           return ResponseEntity.status(401).body("Invalid email or password");
        }

    }
    @DeleteMapping("/deleteByEmail")
    public ResponseEntity<?> deleteUserByEmail(@RequestParam String email) {
        try {
            boolean deleted = userService.deleteUserByEmail(email);
            System.out.println(email);
            if (deleted) {    System.out.println("here");
                return ResponseEntity.ok().body("User deleted successfully.");

            } else {    System.out.println("there");
                return ResponseEntity.status(404).body("User not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }
    }
}
