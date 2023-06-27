package com.example.game.model.map;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class IceMap extends Map {

    private ImageView mapImage;
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public IceMap(ImageView mapImage) {
        super(mapImage);
        this.limitationOfSoldiers=30;
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
