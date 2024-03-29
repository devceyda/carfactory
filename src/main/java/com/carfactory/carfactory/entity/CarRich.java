package com.carfactory.carfactory.entity;

import java.util.Date;

public class CarRich extends Car {

    private String Color;
    private String Brand;
    private String BrandLogo;

    public CarRich(Integer carID, Integer colorID, Integer brandID, String model, Long price, String gearType,
            String fuelType,
            Boolean isRefurbished, Date releaseDate, String color, String brand, String brandLogo) {
        super(carID, colorID, brandID, model, price, gearType, fuelType, isRefurbished, releaseDate);
        this.Color = color;
        this.Brand = brand;
        this.BrandLogo = brandLogo;
    }

    public CarRich() {
    }

    public String getBrandLogo() {
        return BrandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        BrandLogo = brandLogo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

}
