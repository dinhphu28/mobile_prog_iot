package com.anthony.smarthome.REST.v1.auth;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.anthony.smarthome.Entities.accounts;
import com.anthony.smarthome.Models.auth.changepasswordModel;
import com.anthony.smarthome.Models.auth.signinModel;
import com.anthony.smarthome.Security.JWT.jwt;
import com.anthony.smarthome.Services.accountsService;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/v1/auth")
public class authREST {
    @Autowired
    private accountsService service;

    /**
     * URL: http://localhost:8080/api/v1/auth
     * @param acc
     * @return Bearer token
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response signin(signinModel acc) {
        if(acc.getUsername() == null || acc.getPassword() == null) {
            return Response.status(Status.BAD_REQUEST).entity("Invalid info!").build();
        }

        accounts accountsEnt = null;

        boolean kk = false;

        try {
            accountsEnt = service.getone(acc.getUsername());

            if(accountsEnt.getUsername().equals(acc.getUsername()) && accountsEnt.getPassword().equals(acc.getPassword()) && accountsEnt.isAccountType() == acc.isAccountType()) {
                kk = true;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        jwt meojwt = new jwt();
        String tokenString = meojwt.GenerateToken(acc.getUsername());

        if(kk) {
            return Response.status(Status.OK).entity("Bearer " + tokenString).build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("Invalid Sign In Info!").build();
        }
    }

    /**
     *
     * @param acc
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response changePassword(changepasswordModel acc) {
        if(acc.getUsername() == null || acc.getOldPassword() == null || acc.getNewPassword() == null) {
            return Response.status(Status.BAD_REQUEST).entity("Invalid info!").build();
        }

        accounts accountsEnt = null;

        boolean kk = false;

        try {
            accountsEnt = service.getone(acc.getUsername());

            if(accountsEnt.getUsername().equals(acc.getUsername()) && accountsEnt.getPassword().equals(acc.getOldPassword()) && accountsEnt.isAccountType() == acc.isAccountType()) {
                accountsEnt.setPassword(acc.getNewPassword());

                service.save(accountsEnt);

                kk = true;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        if(kk) {
            return Response.status(Status.OK).entity("Password changed!").build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("Invalid info!").build();
        }
    }
}
