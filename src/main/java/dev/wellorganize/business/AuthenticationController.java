package dev.wellorganize.business;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest signInRequest) {
        String username = signInRequest.getUsername();
        String password = signInRequest.getPassword();

        // Logic to verify the username and password against the data from MongoDB
        // You can use the UserRepository to retrieve the user data and check if the
        // provided credentials match the data in the database.

        return ResponseEntity.ok("Sign-in successful!");
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
