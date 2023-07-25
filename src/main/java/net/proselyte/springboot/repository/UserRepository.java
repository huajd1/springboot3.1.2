package net.proselyte.springboot.repository;

import net.proselyte.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySurname(String surname);
}
