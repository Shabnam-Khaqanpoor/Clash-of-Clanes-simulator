package com.example.game.controller.heroThreads;

import com.example.game.Start;
import com.example.game.model.hero.Barbarin;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class BarbarianThread implements Runnable {


    Barbarin heroClass;


    ImageView hero;

    ImageView fire;

    Building building = null;

    ImageView buildingImage;

    int index;

    public BarbarianThread(Barbarin heroClass, ImageView hero, ImageView fire) {
        this.heroClass = heroClass;
        this.hero = hero;
        this.fire = fire;
    }

    void byDistance() {

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

        try {
            computing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            computing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //move to building
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
                try {
                    computing();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
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
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}