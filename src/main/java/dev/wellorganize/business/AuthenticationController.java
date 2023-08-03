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
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        String username = signInRequest.getUsername();
        String password = signInRequest.getPassword();

        // Retrieve the user document based on the provided username from MongoDB
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Return a JSON response with "authenticated" set to true for successful sign-in
            return ResponseEntity.ok(new SignInResponse(true, "Sign-in successful!"));
        }

        // Return a JSON response with "authenticated" set to false for failed sign-in
        return ResponseEntity.status(401).body(new SignInResponse(false, "Wrong username or password"));
    }
}
