package com.bestbuy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //* 1. Extract the limit
    @Test
    public void test001() {

        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //* 2. Extract the total
    @Test
    public void test002() {

        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //* 3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println(name);

    }

    //* 4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> allStoreName = new ArrayList<>();
        allStoreName = response.extract().path("data.name");
        for (String single : allStoreName) {
            System.out.println("All stores name : " + single);
        }
        //    System.out.println("All stores name : " +allStoreName);

    }

    // * 5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> allStoreIds = new ArrayList<>();
        allStoreIds = response.extract().path("data.id");

        for (Integer singleId : allStoreIds) {
            System.out.println("StoreId : " + singleId);

        }
    }

    //* 6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> allStoreIds = new ArrayList<>();
        allStoreIds = response.extract().path("data.id");
        System.out.println(allStoreIds.size());

    }

    // * 7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println(values);
        //   List<HashMap<String, ?>> values1 = response.extract().path("data.findAll{it.name=='Tjx'}");
        //   System.out.println(values1);

    }

    //* 8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name='Tjx'}.address");
        //   System.out.println(address);
        for (String single : address) {
            System.out.println(single);
        }
    }

    //  * 9. Get all the services of 8th store
    @Test
    public void test09() {
        List<HashMap<String, Object>> service = response.extract().path("data[7].services");

        for (HashMap<String, Object> singleService : service) {
            System.out.println(singleService);
        }
    }

    //  * 10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<HashMap<String, Object>> services = response.extract().path("data.services[7].storeservices");
        System.out.println(services);
    }

    //* 11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> ids = new ArrayList<>();
        ids = response.extract().path("data.services.storeservices.storeId");
        System.out.println(ids);
    }

    //* 12. Get id of all the store
    @Test
    public void test12() {
        List<Integer> storeId = new ArrayList<>();
        storeId = response.extract().path("data.id");
        System.out.println(storeId);
    }

    //* 13. Find the store names Where state = MA
    @Test
    public void test13() {
        List<String> storeName = response.extract().path("data.findAll{it.state=='MA'}.name");
        System.out.println(storeName);
    }

    //* 14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {
        List<String> services = response.extract().path("data.findAll{it.name=='Rochester'}.services");
        int total = response.extract().path("data[8].services.size");

        System.out.println("<-----------------" + services.size() + "--------------------->");
        System.out.println("<*****************" + total + "******************>");
        System.out.println(services);

    }

    // * 15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15() {
        List<String> createdAt =response.extract().path("data.findAll{it.services.name=='Windows Store'}.services.created");
        System.out.println(createdAt);
    }

    // * 16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<String> serviceName=response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println(serviceName);

    }

    //  * 17. Find the zip of all the store
    @Test
    public void test17() {

        List<String> zipList=response.extract().path("data.zip");
        System.out.println("Zip of all stores are : "+zipList);
    }

    // * 18. Find the zip of store name = Roseville
    @Test
    public void test18() {

       List<Integer>zip=response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Zip of Roseville : "+zip);

    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19() {
    ArrayList<String> name= response.extract().path("data.findAll{it.services.name=='Extra 1'}");
        System.out.println(name);
    }

    //  * 20. Find the lat of all the stores
    @Test
    public void test20() {
        List<Double>latList=response.extract().path("data.lat");
        System.out.println(latList);

    }


}
