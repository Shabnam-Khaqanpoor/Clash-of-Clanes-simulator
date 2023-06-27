package com.example.game.model.map;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GreenMap extends Map{

    private ImageView mapImage;

    public static final String ID="greenMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public GreenMap(ImageView mapImage) {
        super(mapImage,ID);
        setLimitationOfSoldiers(15);
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
