package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiUtils {

    private static final String BASE_URI = "https://api.tmsandbox.co.nz/v1";

    // Request Specification
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addQueryParam("catalogue", "false")
                .build();
    }

    // Response Specification for success (200)
    public static ResponseSpecification getResponseSpecSuccess() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    // Response Specification for error (404)
    public static ResponseSpecification getResponseSpecNotFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .build();
    }

    // Response Specification for bad request (400)
    public static ResponseSpecification getResponseSpecBadRequest() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectContentType(ContentType.JSON)
                .build();
    }

    // Send GET request with RequestSpecification
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.given()
                .spec(getRequestSpec())
                .when()
                .get(endpoint);
    }

    // Validate response against ResponseSpecification
    public static void validateResponse(Response response, ResponseSpecification responseSpec) {
        response.then().spec(responseSpec);
    }
}