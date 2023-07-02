package com.example.game.controller.heroThreads;

import com.example.game.HelloApplication;
import com.example.game.Start;
import com.example.game.model.hero.Barbarin;
import com.example.game.model.map.building.Building;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class BarbarianThread implements Runnable {

    boolean finished =true;

    ActionEvent event;

    int counter;

    Barbarin heroClass;


    ImageView hero;

    ImageView fire;

    public ArrayList<ImageView> buildingsImage;

    Building building = null;

    ImageView buildingImage;

    int index;
    AnchorPane anchorPane;

    public BarbarianThread(AnchorPane anchorPane, Barbarin heroClass, ImageView hero, ArrayList<ImageView> buildingsImage, ImageView fire, ActionEvent event) {
        this.heroClass = heroClass;
        this.hero = hero;
        this.buildingsImage = buildingsImage;
        this.fire = fire;
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
            transition.setOnFinished(actionEvent -> {
                try {
                    computing();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
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