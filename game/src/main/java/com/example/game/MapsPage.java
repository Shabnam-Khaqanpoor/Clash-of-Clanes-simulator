package com.example.game;

import com.example.game.model.map.building.ArcherTower;
import com.example.game.model.map.building.ArmyBuilding;
import com.example.game.model.map.building.DefensiveBuilding;
import com.example.game.model.map.building.TownHall;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MapsPage implements Initializable {

    @FXML
    private Text archerTower;

    @FXML
    private Text armyBuilding;

    @FXML
    private Text defensiveBuilding;

    @FXML
    private Text townhall;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArcherTower archerTower1=new ArcherTower(0,0);
        archerTower.setText(archerTower1.toString());
        TownHall townHall=new TownHall(0,0);
        townhall.setText(townHall.toString());
        ArmyBuilding armyBuilding1=new ArmyBuilding(0,0);
        armyBuilding.setText(armyBuilding1.toString());
        DefensiveBuilding defensiveBuilding1=new DefensiveBuilding(0,0);
        defensiveBuilding.setText(defensiveBuilding1.toString());
    }
}
