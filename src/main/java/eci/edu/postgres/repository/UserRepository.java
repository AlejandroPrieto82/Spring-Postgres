package eci.edu.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eci.edu.postgres.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

