package com.example.game.model.map.building;

import javafx.scene.image.ImageView;

import javax.swing.*;

public class TownHall extends Building{
    static final BuildingType buildingType=BuildingType.NORMAL;
    static final int health=6000;

    private double x;
    private double y;
    private double fitHeight;

    private double fitWidth;


    public TownHall(double x,double y,double fitHeight,double fitWidth) {
        super(buildingType, health,x,y,fitHeight,fitWidth);
    }

    public double getX() {
        return super.getX();
    }

    public void setXY(double x,double y) {
        super.setXY(x,y);
    }

    public double getY() {
        return super.getY();
    }

    @Override
    public BuildingType getBuildingType() {
        return super.getBuildingType();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public int getPower() {
        return super.getPower();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
