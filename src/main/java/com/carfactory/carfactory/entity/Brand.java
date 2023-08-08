package com.carfactory.carfactory.entity;

public class Brand {

    private int BrandID;
    private String Brand;

    public Brand(int brandID, String brand) {
        BrandID = brandID;
        Brand = brand;
    }

    public Brand() {
    }

    public int getBrandID() {
        return BrandID;
    }

    public void setBrandID(int brandID) {
        BrandID = brandID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

}
