package br.com.wiu.study.quarkus.cm.started.resource;

import br.com.wiu.study.quarkus.cm.started.vo.VersionVO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HomeResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/version")
          .then()
             .statusCode(200)
             .body(is("{\"versionId\":1}"));
    }

}