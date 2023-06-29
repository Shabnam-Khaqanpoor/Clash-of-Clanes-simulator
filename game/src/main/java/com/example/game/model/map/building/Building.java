package com.example.game.model.map.building;

import javafx.scene.image.ImageView;

public abstract class Building {

    private ImageView buildingImage;
    private BuildingType buildingType;
    private int health;
    private int power;

    private int attackRadius;
    private long attackStream;

    public Building(ImageView buildingImage, BuildingType buildingType, int health) {
        this.buildingImage = buildingImage;
        this.buildingType = buildingType;
        this.health = health;
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

    public ImageView getBuildingImage() {
        return this.buildingImage;
    }

    public void setBuildingImage(ImageView buildingImage) {
        this.buildingImage = buildingImage;
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
        return "buildingType = " + buildingType +
                "\nhealth = " + health +
                "\npower = " + power +
                "\nattackRadius = " + attackRadius +
                "\nattackStream = " + attackStream;
    }
}
