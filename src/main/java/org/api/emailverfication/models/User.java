package org.api.emailverfication.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.api.emailverfication.constents.STATE;
import org.api.emailverfication.constents.VERIFIED;

@Setter
@Getter
@Entity(name = "users")
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private STATE state;
    @Enumerated(EnumType.STRING)
    private VERIFIED isVerified;
}
