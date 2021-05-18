package com.anthony.smarthome.Jersey;

import javax.ws.rs.ApplicationPath;

import com.anthony.smarthome.REST.v1.auth.authREST;
import com.anthony.smarthome.REST.v1.devices.devicesREST;
import com.anthony.smarthome.REST.v1.devices.logs.devicelogsREST;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        /**
         * register Filter class
         */
        register(ServerResponseFilter.class);

        /**
         * register REST class
         */
        register(authREST.class);
        register(devicesREST.class);
        register(devicelogsREST.class);
    }
}
