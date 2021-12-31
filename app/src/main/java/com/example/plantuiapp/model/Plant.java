package com.example.plantuiapp.model;

public class Plant {
    private String plantName;
    private String plantCountry;
    private String plantPrice;
    private int plantImage;

    public Plant(String plantName, String plantCountry, String plantPrice, int plantImage){
        this.plantName = plantName;
        this.plantCountry = plantCountry;
        this.plantPrice = plantPrice;
        this.plantImage = plantImage;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantCountry() {
        return plantCountry;
    }

    public void setPlantCountry(String plantCountry) {
        this.plantCountry = plantCountry;
    }

    public String getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(String plantPrice) {
        this.plantPrice = plantPrice;
    }

    public int getPlantImage() {
        return plantImage;
    }

    public void setPlantImage(int plantImage) {
        this.plantImage = plantImage;
    }
}
