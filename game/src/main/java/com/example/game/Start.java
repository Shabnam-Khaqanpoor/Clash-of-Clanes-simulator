package com.example.game;

import com.example.game.model.Player;
import com.example.game.model.map.BlueMap;
import com.example.game.model.map.CityMap;
import com.example.game.model.map.GreenMap;
import com.example.game.model.map.IceMap;
import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.DefensiveBuilding;
import com.example.game.model.map.building.TownHall;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

    @FXML
    void onPause(MouseEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch (account.getMap().getID()) {
            case "cityMap" -> {
                CityMap cityMap = new CityMap(new Image("city.jpg"));
                map.setImage(cityMap.getMapImage());
                one.setLayoutX(474.0);
                one.setLayoutY(278.0);
                one.setFitHeight(77.0);
                one.setFitWidth(80.0);
                one.setImage(new ImageView(new Image("town_hall_level11_ingame_icon.png")).getImage());

                two.setLayoutX(577.0);
                two.setLayoutY(281.0);
                two.setFitHeight(86.0);
                two.setFitWidth(53.0);
                two.setImage(new ImageView(new Image("Archer_Tower.png")).getImage());

                three.setLayoutX(516.0);
                three.setLayoutY(342.0);
                three.setFitHeight(88.0);
                three.setFitWidth(86.0);
                three.setImage(new ImageView(new Image("Clash-of-clans-Mortar.png")).getImage());
            }
            case "greenMap" -> {
                GreenMap greenMap = new GreenMap(new Image("green.jpg"));
                map.setImage(greenMap.getMapImage());

                one.setLayoutX(511.0);
                one.setLayoutY(373.0);
                one.setFitHeight(72.0);
                one.setFitWidth(86.0);
                one.setImage(new ImageView(new Image("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png")).getImage());

                two.setLayoutX(501.0);
                two.setLayoutY(287.0);
                two.setFitHeight(88.0);
                two.setFitWidth(86.0);
                two.setImage(new ImageView(new Image("Clash-of-clans-Mortar.png")).getImage());
            }
            case "blueMap" -> {
                BlueMap blueMap = new BlueMap(new Image("blue.jpg"));
                map.setImage(blueMap.getMapImage());

                one.setLayoutX(602.0);
                one.setLayoutY(372.0);
                one.setFitHeight(72.0);
                one.setFitWidth(86.0);
                one.setImage(new ImageView(new Image("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png")).getImage());


                two.setLayoutX(530.0);
                two.setLayoutY(297.0);
                two.setFitHeight(68.0);
                two.setFitWidth(77.0);
                two.setImage(new ImageView(new Image("Archer_Tower.png")).getImage());

                three.setLayoutX(602.0);
                three.setLayoutY(280.0);
                three.setFitHeight(88.0);
                three.setFitWidth(86.0);
                three.setImage(new ImageView(new Image("Clash-of-clans-Mortar.png")).getImage());
            }
            case "iceMap" -> {
                IceMap iceMap = new IceMap(new Image("ice.jpg"));
                map.setImage(iceMap.getMapImage());

                one.setLayoutX(556.0);
                one.setLayoutY(307.0);
                one.setFitHeight(72.0);
                one.setFitWidth(86.0);
                one.setImage(new ImageView(new Image("imgbin_clash-of-clans-youtube-video-gaming-clan-clan-war-building-png.png")).getImage());

                two.setLayoutX(457.0);
                two.setLayoutY(304.0);
                two.setFitHeight(77.0);
                two.setFitWidth(80.0);
                two.setImage(new ImageView(new Image("town_hall_level11_ingame_icon.png")).getImage());

                three.setLayoutX(511.0);
                three.setLayoutY(361.0);
                three.setFitHeight(77.0);
                three.setFitWidth(80.0);

                three.setImage(new ImageView(new Image("town_hall_level11_ingame_icon.png")).getImage());
            }
        }
    }
}
