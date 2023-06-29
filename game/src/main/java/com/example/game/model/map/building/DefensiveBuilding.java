package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class DefensiveBuilding extends Building{

    static final ImageView buildingImage=new ImageView(new Image("Clash-of-clans-Mortar.png"));

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=700;
    static final int power=50;

    static final int attackRadius=3;
    static final long attackStream=3000;

    private double x;
    private double y;

    public DefensiveBuilding(double x,double y) {
        super(buildingImage, buildingType, health,x,y);
        super.setPower(power);
        super.setAttackRadius(attackRadius);
        super.setAttackStream(attackStream);
    }

    @Override
    public BuildingType getBuildingType() {
        return super.getBuildingType();
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
