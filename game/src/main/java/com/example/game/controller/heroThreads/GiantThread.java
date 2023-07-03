package com.example.game.controller.heroThreads;

import com.example.game.Start;
import com.example.game.model.hero.Giant;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GiantThread implements Runnable {


    Giant heroClass;


    ImageView hero;

    ImageView fire1;

    Building building = null;

    ImageView buildingImage;

    int index;

    public GiantThread(Giant heroClass, ImageView hero, ImageView fire1) {
        this.heroClass = heroClass;
        this.hero = hero;
        this.fire1 = fire1;
    }

    synchronized void byDistance() {

        double closestDistance = Double.MAX_VALUE;
        for (int i = 0; i < Start.buildingsImage.size(); i++) {
            double distance = Math.sqrt(Math.pow(Start.buildingsImage.get(i).getLayoutX() - this.hero.getLayoutX(), 2) +
                    Math.pow(Start.buildingsImage.get(i).getLayoutY() - this.hero.getLayoutY(), 2));
            if (distance < closestDistance) {
                this.buildingImage = Start.buildingsImage.get(i);
                this.index = i;
                this.building = Start.account.getMap().getBuildings().get(i);
                closestDistance = distance;
            }
        }

        //find close building

        TranslateTransition transition = new TranslateTransition(Duration.millis(heroClass.getSpeed()), hero);
        transition.setToX(buildingImage.getLayoutX() - hero.getLayoutX() + heroClass.getAttackRadius());
        transition.setToY(buildingImage.getLayoutY() - hero.getLayoutY() + heroClass.getAttackRadius());
        transition.setCycleCount(1);

        transition.play();


        transition.setOnFinished(actionEvent -> {
            this.fire1.setVisible(true);
            this.fire1.setFitHeight(50);
            this.fire1.setFitWidth(50);
            moveFire();

        });

        //move to building
    }

    void moveFire() {

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this.fire1);
        transition.setDuration(Duration.millis(this.heroClass.getAttackStream()));
        transition.setCycleCount(20);
        transition.setAutoReverse(true);
        transition.setToX(buildingImage.getLayoutX() - hero.getLayoutX());
        transition.setToY(buildingImage.getLayoutY() - hero.getLayoutY());
        transition.play();
        transition.setOnFinished(e -> this.fire1.setVisible(false));

        try {
            computing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


     void computing() throws IOException {

        int health = this.building.getHealth();
        this.building.setHealth(health - heroClass.getPower());
         try {
             Start.account.getMap().getBuildings().get(index).setHealth(building.getHealth());
         }catch (IndexOutOfBoundsException e){
             Start.win=true;
         }
        if (this.building.getHealth() <= 0) {

            Start.buildingsImage.remove(this.buildingImage);
            Start.account.getMap().getBuildings().remove(this.building);
            this.buildingImage.setVisible(false);

        }
    }

    void firstTime() {
        hero.setOnMouseReleased(event -> {

            double closestDistance = Double.MAX_VALUE;
            for (int i = 0; i < Start.buildingsImage.size(); i++) {
                double distance = Math.sqrt(Math.pow(Start.buildingsImage.get(i).getLayoutX() - this.hero.getLayoutX(), 2) +
                        Math.pow(Start.buildingsImage.get(i).getLayoutY() - this.hero.getLayoutY(), 2));
                if (distance < closestDistance) {
                    this.buildingImage = Start.buildingsImage.get(i);
                    index = i;
                    this.building = Start.account.getMap().getBuildings().get(i);
                    closestDistance = distance;
                }
            }

            //find close building
            TranslateTransition transition = new TranslateTransition(Duration.millis(heroClass.getSpeed()), hero);
            transition.setToX(buildingImage.getLayoutX() - hero.getLayoutX() + heroClass.getAttackRadius());
            transition.setToY(buildingImage.getLayoutY() - hero.getLayoutY() + heroClass.getAttackRadius());
            transition.setCycleCount(1);

            transition.play();

            transition.setOnFinished(actionEvent -> {
                this.fire1.setVisible(true);
                this.fire1.setFitHeight(50);
                this.fire1.setFitWidth(50);
                firstFire();
            });
        });
    }

    void firstFire() {
        this.fire1.setOnMouseReleased(event -> {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(this.fire1);
            transition.setDuration(Duration.millis(this.heroClass.getAttackStream()));
            transition.setCycleCount(20);
            transition.setAutoReverse(true);
            transition.setToX(buildingImage.getLayoutX() - hero.getLayoutX());
            transition.setToY(buildingImage.getLayoutY() - hero.getLayoutY());
            transition.play();
            transition.setOnFinished(e -> this.fire1.setVisible(false));

            try {
                computing();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void checker() {
        if (Start.account.getMap().getBuildings().size() == 0||Start.win) {
            Start.win = true;
        }
    }


    @Override
    public void run() {

        firstTime();
        while (!Start.win && !Start.lose) {
            byDistance();
            checker();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}