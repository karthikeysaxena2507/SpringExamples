package SpringBootAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SpringBootAuth.entity.User;

import java.util.Optional;

/**
 * A repository for the User entity, to handle database operations
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
