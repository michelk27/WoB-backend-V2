package dev.wellorganize.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository interface to interact with MongoDB

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest signInRequest) {
        String username = signInRequest.getUsername();
        String password = signInRequest.getPassword();

        // Retrieve the user document based on the provided username from MongoDB
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok("Sign-in successful!");
        }

        // Return an error response for failed sign-in
        return ResponseEntity.status(401).body("Wrong username or password");
    }
}
