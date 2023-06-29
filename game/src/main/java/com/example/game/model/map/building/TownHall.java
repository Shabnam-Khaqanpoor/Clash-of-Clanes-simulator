package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class TownHall extends Building{
    static final ImageView buildingImage=new ImageView(new Image(new ImageIcon("town_hall_level11_ingame_icon.png").getImage().toString()));

    static final BuildingType buildingType=BuildingType.NORMAL;
    static final int health=900;

    public TownHall() {
        super(buildingImage, buildingType, health);
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
