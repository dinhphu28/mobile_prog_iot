package com.anthony.smarthome.Jersey;

import javax.ws.rs.ApplicationPath;

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
        // register(REST_mods.class);
    }
}
