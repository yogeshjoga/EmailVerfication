package org.api.emailverfication.utils;

import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.dtos.UserResponceDTO;
import org.api.emailverfication.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUtils {

    /**
     *  UserResponceDTO -> User
     *  User -> UserRequestDTO
     */

    /**
     *
     * @param user
     * @return
     */
    public UserResponceDTO getUserResponceDTO(User user) {
        UserResponceDTO dto = new UserResponceDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setState(user.getState());
        dto.setIsVerified(user.getIsVerified());
        return dto;
    }

    /**
     *
     * @param dto
     * @return
     */
    public User getUser(UserRequestDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setState(dto.getState());
        user.setIsVerified(dto.getIsVerified());
        return user;
    }


    /**
     * Get all users for responce type is UserResponceDTO
     * @param users
     * @return
     */
    public List<UserResponceDTO> getAllUserDTOs(List<User> users){
        List<UserResponceDTO> dtos = new ArrayList<UserResponceDTO>();
        for(User user : users){
            dtos.add(getUserResponceDTO(user));
        }
        return dtos;
    }

}
