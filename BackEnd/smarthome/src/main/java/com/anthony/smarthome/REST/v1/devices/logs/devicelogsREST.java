package com.anthony.smarthome.REST.v1.devices.logs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.anthony.smarthome.Entities.devicelogs;
import com.anthony.smarthome.Models.devices.logs.devicelogsNewModel;
import com.anthony.smarthome.Security.JWT.jwt;
import com.anthony.smarthome.Services.devicelogsService;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/v1/devices/logs")
public class devicelogsREST {
    @Autowired
    private devicelogsService service;

    @GET
    @Path("/{id}")  // Device ID
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetDeviceLogs(@HeaderParam("Authorization") String authorization, @PathParam("id") Integer id) {
        jwt meojwt = new jwt();

        String token = authorization.substring(7); //Bearer <token>

        boolean zz = false;

        zz = meojwt.VerifyToken(token);

        if(zz) {
            List<devicelogs> listdvclg = null;

            boolean kk = false;

            try {
                listdvclg = service.gettop10ofonedevice(id);

                if(listdvclg != null) {
                    kk = true;
                } else {
                    listdvclg = new ArrayList<devicelogs>();
                }
            } catch (Exception e) {
                //TODO: handle exception
                listdvclg = new ArrayList<devicelogs>();
            }

            if(kk) {
                return Response.status(Status.OK).entity(listdvclg).build();
            } else {
                return Response.status(Status.NOT_FOUND).entity("Device logs not found!").build();
            }
        } else {
            return Response.status(Status.UNAUTHORIZED).entity("\"Invalid token!\"").build();
        }
    }
}
