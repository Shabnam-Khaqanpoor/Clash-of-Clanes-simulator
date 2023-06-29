package com.example.game.model.map;

import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.DefensiveBuilding;
import com.example.game.model.map.building.TownHall;
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
        TownHall townHall=new TownHall(200,200);
        this.buildings.add(townHall);
        ArcherTower archerTower = new ArcherTower(220,200);
        this.buildings.add(archerTower);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(210,250);
        this.buildings.add(defensiveBuilding);
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
