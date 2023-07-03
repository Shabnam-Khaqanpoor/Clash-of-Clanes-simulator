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

    boolean find;


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
            this.find = false;
            if (Start.buildingsImage.get(i).isVisible()) {
                this.find = true;
                double distance = Math.sqrt(Math.pow(Start.buildingsImage.get(i).getLayoutX() - this.hero.getLayoutX(), 2) +
                        Math.pow(Start.buildingsImage.get(i).getLayoutY() - this.hero.getLayoutY(), 2));
                if (distance < closestDistance) {
                    this.buildingImage = Start.buildingsImage.get(i);
                    this.index = i;
                    this.building = Start.account.getMap().getBuildings().get(i);
                    closestDistance = distance;
                }
            }
        }

        //find close building
    }

    void moveHero() {

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

        //move to building
    }


    void computing() throws IOException {

        int health = this.building.getHealth();
        this.building.setHealth(health - heroClass.getPower());
        try {
            Start.account.getMap().getBuildings().get(index).setHealth(building.getHealth());
        } catch (IndexOutOfBoundsException e) {
            Start.win = true;
        }
        if (this.building.getHealth() <= 0) {
            this.buildingImage.setVisible(false);
        }
    }


    @Override
    public void run() {

        hero.setOnMouseReleased(e->{
            byDistance();
            if(this.find){
                moveHero();
            }else {
                Start.win=true;
            }
        });
        while (!Start.win && !Start.lose) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            byDistance();
            if(this.find){
                moveHero();
            }else {
                Start.win=true;
            }

        }
    }
}