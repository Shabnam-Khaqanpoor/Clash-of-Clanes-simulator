package com.example.game.controller.heroThreads;

import com.example.game.HelloApplication;
import com.example.game.Start;
import com.example.game.model.hero.Archer;
import com.example.game.model.hero.Giant;
import com.example.game.model.hero.Goblin;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class GiantThread implements Runnable {

    boolean finished = false;

    ActionEvent event;

    Giant heroClass;


    ImageView hero;

    ImageView fire1;

    public ArrayList<ImageView> buildingsImage;

    Building building = null;

    ImageView buildingImage;

    int index;
    AnchorPane anchorPane;

    public GiantThread(AnchorPane anchorPane, Giant heroClass, ImageView hero, ArrayList<ImageView> buildingsImage, ImageView fire1, ActionEvent event) {
        this.heroClass = heroClass;
        this.hero = hero;
        this.buildingsImage = buildingsImage;
        this.fire1 = fire1;
        this.anchorPane = anchorPane;
        this.event = event;
    }

    void byDistance() {

        double closestDistance = Double.MAX_VALUE;
        for (int i = 0; i < this.buildingsImage.size(); i++) {
            double distance = Math.sqrt(Math.pow(this.buildingsImage.get(i).getLayoutX() - this.hero.getLayoutX(), 2) +
                    Math.pow(this.buildingsImage.get(i).getLayoutY() - this.hero.getLayoutY(), 2));
            if (distance < closestDistance) {
                this.buildingImage = this.buildingsImage.get(i);
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
    }


    void computing() throws IOException {

        int health = this.building.getHealth();
        this.building.setHealth(health - heroClass.getPower());
        Start.account.getMap().getBuildings().get(index).setHealth(building.getHealth());
        if (this.building.getHealth() <= 0) {

            this.buildingsImage.remove(this.buildingImage);
            Start.account.getMap().getBuildings().remove(this.building);
            this.buildingImage.setVisible(false);

            if (Start.account.getMap().getBuildings().size()==0) {
                finished = true;
                Start.win = true;
            }
        }
    }

    void firstTime() {
        hero.setOnMouseReleased(event -> {

            double closestDistance = Double.MAX_VALUE;
            for (int i = 0; i < this.buildingsImage.size(); i++) {
                double distance = Math.sqrt(Math.pow(this.buildingsImage.get(i).getLayoutX() - this.hero.getLayoutX(), 2) +
                        Math.pow(this.buildingsImage.get(i).getLayoutY() - this.hero.getLayoutY(), 2));
                if (distance < closestDistance) {
                    this.buildingImage = this.buildingsImage.get(i);
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

            try {
                computing();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
        });
    }


    @Override
    public void run() {

        firstTime();


        while (!Start.win) {
            byDistance();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }}


        Parent parent= null;
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("result.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage=(Stage) ((Node)this.event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle("Result!");
        stage.setScene(scene);
        stage.show();


    }
}