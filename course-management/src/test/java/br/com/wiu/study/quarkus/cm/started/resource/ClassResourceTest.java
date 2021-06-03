package br.com.wiu.study.quarkus.cm.started.resource;

import br.com.wiu.study.quarkus.cm.started.template.ClassTemplate;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ClassResourceTest {

    @TestHTTPResource("/class")
    URI classEndpoint;

    @Test
    public void testPostClassEndpointSuccess() {
        given()
                .contentType(ContentType.JSON)
                .body(ClassTemplate.successTemplate())
                .when().post(classEndpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void testPostClassEndpointFailure() {
        given()
                .contentType(ContentType.JSON)
                .body(ClassTemplate.failureTemplate())
                .when().post("/class")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}