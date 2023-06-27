package com.example.game.model.map;

import java.util.ArrayList;

public class GreenMap extends Map{

    private String mapID;
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;
    public GreenMap(String mapID) {
        super(mapID);
        this.limitationOfSoldiers=15;
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
//        this.buildings.add();
    }

    @Override
    public String getMapID() {
        return super.getMapID();
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
