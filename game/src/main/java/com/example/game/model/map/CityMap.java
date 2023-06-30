package com.example.game.model.map;

import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.Building;
import com.example.game.model.map.building.DefensiveBuilding;
import com.example.game.model.map.building.TownHall;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CityMap extends Map{
    public static final String ID="cityMap";
    private ArrayList<Building> buildings = new ArrayList<>();
    private static final int limitationOfSoldiers=20;
    public CityMap(Image mapImage) {
        super(mapImage,ID);
        super.setLimitationOfSoldiers(limitationOfSoldiers);
        TownHall townHall=new TownHall(474.0,278.0,77.0,80.0);
        this.buildings.add(townHall);
        ArcherTower archerTower = new ArcherTower(577.0,281.0,86.0,53.0);
        this.buildings.add(archerTower);
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding(516.0,342.0,88.0,86.0);
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
