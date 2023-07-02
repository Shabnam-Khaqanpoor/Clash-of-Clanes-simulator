package com.example.game.model.map;

import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.DefensiveBuilding;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

public class GreenMap extends Map{


    public static final String ID="greenMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private static final int limitationOfSoldiers=10;
    public GreenMap(Image mapImage) {
        super(mapImage,ID);
        super.setLimitationOfSoldiers(limitationOfSoldiers);
        ArmyBuilding armyBuilding = new ArmyBuilding(511.0,373.0,72.0,86.0);
        this.buildings.add(armyBuilding);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(501.0,287.0,88.0,86.0);
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
