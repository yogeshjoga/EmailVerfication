package org.api.emailverfication.repo;

import jakarta.transaction.Transactional;
import org.api.emailverfication.models.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OTPRepo extends JpaRepository<OTP, UUID> {


    @Query("SELECT O.otp FROM otps O where O.email = :email")
    String getOTPByEmail(@Param("email") String email);


    @Modifying
    @Transactional
    @Query("DELETE FROM otps where email = :email")
    void deleteOTPByEmail(@Param("email") String email);

}
