package com.example.game;

import com.example.game.controller.heroThreads.ArcherThread;
import com.example.game.controller.heroThreads.BarbarianThread;
import com.example.game.controller.heroThreads.GiantThread;
import com.example.game.controller.heroThreads.GoblinThread;
import com.example.game.model.Player;
import com.example.game.model.hero.*;
import com.example.game.model.map.BlueMap;
import com.example.game.model.map.CityMap;
import com.example.game.model.map.GreenMap;
import com.example.game.model.map.IceMap;
import com.example.game.model.map.building.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Start extends Pane implements Initializable {

    public ArrayList<ImageView> buildingsImage = new ArrayList<>();
    public static Player account;

    public static ArrayList<ImageView> heroImages = new ArrayList<>();

    public static ArrayList<Hero> heroes = new ArrayList<>();

    public static boolean win = false;

    @FXML
    private ImageView archer;


    @FXML
    private ImageView barbarian;

    @FXML
    private ImageView giant;

    @FXML
    private ImageView goblin;

    @FXML
    private ImageView map;

    @FXML
    private ImageView one;

    @FXML
    private ImageView three;

    @FXML
    private ImageView two;

    @FXML
    private ImageView fire;

    @FXML
    private AnchorPane anchorPane;


    @FXML
    void onArcher(ActionEvent event) {
        Archer archerClass = new Archer();
        addHero(archerClass, archer, event);

    }


    @FXML
    void onBarbarian(ActionEvent event) {

        Barbarin barbarinClass = new Barbarin();
        addHero(barbarinClass, barbarian, event);


    }

    //
    @FXML
    void onGiant(ActionEvent event) {
        Giant giantClass = new Giant();
        addHero(giantClass, giant, event);


    }

    @FXML
    void onGoblin(ActionEvent event) {
        Goblin goblinClass = new Goblin();
        addHero(goblinClass, goblin, event);


    }

    void addHero(Hero heroClass, ImageView hero, ActionEvent event) {
        ImageView newHero = new ImageView();
        ImageView fire1 = new ImageView();
        fire1.setImage(fire.getImage());

        if (heroes.size() < account.getMap().getLimitationOfSoldiers()) {

            newHero.setImage(hero.getImage());
            newHero.setFitHeight(100);
            newHero.setFitWidth(100);
            newHero.setLayoutX(hero.getLayoutX() + 2);
            newHero.setLayoutY(hero.getLayoutY() + 2);
            anchorPane.getChildren().add(newHero);

            //make a hero

            fire1.setFitHeight(100);
            fire1.setFitWidth(100);
            fire1.setLayoutX(hero.getLayoutX() + 2);
            fire1.setLayoutY(hero.getLayoutY() + 2);
            anchorPane.getChildren().add(fire1);
            DraggableMaker.makeDraggable(newHero, fire1);

            //make fire

            heroes.add(heroClass);
            heroImages.add(hero);

            fire1.setVisible(false);
            if (heroClass instanceof Archer) {
                ArcherThread archerThread = new ArcherThread(anchorPane, (Archer) heroClass, newHero, buildingsImage, fire1, event);
                Thread thread=new Thread(archerThread);
                thread.start();
            } else if (heroClass instanceof Barbarin) {
                fire1.setVisible(false);
                BarbarianThread barbarianThread=new BarbarianThread(anchorPane, (Barbarin) heroClass, newHero, buildingsImage, fire1, event);
                Thread thread=new Thread(barbarianThread);
                thread.start();
            } else if (heroClass instanceof Giant) {
                GiantThread giantThread=new GiantThread(anchorPane, (Giant) heroClass, newHero, buildingsImage, fire1, event);
                Thread thread=new Thread(giantThread);
                thread.start();
            } else if (heroClass instanceof Goblin) {
                fire1.setVisible(false);
                GoblinThread goblinThread=new GoblinThread(anchorPane, (Goblin) heroClass, newHero, buildingsImage, fire1, event);
                Thread thread=new Thread(goblinThread);
                thread.start();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error!");
            alert.show();
        }
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


                TownHall townHall = new TownHall(474.0, 278.0, 77.0, 80.0);
                account.getMap().getBuildings().add(townHall);
                ArcherTower archerTower = new ArcherTower(577.0, 281.0, 86.0, 53.0);
                account.getMap().getBuildings().add(archerTower);
                DefensiveBuilding defensiveBuilding = new DefensiveBuilding(516.0, 342.0, 88.0, 86.0);
                account.getMap().getBuildings().add(defensiveBuilding);


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

                ArmyBuilding armyBuilding = new ArmyBuilding(511.0, 373.0, 72.0, 86.0);
                account.getMap().getBuildings().add(armyBuilding);
                DefensiveBuilding defensiveBuilding = new DefensiveBuilding(501.0, 287.0, 88.0, 86.0);
                account.getMap().getBuildings().add(defensiveBuilding);
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

                ArmyBuilding armyBuilding = new ArmyBuilding(602.0, 372.0, 72.0, 86.0);
                account.getMap().getBuildings().add(armyBuilding);
                ArcherTower archerTower = new ArcherTower(530.0, 297.0, 68.0, 77.0);
                account.getMap().getBuildings().add(archerTower);
                DefensiveBuilding defensiveBuilding = new DefensiveBuilding(602.0, 280.0, 88.0, 86.0);
                account.getMap().getBuildings().add(defensiveBuilding);
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


                ArmyBuilding armyBuilding = new ArmyBuilding(556.0, 307.0, 72.0, 86.0);
                account.getMap().getBuildings().add(armyBuilding);
                TownHall townHall = new TownHall(457.0, 304.0, 77.0, 80.0);
                account.getMap().getBuildings().add(townHall);
                TownHall townHall1 = new TownHall(511.0, 361.0, 77.0, 80.0);
                account.getMap().getBuildings().add(townHall1);
            }
        }

        buildingsImage.add(one);
        buildingsImage.add(two);
        buildingsImage.add(three);


//        ImageView fire1 = new ImageView();
//        fire1.setImage(fire.getImage());
//        for (Building building : account.getMap().getBuildings()) {
//            BuildingThread buildingThread = new BuildingThread(anchorPane,fire1, building);
//            Thread thread = new Thread(buildingThread);
//            thread.start();
//        }
    }
}