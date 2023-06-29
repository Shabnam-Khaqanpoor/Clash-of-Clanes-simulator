package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AttackPage {
    @FXML
    private Text archerTower;

    @FXML
    private Text armyBuilding;

    @FXML
    private Text defensiveBuilding;

    @FXML
    private Text townhall;

    @FXML
    void onBlue(MouseEvent event) throws IOException {
        newPage("blueMap","Start Game!",event);
    }

    @FXML
    void onBlue1(MouseEvent event) throws IOException {
        onBlue(event);
    }

    @FXML
    void onBlue2(MouseEvent event) throws IOException {
        onBlue(event);
    }

    @FXML
    void onBlue3(MouseEvent event) throws IOException {
        onBlue(event);
    }

    @FXML
    void onCity(MouseEvent event) throws IOException {
        newPage("cityMap","Start Game!",event);
    }

    @FXML
    void onCity1(MouseEvent event) throws IOException {
        onCity(event);
    }

    @FXML
    void onCity2(MouseEvent event) throws IOException {
        onCity(event);
    }

    @FXML
    void onCity3(MouseEvent event) throws IOException {
        onCity(event);
    }


    @FXML
    void onGreen(MouseEvent event) throws IOException {
        newPage("greenMap","Start Game!",event);
    }

    @FXML
    void onGreen1(MouseEvent event) throws IOException {
        onGreen(event);
    }

    @FXML
    void onGreen2(MouseEvent event) throws IOException {
        onGreen(event);
    }

    @FXML
    void onIce(MouseEvent event) throws IOException {
        newPage("iceMap","Start Game!",event);
    }

    @FXML
    void onIce1(MouseEvent event) throws IOException {
        onIce(event);
    }

    @FXML
    void onIce2(MouseEvent event) throws IOException {
        onIce(event);
    }

    @FXML
    void onIce3(MouseEvent event) throws IOException {
        onIce(event);
    }

    void newPage(String fxml, String title, MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml + ".fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void onPre(MouseEvent event) throws IOException {
        newPage("menu", "Menu page", event);
    }
}
