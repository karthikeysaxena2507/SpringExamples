package SpringBootAuth.security;

import SpringBootAuth.entity.User;
import SpringBootAuth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        log.info("Inside MyUserDetailsService");
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername");
        User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException(
                            "User Not Found with email: " + email
                    ));
        return MyUserDetails.build(user.getEmail(), user.getPassword());
    }

}
