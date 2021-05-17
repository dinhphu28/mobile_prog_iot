package com.anthony.smarthome.Security.JWT;

public interface myJWT {
    String GenerateToken(String username);

    boolean VerifyToken(String token);
}
