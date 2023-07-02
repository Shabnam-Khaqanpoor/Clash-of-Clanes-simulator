package com.example.game.controller;

import com.example.game.HelloApplication;
import com.example.game.Start;
import com.example.game.model.hero.AttackType;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class BuildingThread implements Runnable {
    AnchorPane anchorPane;
    int counter;

    ImageView fire1;
    Building building;

    public BuildingThread(AnchorPane anchorPane,ImageView fire1, Building building) {
        this.anchorPane = anchorPane;
        this.fire1 = fire1;
        this.building = building;
    }

    void findHero() {
        for (int i = 0; i < Start.heroes.size(); i++) {
            if (Start.heroes.get(i).getAttackType() == AttackType.ATTACK) {
                counter = i;
                break;
            } else {
                counter = i;
            }
        }
    }

    void buildingAttack(ImageView hero) throws IOException {
        this.fire1.setFitHeight(50);
        this.fire1.setFitWidth(50);
        this.fire1.setLayoutX(building.getX());
        this.fire1.setLayoutY(building.getY());
        anchorPane.getChildren().add(this.fire1);


        fire1.setVisible(true);
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(fire1);
        transition.setDuration(Duration.millis(building.getAttackStream()));
        transition.setCycleCount(1);
        transition.setToX(hero.getLayoutX() - building.getX());
        transition.setToY(hero.getLayoutY() - building.getY());
        transition.play();

    }

    void computing() throws IOException {

        int health = Start.heroes.get(counter).getHealth();
        Start.heroes.get(counter).setHealth(health - building.getPower());
        if (Start.heroes.get(counter).getHealth() <= 0) {
            Start.heroImages.get(counter).setVisible(false);
            fire1.setVisible(false);
            Start.heroes.remove(Start.heroes.get(counter));
            findHero();
        }

        fire1.setVisible(false);
    }



    @Override
    public void run() {
        findHero();
        try {
            buildingAttack(Start.heroImages.get(counter));
            computing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
