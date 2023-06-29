package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class ArcherTower extends Building{

    static final ImageView buildingImage=new ImageView(new Image("Archer_Tower.png"));

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=1000;
    static final int power=100;
    static final int attackRadius=10;
    static final long attackStream=5000;

    private double x;
    private double y;


    public ArcherTower(double x,double y) {
        super(buildingImage, buildingType, health,x,y);
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
