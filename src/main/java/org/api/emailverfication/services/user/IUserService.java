package org.api.emailverfication.services.user;

import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.models.User;

import java.util.UUID;

public interface IUserService {

     Boolean signUp(UserRequestDTO dto);

     User getUserByFirstName(String firstName);

    User getUserByEmail(String email);

    Boolean validatePassword(UUID id,String password);
}
