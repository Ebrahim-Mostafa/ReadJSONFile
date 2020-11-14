package TestPackage;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

class restApi {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;
    public int id;

    @Test
    public void addpet() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        Response res = RestAssured.given().
                contentType(ContentType.JSON).
                body("{\n" +
                        "  \"id\": 1845563262948985900,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}").
                when().
                post("/v2/pet");
        String body = res.getBody().asString();
        System.out.println(body);
    }

    @Test
    public void getRequest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        Response res = RestAssured.
                given().
                contentType(ContentType.JSON).
                when().
                get("/findByStatus?status=available").
                then().
                statusCode(200).
                extract().
                response();
        res.prettyPrint();
//        body("status",equalTo("available")).
//        String body  = res.getBody().asString();
        int responsecode = res.getStatusCode();
//        System.out.println(body);
        System.out.println(responsecode);
    }

    public int getID() {
        return id;
    }

    @Test
    public void putRequest() {
//        RestAssured.baseURI="https://petstore.swagger.io";
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io").
                build();
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
        Response res = RestAssured.
                given().
                spec(requestSpec).
                contentType(ContentType.JSON).
                log().
                all().
                body("{\n" +
                        "  \"id\":" + getID() + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}").
                when().
                put("/v2/pet/" + getID()).
                then().
                spec(responseSpec).
                log().
                body().
                statusCode(405).
                extract().
                response();
        res.prettyPrint();
        int responsecode = res.getStatusCode();
        System.out.println(responsecode);
    }
}
