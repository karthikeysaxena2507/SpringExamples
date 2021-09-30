package SpringArango.repository;

import SpringArango.entity.User;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ArangoRepository<User, String> {
}
