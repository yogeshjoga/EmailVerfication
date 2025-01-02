package org.api.emailverfication.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.emailverfication.dtos.UserResponceDTO;
import org.api.emailverfication.services.user.IUserService;
import org.api.emailverfication.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private UserUtils userUtils;


    /**
     * Get all user's from who did emil verification
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<UserResponceDTO>> getAllUsers(){
        List<UserResponceDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("{email}")
    public ResponseEntity<UserResponceDTO> getUserByEmail(@PathVariable("email") String email){
        UserResponceDTO dto = userUtils.getUserResponceDTO(userService.getUserByEmail(email));
        return ResponseEntity.status(200).body(dto);
    }

}
