package br.com.wiu.study.quarkus.sample;

import br.com.wiu.study.quarkus.sample.service.SampleService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
public class SampleResource {

    @Inject
    SampleService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String hello(@PathParam String name) {
        return service.getHello(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/jax-rs/{name}")
    public String helloJAXRS(@javax.ws.rs.PathParam("name") String name) {
        return String.format("JAX-RS %s", service.getHello(name));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy!!!";
    }
}