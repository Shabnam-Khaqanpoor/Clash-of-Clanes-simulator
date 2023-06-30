package com.example.game.model.map.building;

import javafx.scene.image.ImageView;

public abstract class Building {
    private BuildingType buildingType;
    private int health;
    private int power;
    private int attackRadius;
    private long attackStream;

    private double x;
    private double y;

    private double fitHeight;

    private double fitWidth;

    public Building(BuildingType buildingType, int health,double x,double y,double fitHeight,double fitWidth) {
        this.buildingType = buildingType;
        this.health = health;
        this.fitHeight=fitHeight;
        this.fitWidth=fitWidth;
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return this.x;
    }

    public void setXY(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return this.y;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackRadius() {
        return this.attackRadius;
    }

    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    public long getAttackStream() {
        return this.attackStream;
    }

    public void setAttackStream(long attackStream) {
        this.attackStream = attackStream;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public BuildingType getBuildingType() {
        return this.buildingType;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "buildingType : " + buildingType +
                "\nhealth : " + health +
                "\npower : " + power +
                "\nattackRadius : " + attackRadius +
                "\nattackStream : " + attackStream;
    }
}
