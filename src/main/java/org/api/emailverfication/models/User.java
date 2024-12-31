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
    private String password;
    @Enumerated(EnumType.STRING)
    private STATE state;
    @Enumerated(EnumType.STRING)
    private VERIFIED isVerified;
}

// lgbzikyrwzwhlumz   -- no spaces SMTP



/**
 *
 * All these are the user columns
 * ------------------------------
 *  UUID id
 *  String email
 *  String phone
 *  String password
 *  String firstName ---> newly added
 *  String lastName
 *  STATE state
 *  VERIFIED isVerified
 *
 */

