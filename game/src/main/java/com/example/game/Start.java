package com.example.game;

import com.example.game.model.Player;
import com.example.game.model.map.BlueMap;
import com.example.game.model.map.CityMap;
import com.example.game.model.map.GreenMap;
import com.example.game.model.map.IceMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Start implements Initializable {
    public static Player account;

    @FXML
    private ImageView map;

    @FXML
    private ImageView one;

    @FXML
    private ImageView three;

    @FXML
    private ImageView two;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch (account.getMap().getID()) {
            case "cityMap" -> {
                CityMap cityMap = new CityMap(new Image("city.jpg"));
                map.setImage(cityMap.getMapImage());
                one.setX(cityMap.getBuildings().get(0).getX());
                one.setY(cityMap.getBuildings().get(0).getY());
                one.setImage(new ImageView(new Image("town_hall_level11_ingame_icon.png")).getImage());
                two.setX(cityMap.getBuildings().get(1).getX());
                two.setY(cityMap.getBuildings().get(1).getY());
                two.setImage(new ImageView(new Image("Archer_Tower.png")).getImage());
                three.setX(cityMap.getBuildings().get(2).getX());
                three.setY(cityMap.getBuildings().get(2).getY());
                three.setImage(new ImageView(new Image("Clash-of-clans-Mortar.png")).getImage());
            }
            case "greenMap" -> {
                GreenMap greenMap = new GreenMap(new Image("green.jpg"));
                map.setImage(greenMap.getMapImage());
                one.setX(greenMap.getBuildings().get(0).getX());
                one.setY(greenMap.getBuildings().get(0).getY());
                one.setImage(new ImageView(new Image("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png")).getImage());
                two.setX(greenMap.getBuildings().get(1).getX());
                two.setY(greenMap.getBuildings().get(1).getY());
                two.setImage(new ImageView(new Image("Clash-of-clans-Mortar.png")).getImage());
            }
            case "blueMap" -> {
                BlueMap blueMap = new BlueMap(new Image("blue.jpg"));
                map.setImage(blueMap.getMapImage());
                one.setX(blueMap.getBuildings().get(0).getX());
                one.setY(blueMap.getBuildings().get(0).getY());
                one.setImage(new ImageView(new Image("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png")).getImage());
                two.setX(blueMap.getBuildings().get(1).getX());
                two.setY(blueMap.getBuildings().get(1).getY());
                two.setImage(new ImageView(new Image("Archer_Tower.png")).getImage());
                three.setX(blueMap.getBuildings().get(2).getX());
                three.setY(blueMap.getBuildings().get(2).getY());
                three.setImage(new ImageView(new Image("Clash-of-clans-Mortar.png")).getImage());
            }
            case "iceMap" -> {
                IceMap iceMap = new IceMap(new Image("ice.jpg"));
                map.setImage(iceMap.getMapImage());

                one.setX(iceMap.getBuildings().get(0).getX());
                one.setY(iceMap.getBuildings().get(0).getY());
                one.setImage(new ImageView(new Image("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png")).getImage());
                two.setX(iceMap.getBuildings().get(1).getX());
                two.setY(iceMap.getBuildings().get(1).getY());
                two.setImage(new ImageView(new Image("town_hall_level11_ingame_icon.png")).getImage());
                three.setX(iceMap.getBuildings().get(2).getX());
                three.setY(iceMap.getBuildings().get(2).getY());
                three.setImage(new ImageView(new Image("town_hall_level11_ingame_icon.png")).getImage());
            }
        }
    }
}
