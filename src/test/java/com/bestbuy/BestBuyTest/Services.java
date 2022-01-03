package com.bestbuy.BestBuyTest;

import com.bestbuy.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Services extends TestBase {

    Response response;
    ServicePojo servicePojo = new ServicePojo();

    @Test
    public void getAllServices(){
        response = given()
            //    .queryParam("$limit",1)
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleServiceInfo(){
        response = given()
                .pathParam("id",1)
                .when()
                .get("/services/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void crateNewServiceByPost(){


        servicePojo.setName("PAAN PARAG PAAN MASALA");

        response = given()
                .header("Content-Type", "application/json")
                .body(servicePojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void updateServiceByPut(){
        servicePojo.setName("NO SMOKING");

        response=given()
                .pathParam("id",23)
                .header("Content-Type", "application/json")
                .body(servicePojo)
                .when()
                .put("/services/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void updateServiceByPatch(){
        servicePojo.setName("NO SMOKING, NO DRINK");

        response=given()
                .pathParam("id",23)
                .header("Content-Type", "application/json")
                .body(servicePojo)
                .when()
                .patch("/services/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void deleteService(){
        response=given()
                .pathParam("id",23)
                .when()
                .delete("/services/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }


}
