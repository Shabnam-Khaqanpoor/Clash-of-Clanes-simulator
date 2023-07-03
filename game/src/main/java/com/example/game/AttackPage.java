package com.example.game;

import com.example.game.controller.MapController;
import com.example.game.controller.PlayerController;
import com.example.game.model.map.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class AttackPage implements Initializable {

    @FXML
    private ImageView map;

    @FXML
    private Text account;

    private int counter = 0;
    MapController mapController = new MapController();


    @FXML
    void onNext(MouseEvent event) throws SQLException, ClassNotFoundException {
        this.counter++;
        if (Objects.equals(MapController.accounts.get(this.counter).getID(), PlayerController.onlinePlayer.getID())) {
            onNext(event);
        }
        if (this.counter > MapController.maps.size()) {
            this.counter = MapController.maps.size();
        }
        showMap();
    }


    void showMap() throws SQLException, ClassNotFoundException {
        if (Objects.equals(MapController.accounts.get(0).getID(), PlayerController.onlinePlayer.getID())) {
            this.counter++;
        }
        account.setText(MapController.accounts.get(this.counter).toString());
        Start.account = MapController.accounts.get(this.counter);

        switch (MapController.maps.get(this.counter)) {
            case "cityMap" -> {
                CityMap cityMap = new CityMap(new Image("city.jpg"));
                map.setImage(cityMap.getMapImage());
                Start.account.setMap(cityMap);
            }
            case "greenMap" -> {
                GreenMap greenMap = new GreenMap(new Image("green.jpg"));
                map.setImage(greenMap.getMapImage());
                Start.account.setMap(greenMap);
            }
            case "blueMap" -> {
                BlueMap blueMap = new BlueMap(new Image("blue.jpg"));
                map.setImage(blueMap.getMapImage());
                Start.account.setMap(blueMap);
            }
            case "iceMap" -> {
                IceMap iceMap = new IceMap(new Image("ice.jpg"));
                map.setImage(iceMap.getMapImage());
                Start.account.setMap(iceMap);
            }
        }
    }


    @FXML
    void onPreMap(MouseEvent event) throws SQLException, ClassNotFoundException {
        this.counter--;
        if (Objects.equals(MapController.accounts.get(this.counter).getID(), PlayerController.onlinePlayer.getID())) {
            onPreMap(event);
        }
        if (this.counter < 0) {
            this.counter = 0;
        }
        showMap();
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
    void onClose() {
        System.exit(0);
    }

    @FXML
    void onPre(MouseEvent event) throws IOException {
        newPage("menu", "Menu page", event);
    }

    @FXML
    void onMap(MouseEvent event) throws IOException {
        newPage("start", "Play!", event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        counter = 0;
        try {
            mapController.readDatabase();
            showMap();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
