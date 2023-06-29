package com.example.game.model.map.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class ArcherTower extends Building{

    static final ImageView buildingImage=new ImageView(new Image(new ImageIcon("Archer_Tower.png").getImage().toString()));

    static final BuildingType buildingType=BuildingType.DEFENSIVE;
    static final int health=1000;
    static final int power=100;
    static final int attackRadius=10;
    static final long attackStream=5000;


    public ArcherTower() {
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
