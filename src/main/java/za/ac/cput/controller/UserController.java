package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.User;
import za.ac.cput.dto.AuthenticateUser;
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
    public void registerUser(@RequestBody User user) {
        userService.create(user);
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
}
