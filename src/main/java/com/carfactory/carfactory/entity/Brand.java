package com.carfactory.carfactory.entity;

public class Brand {

    private int BrandID;
    private String Brand;
    private String BrandLogo;
    private int NumberOfBrand;

    public Brand(int brandID, String brand, String brandLogo, int numberOfBrand) {
        BrandID = brandID;
        Brand = brand;
        BrandLogo = brandLogo;
        NumberOfBrand = numberOfBrand;
    }

    public Brand() {
    }

    public int getBrandID() {
        return BrandID;
    }

    public String getBrandLogo() {
        return BrandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        BrandLogo = brandLogo;
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

    public int getNumberOfBrand() {
        return NumberOfBrand;
    }

    public void setNumberOfBrand(int numberOfBrand) {
        NumberOfBrand = numberOfBrand;
    }

}
