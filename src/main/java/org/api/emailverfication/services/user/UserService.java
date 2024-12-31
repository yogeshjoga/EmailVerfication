package org.api.emailverfication.services.user;


import org.api.emailverfication.constents.STATE;
import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.EmailService;
import org.api.emailverfication.services.IVerificationService;
import org.api.emailverfication.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(UserService.class);



    // Implement the methods Here...........

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

    @Override
    public User getUserByFirstName(String firstName){
        return userRepo.findByFirstName(firstName);
    }


    @Override
    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }



    @Override
    public Boolean validatePassword(UUID id, String password){
        String pass = userRepo.findByIdByPassword(id);
        if(pass == null){
            return false;
        }
        if(!pass.equals(password)){
            return false;
        }
        return true;
    }


}
