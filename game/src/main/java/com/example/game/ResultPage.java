package com.example.game;

import com.example.game.controller.PlayerController;
import com.example.game.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class ResultPage implements Initializable {

    @FXML
    private Text loser;

    @FXML
    private Text winner;

    public static Player enemy =null;

    void text(Player winnerPlayer,Player loserPlayer){
        winner.setText("Winner : "+winnerPlayer.toString());
        loser.setText("Loser : "+loserPlayer.toString());
    }

    void newPage(String fxml,String title,MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml+".fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onClose(MouseEvent event) throws IOException {
        newPage("Signup","Play!",event);
    }


    public void saveWinToDatabase(Player winner,Player loser) throws Exception {

        winner.setWin(winner.getWin()+1);
        loser.setLost(loser.getLost()+1);

//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clash-of-clans", "root", "4013623007");
//        //connected to the database
////        String sql="UPDATE `player` SET (`win`) VALUES ('" + winner.getWin() + "') WHERE `ID`==winner.getID()";
//        String sql="UPDATE `player` SET (`win`) VALUES ('" + winner.getWin() + "') WHERE `ID`=='" + winner.getID()+ "'";
//        Statement s = con.prepareStatement(sql);
//        s.execute(sql);
//
////        String sql2="UPDATE `player` SET (`lost`) VALUES ('" +loser.getLost() + "') WHERE `ID`==loser.getID()";
//        String sql2="UPDATE `player` SET (`lost`) VALUES ('" + loser.getLost() + "') WHERE `ID`=='" + loser.getID()+ "'";
//        Statement s2 = con.prepareStatement(sql2);
//        s2.execute(sql2);
//        con.close();

        //saved to database
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(enemy ==null){
            try {
                enemy=Start.account;
                saveWinToDatabase(PlayerController.onlinePlayer, enemy);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            text(PlayerController.onlinePlayer, enemy);

        }
        else {
            try {
                saveWinToDatabase(enemy,PlayerController.onlinePlayer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            text(enemy,PlayerController.onlinePlayer);
        }
    }
}
