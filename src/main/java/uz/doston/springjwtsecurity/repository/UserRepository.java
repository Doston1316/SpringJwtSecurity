package uz.doston.springjwtsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.doston.springjwtsecurity.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);

    boolean existsByUserName(String username);

}
