package com.example.game.model.map;

public abstract class Building {
    private BuildingType buildingType;
    private int health;
    private int power;

    public Building(BuildingType buildingType, int health, int power) {
        this.buildingType = buildingType;
        this.health = health;
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
        return "buildingType= " + buildingType +
                "\n health= " + health +
                "\npower= " + power;
    }
}
