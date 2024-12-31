package org.api.emailverfication.repo;

import org.api.emailverfication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    // ADD custom Query's
    // Custom Query methods

    @Query("SELECT u from users u where u.email = :email")
    User findByUser(String email);

    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByEmail(String email);

    @Query("SELECT u.password from users u where u.id = :id")
    String findByIdByPassword(UUID id);

}
