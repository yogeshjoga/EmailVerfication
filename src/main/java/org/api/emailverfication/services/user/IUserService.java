package org.api.emailverfication.services.user;

import org.api.emailverfication.dtos.UserRequestDTO;

public interface IUserService {

     Boolean signUp(UserRequestDTO dto);
}
