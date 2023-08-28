package com.carfactory.carfactory.entity;

public class Color {

    private int ColorID;
    private String Color;
    private int NumberOfColor;

    public Color(int colorID, String color, int numberOfColor) {
        ColorID = colorID;
        Color = color;
        NumberOfColor = numberOfColor;
    }

    public Color() {
    }

    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int colorID) {
        ColorID = colorID;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getNumberOfColor() {
        return NumberOfColor;
    }

    public void setNumberOfColor(int numberOfColor) {
        NumberOfColor = numberOfColor;
    }

}
