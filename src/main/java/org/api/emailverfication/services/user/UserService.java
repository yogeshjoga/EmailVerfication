package org.api.emailverfication.services.user;


import org.api.emailverfication.constents.STATE;
import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.EmailService;
import org.api.emailverfication.services.IVerificationService;
import org.api.emailverfication.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private IVerificationService verificationService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserUtils userUtils;


    @Override
    public Boolean signUp(UserRequestDTO dto) {
        User user = userUtils.getUser(dto);
        if(verificationService.sendVerificationEmail(user.getEmail())){
            // saving user as temporary inactive
            // once otp was verified user valid and state as Active
            user.setState(STATE.INACTIVE);
            user.setId(UUID.randomUUID());
            userRepo.save(user);
            return true;
        }
        return false;
    }




}
