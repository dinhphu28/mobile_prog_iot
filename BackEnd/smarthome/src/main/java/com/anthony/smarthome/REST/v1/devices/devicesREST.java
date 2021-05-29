package com.anthony.smarthome.REST.v1.devices;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.anthony.smarthome.Entities.devicelogs;
import com.anthony.smarthome.Entities.devices;
import com.anthony.smarthome.Models.devices.AdapterDevices;
import com.anthony.smarthome.Models.devices.devicesModel;
import com.anthony.smarthome.Models.devices.devicesNewModel;
import com.anthony.smarthome.Security.JWT.jwt;
import com.anthony.smarthome.Services.devicelogsService;
import com.anthony.smarthome.Services.devicesService;

import org.springframework.beans.factory.annotation.Autowired;


@Path("/v1/devices")
public class devicesREST {
    @Autowired
    private devicesService service;

    @Autowired
    devicelogsService tmpservice;

    /**
     *
     * @param authorization
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllDevices(@HeaderParam("Authorization") String authorization) {
        jwt meojwt = new jwt();

        String token = authorization.substring(7); //Bearer <token>

        boolean zz = false;

        zz = meojwt.VerifyToken(token);

        if(zz) {
            List<devicesModel> listDevices = new ArrayList<devicesModel>();

            List<devices> listdeviceEnt = new ArrayList<devices>();

            listdeviceEnt = service.getall();

            for(devices ii : listdeviceEnt) {
                listDevices.add(new devicesModel(ii));
            }

            return Response.status(Status.OK).entity(listDevices).build();
        } else {
            return Response.status(Status.UNAUTHORIZED).entity("\"Invalid token!\"").build();
        }
    }

    /**
     *
     * @param id
     * @param authorization
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetOneDevice(@PathParam("id") Integer id, @HeaderParam("Authorization") String authorization) {
        jwt meojwt = new jwt();

        String token = authorization.substring(7); //Bearer <token>

        boolean zz = false;

        zz = meojwt.VerifyToken(token);

        if(zz) {
            devicesModel dvcM = null;

            boolean kk = false;
            try {
                devices dvcEnt = service.getone(id);

                dvcM = new devicesModel(dvcEnt);

                if(dvcM != null) {
                    kk = true;
                }
            } catch (Exception e) {
                //TODO: handle exception
            }

            if(kk) {
                return Response.ok(dvcM).build();
            } else {
                return Response.status(Status.NOT_FOUND).entity("{\"Message\": \"Not found this device!\"}").build();
            }
        } else {
            return Response.status(Status.UNAUTHORIZED).entity("\"Invalid token!\"").build();
        }
    }

    /**
     *
     * @param authorization
     * @param device
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response CreateNewDevice(@HeaderParam("Authorization") String authorization, devicesNewModel device) {
        jwt meojwt = new jwt();

        String token = authorization.substring(7); //Bearer <token>

        boolean zz = false;

        zz = meojwt.VerifyToken(token);

        if(zz) {
            if(device.getDeviceName() == null || device.getDeviceDescription() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Invalid input!").build();
            }

            devices tmpDevicesEnt = null;

            boolean kk = false;

            try {
                tmpDevicesEnt = new AdapterDevices().convertFromNewModelToDeviceEntity(device);

                service.create(tmpDevicesEnt);

                kk = true;
            } catch (Exception e) {
                //TODO: handle exception
            }

            if(kk) {
                return Response.status(Status.CREATED).entity("Created new device!").build();
            } else {
                return Response.status(Status.BAD_REQUEST).entity("Invalid info!").build();
            }
        } else {
            return Response.status(Status.UNAUTHORIZED).entity("\"Invalid token!\"").build();
        }
    }

    /**
     *
     * @param authorization
     * @param id
     * @param device
     * @return
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response UpdateDevice(@HeaderParam("Authorization") String authorization, @PathParam("id") Integer id, devicesNewModel device) {
        jwt meojwt = new jwt();

        String token = authorization.substring(7); //Bearer <token>

        boolean zz = false;

        zz = meojwt.VerifyToken(token);

        if(zz) {
            if(device.getDeviceName() == null || device.getDeviceDescription() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Invalid input!").build();
            }

            devices tmpDevicesEnt = null;

            devicelogs tmplog = new devicelogs();

            boolean kk = false;

            try {
                tmpDevicesEnt = service.getone(id);

                if(tmpDevicesEnt != null) {
                    tmpDevicesEnt = new AdapterDevices().convertFromNewModelToDeviceEntity(device);
                    tmpDevicesEnt.setId(id);

                    kk = service.save(tmpDevicesEnt);

                    LocalDate dtr = LocalDate.now();
                    LocalTime tmr = LocalTime.now();

                    tmplog.setId(null);
                    tmplog.setDeviceId(id);
                    tmplog.setBitValue(device.isBitValue());
                    tmplog.setDecimalValue(device.getDecimalValue());
                    tmplog.setDateRecord(dtr);
                    tmplog.setTimeRecord(tmr);

                    kk = tmpservice.create(tmplog);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }

            if(kk) {
                return Response.status(Status.OK).entity("Updated devices!").build();
            } else {
                return Response.status(Status.BAD_REQUEST).entity("Invalid Info!").build();
            }
        } else {
            return Response.status(Status.UNAUTHORIZED).entity("\"Invalid token!\"").build();
        }
    }

    /**
     *
     * @param authorization
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteDevice(@HeaderParam("Authorization") String authorization, @PathParam("id") Integer id) {
        jwt meojwt = new jwt();

        String token = authorization.substring(7); //Bearer <token>

        boolean zz = false;

        zz = meojwt.VerifyToken(token);

        if(zz) {
            boolean kk = false;

            try {
                devices dvc = null;

                dvc = service.getone(id);

                if(dvc != null) {
                    kk = service.delete(id);

                    kk = true;
                }
            } catch (Exception e) {
                //TODO: handle exception
            }

            if(kk) {
                return Response.status(Status.OK).entity("Deleted device!").build();
            } else {
                return Response.status(Status.BAD_REQUEST).entity("Device not found!").build();
            }
        } else {
            return Response.status(Status.UNAUTHORIZED).entity("\"Invalid token!\"").build();
        }
    }
}
