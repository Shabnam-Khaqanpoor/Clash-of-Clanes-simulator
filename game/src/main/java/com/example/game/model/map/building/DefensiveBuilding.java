package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class DefensiveBuilding extends Building{

    static final ImageView buildingImage=new ImageView(new Image(new ImageIcon("Clash-of-clans-Mortar.png").getImage().toString()));

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=700;
    static final int power=50;

    static final int attackRadius=3;
    static final long attackStream=3000;

    public DefensiveBuilding() {
        super(buildingImage, buildingType, health);
        super.setPower(power);
        super.setAttackRadius(attackRadius);
        super.setAttackStream(attackStream);
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
