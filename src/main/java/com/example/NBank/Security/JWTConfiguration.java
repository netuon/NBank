package com.example.NBank.Security;

import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class JWTConfiguration {

    @Bean
    RSAPrivateKey privateKey(@Value("${jwt.private-key}") Resource resource) throws Exception {
        String pem = resource.getContentAsString(StandardCharsets.UTF_8);
        byte[] der = decodePem(pem);
        return (RSAPrivateKey) KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(der));
    }

    @Bean
    RSAPublicKey publicKey(@Value("${jwt.public-key}") Resource resource) throws Exception {
        String pem = resource.getContentAsString(StandardCharsets.UTF_8);
        byte[] der = decodePem(pem);
        return (RSAPublicKey) KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(der));
    }

    private byte[] decodePem(String pem) {
        if(pem.contains("-----BEGIN PRIVATE KEY----")){
            pem = pem.replace("-----BEGIN PRIVATE KEY-----", "");
            pem = pem.replace("-----END PRIVATE KEY-----","");
        } else {

            pem = pem.replace("-----BEGIN PUBLIC KEY-----", "");
            pem = pem.replace("-----END PUBLIC KEY-----","");
        }
        pem = pem.replaceAll("\\s", "");
        return Base64.getDecoder().decode(pem);
    }
}
