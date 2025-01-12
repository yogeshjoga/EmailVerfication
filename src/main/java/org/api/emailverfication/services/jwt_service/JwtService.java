package org.api.emailverfication.services.jwt_service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JwtService implements IJwtService {

    @Autowired
    private UserRepo userRepo;

    // Create SecretKey Key
    // Generate token
    // valid token and expire  token
    // Refresh token
    // Time Bound and checking specific user token validation

    /**
     *
     * Token Validation
     *
     * Arch
     *      userName and Password -> While Login
     *      Server create a new JWT Token and Return to the User Response
     *      User Querying Get_All_Products_From_Catalog -> Query + Token send to Server -> Server validate Token and given Response
     *
     */


    private String secret = "";

    public JwtService() {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("hmac-sha256");
            SecretKey secretKey = keyGenerator.generateKey();
            this.secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }catch(Exception e){
            e.printStackTrace();
        }

    }




    @Override
    public String generateToken(String emailOrUserName) {

        if(emailOrUserName.isEmpty()){
            return null;
        }

        User user = null;
        // Handling the Login, By using UserName or Email Id
        if(emailOrUserName.contains("@")){
             user = userRepo.findByEmail(emailOrUserName);
        }else{
            user = userRepo.findByEmail(emailOrUserName);
        }

        // Generating Token
        Map<String, Object> claims = new HashMap<>();
        // Jwts
        // return
        return Jwts.builder().claims(claims)
                .setSubject(emailOrUserName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()))
                .signWith(getKey())
                .compact();
    }


    @Override
    public SecretKey getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public boolean isTokenValid(String token) {
        // implement it
        return false;
    }

}
