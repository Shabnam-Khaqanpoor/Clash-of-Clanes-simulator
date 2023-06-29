package com.example.game.model.map;

import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.DefensiveBuilding;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

public class BlueMap extends Map{

    public static final String ID="blueMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;

    public BlueMap(Image mapImage) {
        super(mapImage,ID);
        setLimitationOfSoldiers(10);
        ArmyBuilding armyBuilding = new ArmyBuilding(220,230);
        this.buildings.add(armyBuilding);
        ArcherTower archerTower = new ArcherTower(200,200);
        this.buildings.add(archerTower);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(240,180);
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
