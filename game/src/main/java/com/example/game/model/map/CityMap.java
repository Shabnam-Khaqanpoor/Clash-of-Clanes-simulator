package com.example.game.model.map;

import com.example.game.model.map.building.Building;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

public class CityMap extends Map{
    public static final String ID="cityMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public CityMap(Image mapImage) {
        super(mapImage,ID);
        setLimitationOfSoldiers(20);
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
    }

    public void setLimitationOfSoldiers(int limitationOfSoldiers) {
        this.limitationOfSoldiers = limitationOfSoldiers;
    }

    @Override
    public Image getMapImage() {
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
