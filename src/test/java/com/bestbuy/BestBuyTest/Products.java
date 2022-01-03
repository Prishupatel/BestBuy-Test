package com.bestbuy.BestBuyTest;

import com.bestbuy.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Products extends TestBase {
    Response response;


    @Test
    public void getAllProducts() {
        response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProduct() {
        response = given()
                .pathParam("id", 43900)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createProduct1ByPost() {
        ProductPojo productPojo = new ProductPojo();

        productPojo.setName("LUCID");
        productPojo.setType("2.0");
        productPojo.setPrice(75000);
        productPojo.setUpc("041333415017");
        productPojo.setShipping(1);
        productPojo.setDescription("Electric Car");
        productPojo.setManufacturer("Lucid-Ev");
        productPojo.setModel("AWD");
        productPojo.setUrl("http://www.bestbuy.com/site/your lucid car/43900.p?id=1059384074145&skuId=43900&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");


        response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void createProduct2ByPost() {

    }

    @Test
    public void updateProduct1ByPut() {
        ProductPojo productPojo = new ProductPojo();

        productPojo.setName("LUCID");
        productPojo.setType("3.0");
        productPojo.setPrice(5.49);
        productPojo.setUpc("041333415017");
        productPojo.setShipping(1);
        productPojo.setDescription("Electric Car");
        productPojo.setManufacturer("Lucid-Ev");
        productPojo.setModel("AWD");
        productPojo.setUrl("http://www.bestbuy.com/site/your lucid car/43900.p?id=1059384074145&skuId=43900&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");


        response = given()
                .pathParam("id", 9999690)
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .put("/products/{id}");

        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void updateProduct1ByPatch() {
        ProductPojo productPojo = new ProductPojo();

        productPojo.setName("LUCID-Tesla");  //Patched
        productPojo.setType("3.0");
        productPojo.setPrice(5.49);
        productPojo.setUpc("041333415017");
        productPojo.setShipping(1);
        productPojo.setDescription("Electric Car");
        productPojo.setManufacturer("Lucid-Ev");
        productPojo.setModel("AWD");
        productPojo.setUrl("http://www.bestbuy.com/site/your lucid car/43900.p?id=1059384074145&skuId=43900&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");


        response = given()
                .pathParam("id", 9999690)
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .patch("/products/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void deleteProduct() {

        response = given()
                .pathParam("id", 9999688)
                .when()
                .delete("/products/{id}");

        response.then().statusCode(404);
        response.prettyPrint();

    }


}
