package com.example.game.model.map;

import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.TownHall;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

public class IceMap extends Map {

    public static final String ID="iceMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public IceMap(Image mapImage) {
        super(mapImage,ID);
        setLimitationOfSoldiers(30);
        ArmyBuilding armyBuilding = new ArmyBuilding(250,200);
        this.buildings.add(armyBuilding);
        TownHall townHall=new TownHall(200,200);
    this.buildings.add(townHall);
        TownHall townHall1=new TownHall(220,230);
        this.buildings.add(townHall1);
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
