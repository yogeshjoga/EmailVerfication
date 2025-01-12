package org.api.emailverfication.services.jwt_service;


import javax.crypto.SecretKey;

public interface IJwtService {

    String generateToken(String emailOrUserName);


    SecretKey getKey();
}
