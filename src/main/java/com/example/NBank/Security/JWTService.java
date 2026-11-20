package com.example.NBank.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.NBank.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.interfaces.RSAPrivateKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class JWTService {

    @Autowired
    private RSAPrivateKey privateKey;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.RSA256(privateKey);
             return JWT.create()
                    .withIssuer("NBank")
                    .withSubject(user.getCpf())
                    .withExpiresAt(genExpiration())
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            throw new RuntimeException("Error ao gerar o token", exception);
        }
    }

    private Instant genExpiration(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}

