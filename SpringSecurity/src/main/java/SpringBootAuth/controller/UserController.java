package SpringBootAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import SpringBootAuth.entity.User;
import SpringBootAuth.service.UserService;

import javax.validation.Valid;

/**
 * A Rest Controller for the Users
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid User user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid User user) {
        return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
    }

    /**
      * A dummy endpoint to check authentication status of a user
      */
    @GetMapping("/check")
    public ResponseEntity<String> checkAuth() {
        return new ResponseEntity<>(userService.checkAuth(), HttpStatus.OK);
    }

}
