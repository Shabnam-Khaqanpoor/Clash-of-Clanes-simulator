package com.example.game.model.map;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CityMap extends Map{
    private ImageView mapImage;
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public CityMap(ImageView mapImage) {
        super(mapImage);
        this.limitationOfSoldiers=20;
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
    }

    @Override
    public ImageView getMapImage() {
        return super.getMapImage();
    }

    @Override
    public ArrayList<Building> getBuildings() {
        return super.getBuildings();
    }

    @Override
    public int getLimitationOfSoldiers() {
        return super.getLimitationOfSoldiers();
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
