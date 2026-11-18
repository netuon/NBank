package com.example.NBank.Security;

import com.auth0.jwt.algorithms.Algorithm;
import com.example.NBank.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.xml.crypto.AlgorithmMethod;
import java.security.AlgorithmConstraints;

@Service
public class JWTService {
    /*public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256();
        } catch (){

        }
    }*/
}
