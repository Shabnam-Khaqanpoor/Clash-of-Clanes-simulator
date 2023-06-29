package com.example.game;

import com.example.game.model.hero.Archer;
import com.example.game.model.hero.Barbarin;
import com.example.game.model.hero.Giant;
import com.example.game.model.hero.Goblin;
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

public class HeroPage {


    @FXML
    private Text archer;

    @FXML
    private Text barbarian;

    @FXML
    private Text gablin;

    @FXML
    private Text giant;

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

    @FXML
    void onEntered(MouseEvent event) {
        Archer archer1=new Archer();
        archer.setText(archer1.toString());
        Barbarin barbarin=new Barbarin();
        barbarian.setText(barbarin.toString());
        Giant giant1=new Giant();
        giant.setText(giant1.toString());
        Goblin goblin=new Goblin();
        gablin.setText(goblin.toString());
    }
}
