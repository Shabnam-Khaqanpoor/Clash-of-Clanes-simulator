package com.example.game.model.map;

import com.example.game.model.map.building.Building;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Map {
    private Image mapImage;
    private ArrayList<Building> buildings = new ArrayList<>();
    private int limitationOfSoldiers;

    private String ID;

    public String getID(){
        return this.ID;
    }


    public Map(Image mapImage,String ID) {
        this.mapImage = mapImage;
        this.ID=ID;
    }

    public Image getMapImage() {
        return this.mapImage;
    }

    public void setLimitationOfSoldiers(int limitationOfSoldiers) {
        this.limitationOfSoldiers = limitationOfSoldiers;
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public int getLimitationOfSoldiers() {
        return this.limitationOfSoldiers;
    }

    @Override
    public String toString() {
        return "Limitation of soldiers : " + this.limitationOfSoldiers;
    }
}
