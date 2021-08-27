package io.github.vivek_viswanat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("load")
public class Loader {

    @GET
    @Path("cpu/iter/{iter:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> cpuLoad(long iter) {

        long sum = 0;
        long average = 0;
        for (long i = 0; i < iter; i++) {
            sum = sum + i;
            average = sum/(i+1);
        }

        Map<String, Long> result = new HashMap<>();
        result.put("sum", sum);
        result.put("average", average);
        return result;
    }

    @GET
    @Path("mem/iter/{iter:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> memLoad(long iter) {

        Map<String, Long> items = new HashMap<>();
        for (long i = 0; i < iter; i++) {
            items.put(Long.toString(i), i);
        }
        return items;
    }

    @GET
    @Path("mem/iter/{iter:\\d+}/delay/{delay:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> memLoad(long iter, long delay) throws Exception {

        Map<String, Long> items = new HashMap<>();
        for (long i = 0; i < iter; i++) {
            items.put(Long.toString(i), i);
        }

        // Hold the map
        Thread.sleep(delay);

        return items;
    }
}
