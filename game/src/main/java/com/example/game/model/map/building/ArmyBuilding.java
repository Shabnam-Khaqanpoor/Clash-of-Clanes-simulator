package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class ArmyBuilding extends Building{
    static final ImageView buildingImage=new ImageView(new Image(new ImageIcon("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png").getImage().toString()));

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=800;
    static final int power=70;

    static final int attackRadius=5;
    static final long attackStream=8000;

    public ArmyBuilding() {
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
