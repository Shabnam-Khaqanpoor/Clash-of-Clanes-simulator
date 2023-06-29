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
    private int limitationOfSoldiers;
    public GreenMap(Image mapImage) {
        super(mapImage,ID);
        setLimitationOfSoldiers(15);
        ArmyBuilding armyBuilding = new ArmyBuilding(200,130);
        this.buildings.add(armyBuilding);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(200,100);
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
