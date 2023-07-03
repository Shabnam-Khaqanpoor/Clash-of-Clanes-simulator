package com.example.game.controller.heroThreads;

import com.example.game.Start;
import com.example.game.model.hero.Archer;
import com.example.game.model.hero.Giant;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GiantThread implements Runnable {

    boolean find;


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

    void byDistance() {

        double closestDistance = Double.MAX_VALUE;
        for (int i = 0; i < Start.buildingsImage.size(); i++) {
            this.find=false;
            if(Start.buildingsImage.get(i).isVisible()){
                this.find=true;

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

        //find closet building
    }

    void moveHero(){
        TranslateTransition transition = new TranslateTransition(Duration.millis(heroClass.getSpeed()), hero);
        transition.setToX(buildingImage.getLayoutX() - hero.getLayoutX() + heroClass.getAttackRadius());
        transition.setToY(buildingImage.getLayoutY() - hero.getLayoutY() + heroClass.getAttackRadius());
        transition.setCycleCount(1);

        transition.play();


        transition.setOnFinished(actionEvent -> {
            this.fire1.setVisible(true);
            this.fire1.setFitHeight(50);
            this.fire1.setFitWidth(50);

        });
    }

    //move to building

    void moveFire() {

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this.fire1);
        transition.setDuration(Duration.millis(this.heroClass.getAttackStream()));
        transition.setCycleCount(100);
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



    @Override
    public void run() {

        hero.setOnMouseReleased(e->{
            byDistance();
            if(this.find){
                moveHero();
                moveFire();
            }
            else {
                Start.win=true;
            }
        });
        while (!Start.win && !Start.lose&& heroClass.getHealth()>0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            byDistance();
            if(this.find){
                moveHero();
                moveFire();
            }
            else {
                Start.win=true;
            }
        }
    }
}