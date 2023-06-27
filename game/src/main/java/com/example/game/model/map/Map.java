package com.example.game.model.map;

import java.util.ArrayList;

public abstract class Map {
    private String mapID;
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;

    public Map(String mapID) {
        this.mapID = mapID;
    }

    public String getMapID() {
        return this.mapID;
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public int getLimitationOfSoldiers() {
        return this.limitationOfSoldiers;
    }

    @Override
    public String toString() {
        return "mapID= " + mapID +
                "\nbuildings= " + buildings +
                "\nlimitationOfSoldiers= " + limitationOfSoldiers;
    }
}
