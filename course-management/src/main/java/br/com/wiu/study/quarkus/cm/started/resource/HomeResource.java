package br.com.wiu.study.quarkus.cm.started.resource;

import br.com.wiu.study.quarkus.cm.started.service.HomeService;
import br.com.wiu.study.quarkus.cm.started.vo.VersionVO;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/version")
public class HomeResource {

    @Inject
    private HomeService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<VersionVO> getVersion() {
        return service.getVersion();
    }
}