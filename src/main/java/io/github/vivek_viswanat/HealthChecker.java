package io.github.vivek_viswanat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("q/healthcheck")
public class HealthChecker {

    @GET
    @Path("live")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> liveStat() {
        return Map.of("live", true);
    }

    @GET
    @Path("ready")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> readinessStat() {
        return Map.of("ready", true);
    }
}
