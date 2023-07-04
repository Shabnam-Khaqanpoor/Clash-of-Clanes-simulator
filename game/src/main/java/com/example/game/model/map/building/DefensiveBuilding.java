package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class DefensiveBuilding extends Building{

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=4000;
    static final int power=100;

    static final int attackRadius=3;
    static final long attackStream=2000;

    private double x;
    private double y;
    private double fitHeight;

    private double fitWidth;

    public DefensiveBuilding(double x,double y,double fitHeight,double fitWidth) {
        super(buildingType, health,x,y,fitHeight,fitWidth);
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
