package com.example.game.model.map;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class BlueMap extends Map{

    private ImageView mapImage;

    public static final String ID="blueMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public BlueMap(ImageView mapImage) {
        super(mapImage,ID);
        setLimitationOfSoldiers(10);
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
    }

    public void setLimitationOfSoldiers(int limitationOfSoldiers) {
        this.limitationOfSoldiers = limitationOfSoldiers;
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
