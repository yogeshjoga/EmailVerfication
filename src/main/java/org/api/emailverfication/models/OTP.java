package org.api.emailverfication.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity(name = "otps")
public class OTP extends BaseModel{
    private String otp;
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
