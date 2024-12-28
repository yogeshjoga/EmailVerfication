package org.api.emailverfication.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.emailverfication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    // Loggers
    private static final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    UserRepo userRepo;




}
