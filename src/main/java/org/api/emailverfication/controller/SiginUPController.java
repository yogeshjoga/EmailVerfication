package org.api.emailverfication.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.api.emailverfication.constents.LOGIN;
import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.dtos.UserResponceDTO;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.OTPRepo;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.verificationservice.IVerificationService;
import org.api.emailverfication.services.user.UserService;
import org.api.emailverfication.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class SiginUPController {

    @Autowired
    private IVerificationService verificationService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OTPRepo otpRepo;

    @Autowired
    UserUtils userUtils;

    private static final Logger log = LoggerFactory.getLogger(SiginUPController.class);

    private MultiValueMap<String, String> headers;

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<UserResponceDTO> signup(@RequestBody UserRequestDTO dto, HttpServletResponse response) {
        // cookies
        Cookie cookie = new Cookie("email", dto.getEmail());
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Post mapping", "true");
        if(userService.signUp(dto)){
            return  ResponseEntity.status(200).body(userUtils.getUserResponceDTO(userUtils.getUser(dto)));
        }
        return null;
    }



    @PostMapping("/login")
    public ResponseEntity<LOGIN> login(@RequestParam(required = false) String userName,
                                       @RequestParam(required = false) String email,
                                       @RequestParam String password){

        if((userName == null || email == null ) && password == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user;
        if(userName != null) {
            user = userService.getUserByFirstName(userName);
            Boolean isValid = userService.validatePassword(user.getId(),password);
            if(isValid){
                return ResponseEntity.status(200).body(LOGIN.SUCCESS);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(email != null){
            user = userService.getUserByEmail(email);
            Boolean isValid = userService.validatePassword(user.getId(),password);
            if(isValid){
                return ResponseEntity.status(200).body(LOGIN.SUCCESS);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return null;
    }

}
