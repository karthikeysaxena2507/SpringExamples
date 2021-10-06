package SpringBootAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBootAuth.entity.User;
import SpringBootAuth.repository.UserRepository;

/**
 * Service class for user auth endpoints, containing the business logic
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Function to SignIn a user based on credentials
     * @param user the user object sent in request body
     * @return the response of SignIn
     */
    public String login(User user) {
        return "";
    }

    /**
     * Function to register a new user
     * @param user the user object sent in request body
     * @return the response of registering the user
     */
    public String register(User user) {
        return "";
    }

    /**
     * A dummy function to check authentication status of a user
     * @return if user is authenticated or not
     */
    public String checkAuth() {
        return "Checked";
    }

}
