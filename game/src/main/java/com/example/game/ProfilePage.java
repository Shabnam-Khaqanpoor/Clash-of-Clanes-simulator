package com.example.game;

import com.example.game.controller.PlayerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProfilePage implements Initializable {

    @FXML
    private ImageView map;

    @FXML
    private Text mapInfo;

    @FXML
    private Text profile;


    void newPage(String fxml,String title,MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml+".fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
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
        profile.setText(PlayerController.onlinePlayer.toString());
        map.setImage(PlayerController.onlinePlayer.getMap().getMapImage());
        mapInfo.setText(PlayerController.onlinePlayer.getMap().toString());
    }
}
