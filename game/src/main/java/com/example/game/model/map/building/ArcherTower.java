package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class ArcherTower extends Building{

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=7000;
    static final int power=200;
    static final int attackRadius=10;
    static final long attackStream=2000;

    private double x;
    private double y;
    private double fitHeight;

    private double fitWidth;


    public ArcherTower(double x,double y,double fitHeight,double fitWidth) {
        super(buildingType, health,x,y,fitHeight,fitWidth);
        super.setPower(power);
        super.setAttackRadius(attackRadius);
        super.setAttackStream(attackStream);
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
