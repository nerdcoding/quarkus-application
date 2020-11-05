package org.nerdcoding.sample.quarkus;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when()
                .get("/quarkus-application/v1/hello/message")
                .then()
                .statusCode(200);
    }

}