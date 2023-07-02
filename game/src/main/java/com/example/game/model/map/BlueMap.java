package com.example.game.model.map;

import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.DefensiveBuilding;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class BlueMap extends Map{

    public static final String ID="blueMap";
    private final ArrayList<Building> buildings = new ArrayList<>();
    private static final int limitationOfSoldiers=20;

    public BlueMap(Image mapImage) {
        super(mapImage,ID);
        super.setLimitationOfSoldiers(limitationOfSoldiers);
        ArmyBuilding armyBuilding = new ArmyBuilding(602.0,372.0,72.0,86.0);
        this.buildings.add(armyBuilding);
        ArcherTower archerTower = new ArcherTower(530.0,297.0,68.0,77.0);
        this.buildings.add(archerTower);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(602.0,280.0,88.0,86.0);
        this.buildings.add(defensiveBuilding);
    }

    @Override
    public Image getMapImage() {
        return super.getMapImage();
    }

    @Override
    public ArrayList<Building> getBuildings() {
        return super.getBuildings();
    }

    @Override
    public int getLimitationOfSoldiers() {
        return super.getLimitationOfSoldiers();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
