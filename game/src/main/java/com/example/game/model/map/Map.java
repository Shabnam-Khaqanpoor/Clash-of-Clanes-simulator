package com.example.game.model.map;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Map {
    private ImageView mapImage;
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;

    private String ID;

    public String getID(){
        return this.ID;
    }


    public Map(ImageView mapImage,String ID) {
        this.mapImage = mapImage;
        this.ID=ID;
    }

    public ImageView getMapImage() {
        return this.mapImage;
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public int getLimitationOfSoldiers() {
        return this.limitationOfSoldiers;
    }

    @Override
    public String toString() {
        return "Limitation of soldiers= " + limitationOfSoldiers;
    }
}
