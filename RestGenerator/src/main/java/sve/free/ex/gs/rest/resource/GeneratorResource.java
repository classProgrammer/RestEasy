package sve.free.ex.gs.rest.resource;
import sve.free.ex.gs.genconfig.GenerationConfig;
import sve.free.ex.gs.generator.writer.ContentWriter;
import sve.free.ex.gs.generator.writer.DaoGenerator;
import sve.free.ex.gs.generator.writer.DomainGenerator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
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
        DomainGenerator generator = new DomainGenerator();
        generator.generate(config);

        DaoGenerator daogen = new DaoGenerator();

        daogen.generate(config);

        return Response.created(URI.create("/dev/generator/")).build();
    }
}
