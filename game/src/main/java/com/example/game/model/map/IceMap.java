package com.example.game.model.map;

import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.TownHall;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

public class IceMap extends Map {

    public static final String ID = "iceMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private static final int limitationOfSoldiers=30;

    public IceMap(Image mapImage) {
        super(mapImage, ID);
        super.setLimitationOfSoldiers(limitationOfSoldiers);
        ArmyBuilding armyBuilding = new ArmyBuilding(556.0, 307.0,72.0,86.0);
        this.buildings.add(armyBuilding);
        TownHall townHall = new TownHall(457.0, 304.0,77.0,80.0);
        this.buildings.add(townHall);
        TownHall townHall1 = new TownHall(511.0, 361.0,77.0,80.0);
        this.buildings.add(townHall1);
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
