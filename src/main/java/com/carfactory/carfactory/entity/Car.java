package com.carfactory.carfactory.entity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;


public class Car {

    private Integer CarID;
    private int ColorID;
    private int BrandID;
    private String Model;
    private Long Price;
    private String GearType;
    private String FuelType;
    private boolean IsRefurbished;
    private Date ReleaseDate;

    public Car() {
    }

    public Car(int carID, int colorID, int brandID, String model, long price, String gearType, String fuelType,
            boolean isRefurbished, Date releaseDate) {
        CarID = carID;
        ColorID = colorID;
        BrandID = brandID;
        Model = model;
        Price = price;
        GearType = gearType;
        FuelType = fuelType;
        IsRefurbished = isRefurbished;
        ReleaseDate = releaseDate;
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int carID) {
        CarID = carID;
    }

    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int colorID) {
        ColorID = colorID;
    }

    public int getBrandID() {
        return BrandID;
    }

    public void setBrandID(int brandID) {
        BrandID = brandID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Long getPrice() {
        return Price;
    }

    public String getFormattedPrice() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ITALY);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator('.');
        formatter.setDecimalFormatSymbols(symbols);
        String p = formatter.format(getPrice());
        return p + "  TL";
    }

    public void setPrice(long price) {
        Price = price;
    }

    public String getGearType() {
        return GearType;
    }

    public void setGearType(String gearType) {
        GearType = gearType;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }

    public boolean getIsRefurbished() {
        return IsRefurbished;
    }

    public void setIsRefurbished(boolean isRefurbished) {
        IsRefurbished = isRefurbished;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getFormattedReleaseDate() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedReleaseDate = simpleDateFormat.format(getReleaseDate());
        return formattedReleaseDate;
    }

}
