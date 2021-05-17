package com.anthony.smarthome.Security.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Autowired;

public class jwt implements myJWT {
    private String secret = "motconmeo";

    @Override
    public String GenerateToken(String username) {
        String token = "";

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            token = JWT.create()
                .withIssuer("auth0")
                .withSubject(username)
                .sign(algorithm);
        } catch (Exception e) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }

        return token;
    }

    @Override
    public boolean VerifyToken(String token) {
        boolean kk = false;

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();

            DecodedJWT decodedJWT = verifier.verify(token);

            kk = true;
        } catch (Exception e) {
            //TODO: handle exception
        }

        return kk;
    }
}
