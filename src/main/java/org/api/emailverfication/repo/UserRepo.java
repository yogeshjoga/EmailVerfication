package org.api.emailverfication.repo;

import org.api.emailverfication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    // ADD custom Query's
    // Custom Query methods
}
