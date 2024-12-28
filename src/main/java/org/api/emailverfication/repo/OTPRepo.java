package org.api.emailverfication.repo;

import org.api.emailverfication.models.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OTPRepo extends JpaRepository<OTP, UUID> {
    List<OTP> getOTPByEmail(String email);

    void deleteOTPByEmail(String email);
    // Write Custom Query's
    // Custom Query Methods

}
