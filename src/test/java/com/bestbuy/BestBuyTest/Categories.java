package com.bestbuy.BestBuyTest;

import com.bestbuy.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Categories extends TestBase {

    Response response;

    @Test
    public void getAllCategories() {
        response = given()
                //   .queryParam("$limit",1)
                .when()
                .get("/categories");
        response.then().statusCode(200);
        response.prettyPrint();

    }


    @Test
    public void getSingleCategories() {
        response = given()
                .when()
                //  .pathParam("id",abcat0010000)
                .get("/categories/{id}");   //NOT WORKED !!
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void createCategoriesByPost() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Best Buy API test");
        categoriesPojo.setId("2434");

        response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void updateStoreByPut() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setName("BestBuy api");

        response = given()
                .pathParam("id", 2434)
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .put("/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void updateStoreByPatch(){

        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setName("BestBuy api");

        response = given()
                .pathParam("id", 2434)
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .patch("/categories/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void deleteCategories(){
        response=given()
                .pathParam("id",2434)
                .when()
                .delete("/categories/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }


}




