package com.example.game.controller;

import com.example.game.Start;
import com.example.game.model.hero.Hero;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;

public class BuildingThread implements Runnable {

    boolean find;

    int index;

    ImageView fire1;
    Building building;

    ImageView heroImage;

    Hero heroClass;


    public BuildingThread(ImageView fire1, Building building) {
        this.fire1 = fire1;
        this.building = building;
    }

    void findHero() {
        double closestDistance = Double.MAX_VALUE;
        for (int i = 0; i < Start.heroes.size(); i++) {
            this.find = false;
            if (Start.heroImages.get(i).isVisible()) {
                this.find = true;

                double distance = Math.sqrt(Math.pow(Start.heroImages.get(i).getLayoutX() - Start.buildingsImage.get(i).getLayoutX(), 2) +
                        Math.pow(Start.heroImages.get(i).getLayoutY() - Start.buildingsImage.get(i).getLayoutY(), 2));
                if (distance < closestDistance) {
                    this.heroImage = Start.heroImages.get(i);
                    this.index = i;
                    this.heroClass = Start.heroes.get(i);
                    closestDistance = distance;
                }
            }
        }
    }//find closet hero


    void moveFire() {

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this.fire1);
        transition.setDuration(Duration.millis(this.heroClass.getAttackStream()));
        transition.setCycleCount(100);
        transition.setAutoReverse(true);
        transition.setToX(this.heroImage.getLayoutX() - Start.buildingsImage.get(index).getLayoutX());
        transition.setToY(this.heroImage.getLayoutY() - Start.buildingsImage.get(index).getLayoutY());
        transition.play();
        transition.setOnFinished(e -> this.fire1.setVisible(false));
    }

    //move fire to  hero

    void computing() throws IOException {

        int health = this.heroClass.getHealth();
        this.heroClass.setHealth(health - this.building.getPower());
        Start.heroes.get(index).setHealth(this.heroClass.getHealth());
        if (this.heroClass.getHealth() <= 0) {
            this.heroImage.setVisible(false);
        }
    }


    @Override
    public void run() {
        while (!Start.lose && !Start.win && this.building.getHealth() > 0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                findHero();
                if (this.find) {
                    moveFire();
                    computing();
                } else {
                    Start.lose = true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
