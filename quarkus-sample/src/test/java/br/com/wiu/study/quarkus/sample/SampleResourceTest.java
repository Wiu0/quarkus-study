package br.com.wiu.study.quarkus.sample;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/sample")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy!!!"));
    }

    @Test
    public void testHelloEndpointWithPathParam() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when()
                .get("/sample/{name}")
                .then()
                .statusCode(200)
                .body(is(String.format("Hello %s", uuid)));

    }

    @Test
    public void testHelloEndpointWithPathParamJAXRS() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when()
                .get("/sample/jax-rs/{name}")
                .then()
                .statusCode(200)
                .body(is(String.format("JAX-RS Hello %s", uuid)));

    }

}