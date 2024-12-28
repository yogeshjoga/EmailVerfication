package org.api.emailverfication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity(name = "otps")
public class OTP extends BaseModel{
    private String otp;
}
