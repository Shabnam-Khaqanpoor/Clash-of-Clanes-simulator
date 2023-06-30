package com.example.game.model.map;

import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.DefensiveBuilding;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class BlueMap extends Map{

    public static final String ID="blueMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private static final int limitationOfSoldiers=10;

    public BlueMap(Image mapImage) {
        super(mapImage,ID);
        super.setLimitationOfSoldiers(limitationOfSoldiers);
        ArmyBuilding armyBuilding = new ArmyBuilding(615.0,368.0);
        this.buildings.add(armyBuilding);
        ArcherTower archerTower = new ArcherTower(543.0,293.0);
        this.buildings.add(archerTower);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(615.0,276.0);
        this.buildings.add(defensiveBuilding);
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
