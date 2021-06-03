package br.com.wiu.study.quarkus.cm.started.resource;

import br.com.wiu.study.quarkus.cm.started.vo.ClassVO;
import io.smallrye.mutiny.Uni;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/class")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClassResource {

    @POST
    public Uni<Response> saveClass(@Valid ClassVO classVO) throws URISyntaxException {
        return Uni.createFrom().item(Response.created(new URI("/class")).build());
    }
}
