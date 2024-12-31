package org.api.emailverfication.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.api.emailverfication.constents.STATE;
import org.api.emailverfication.constents.VERIFIED;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponceDTO {
    private UUID id;
    private String email;
    private String phone;
    // private String userName;
    private String firstName;
    private String lastName;
    private STATE state;
    private VERIFIED isVerified;
}
