package com.example.game;

import com.example.game.controller.PlayerController;
import com.example.game.model.map.BlueMap;
import com.example.game.model.map.CityMap;
import com.example.game.model.map.GreenMap;
import com.example.game.model.map.IceMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginPage {

    PlayerController playerController = new PlayerController();


    @FXML
    private TextField ID;

    @FXML
    private AnchorPane mapsID;

    @FXML
    private ImageView blueMap;

    @FXML
    private ImageView cityMap;

    @FXML
    private ImageView greenMap;

    @FXML
    private ImageView iceMap;

    @FXML
    private PasswordField password;

    @FXML
    void onClose(MouseEvent event) {
        System.exit(0);
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
    void onLogin(MouseEvent event) throws IOException {
        if (playerController.login(ID.getText(), password.getText())) {
            newPage("menu", "Menu page", event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Try again!");
            alert.show();
        }
    }

    @FXML
    void onSignup(MouseEvent event) {
        mapsID.setVisible(true);
    }

    Alert alert = new Alert(Alert.AlertType.ERROR);


    @FXML
    void onBlueMap(MouseEvent event) {
        try {
            BlueMap blueMap1=new BlueMap(blueMap.getId());
            playerController.signUp(ID.getText(), password.getText(), blueMap1);
        } catch (Exception e) {
            alert.setContentText("Your ID should be unique and your password should be more than6!");
            alert.show();
        }
    }

    @FXML
    void onCityMap(MouseEvent event) {
        try {
            CityMap cityMap1=new CityMap( cityMap.getId());
            playerController.signUp(ID.getText(), password.getText(),cityMap1);
        } catch (Exception e) {
            alert.setContentText("Your ID should be unique and your password should be more than6!");
            alert.show();
        }
    }

    @FXML
    void onGreenMap(MouseEvent event) {
        try {
            GreenMap greenMap1=new GreenMap(greenMap.getId());
            playerController.signUp(ID.getText(), password.getText(), greenMap1);
        } catch (Exception e) {
            alert.setContentText("Your ID should be unique and your password should be more than6!");
            alert.show();
        }
    }

    @FXML
    void onIceMap(MouseEvent event) {
        try {
            IceMap iceMap1=new IceMap(iceMap.getId());
            playerController.signUp(ID.getText(), password.getText(), iceMap1);
            newPage("menu", "Menu page", event);
        } catch (Exception e) {
            alert.setContentText("Your ID should be unique and your password should be more than6!");
            alert.show();
        }
    }


}
