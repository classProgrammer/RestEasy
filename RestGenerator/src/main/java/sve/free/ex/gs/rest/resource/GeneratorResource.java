package sve.free.ex.gs.rest.resource;


import sve.free.ex.gs.genconfig.GenerationConfig;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/dev/generator")
public class GeneratorResource {
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getMessage() {
        // Return some cliched textual content
        return "Generator is reachable";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response fetchConfig(GenerationConfig config) {

        return Response.created(URI.create("/dev/generator/" + config.getPath())).build();
    }
}
