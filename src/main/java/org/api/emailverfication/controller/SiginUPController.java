package org.api.emailverfication.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.dtos.UserResponceDTO;
import org.api.emailverfication.repo.OTPRepo;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.IVerificationService;
import org.api.emailverfication.services.user.UserService;
import org.api.emailverfication.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/signup/")
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

}
