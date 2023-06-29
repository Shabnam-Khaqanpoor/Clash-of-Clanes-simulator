package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuPage {

    void newPage(String fxml,String title,MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml+".fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAttack(MouseEvent event) throws IOException {
        newPage("attack","Choose a map!",event);
    }

    @FXML
    void onClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void onHeroes(MouseEvent event) throws IOException {
        newPage("hero","Hero Page!",event);
    }

    @FXML
    void onMaps(MouseEvent event) throws IOException {
        newPage("maps","Map Page!",event);
    }

    @FXML
    void onPre(MouseEvent event) throws IOException {
        newPage("login","Login Page!",event);
    }

    @FXML
    void onProfile(MouseEvent event) throws IOException {
        newPage("profile","Profile Page!",event);
    }

}
