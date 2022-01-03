package com.bestbuy;

/**
 * Hello world!
 */
public class StorePojo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    private double lat;


    /**
     * {
     *   "name": "string",
     *   "type": "string",
     *   "address": "string",
     *   "address2": "string",
     *   "city": "string",
     *   "state": "string",
     *   "zip": "string",
     *   "lat": 0,
     *   "lng": 0,
     *   "hours": "string",
     *   "services": {}
     * }
     */

}
