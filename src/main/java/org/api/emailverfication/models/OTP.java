package org.api.emailverfication.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity(name = "otps")
public class OTP extends BaseModel{
    private String otp;
    // new column
    private LocalDateTime createdAt;

}

/**
 *
 * All these are the user columns
 * ------------
 * UUID id
 * String email
 * String phone
 *
 */
