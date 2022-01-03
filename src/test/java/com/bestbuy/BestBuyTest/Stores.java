package com.bestbuy.BestBuyTest;

import com.bestbuy.StorePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Stores extends TestBase {

    Response response;


    @Test
    public void getAllStore(){
        response = given()
            //    .queryParam("$limit",2)         //with limit use queryParam
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStore(){
        response =given()
                .when()
                .pathParam("id",4)
                .get("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createStoreByPost(){
        StorePojo storePojo =new StorePojo();

        storePojo.setName("Marshall");
        storePojo.setType("Big");
        storePojo.setAddress("1351345 Ridgedale Dr");
        storePojo.setAddress2("phoenix");
        storePojo.setCity("North Grafton");
        storePojo.setState("PA");
        storePojo.setZip("35648");
        storePojo.setLat(44.969658);

        response = given()
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }


    @Test
    public void updateStoreByPut(){
        StorePojo storePojo =new StorePojo();

        storePojo.setName("Marshall by TJX");
        storePojo.setType("Big");
        storePojo.setAddress("1351345 Ridgedale Dr");
        storePojo.setAddress2("phoenix");
        storePojo.setCity("North Borough");
        storePojo.setState("PA");
        storePojo.setZip("35648");
        storePojo.setLat(44.969658);

        response=given()
                .pathParam("id",8925)
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .put("/stores/{id}");

        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void updateStoreByPatch(){
        StorePojo storePojo =new StorePojo();

        storePojo.setName("Marshall by TJX");
        storePojo.setType("Big");
        storePojo.setAddress("Near BJ's Gas Plaza");
        storePojo.setAddress2("phoenix");
        storePojo.setCity("North Borough");
        storePojo.setState("PA");
        storePojo.setZip("35648");
        storePojo.setLat(44.969658);

        response=given()
                .pathParam("id",8925)
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .patch("/stores/{id}");

        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void deleteStore(){
        response =given()
                .pathParam("id",8925)
                .when()
                .delete("/store/{id}");

        response.then().statusCode(404);
        response.prettyPrint();
    }



}

