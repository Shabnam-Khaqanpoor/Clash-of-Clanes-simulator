package com.example.game.controller;

import com.example.game.model.Player;
import com.example.game.model.map.*;
import javafx.scene.image.Image;

import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class PlayerController {

    public static Player onlinePlayer;
    Random random = new Random();

    public void signUp(String ID, String pass, Map map) throws Exception {
        if (!checkID(ID, readDatabase()) || pass.length() <= 6) {
            throw new Exception();
        }
        //check from database to be unique the ID and check the password to be more than 6 characters
        else {
            onlinePlayer = new Player(ID, pass, map, random.nextInt(10) + 1);
            saveToDatabase(onlinePlayer);
            //saveed to database
        }
    }

    public boolean login(String ID, String pass) {
        boolean find = false;
        try {
            ResultSet rs = readDatabase();
            while (rs.next()) {
                if (rs.getString("ID").equals(ID) && rs.getString("password").equals(pass)) {
                    onlinePlayer = new Player(ID, pass, rs.getInt("level"), rs.getInt("win"), rs.getInt("lost"));

                    find = true;
                    switch (rs.getString("map")) {
                        case "cityMap" -> onlinePlayer.setMap(new CityMap(new Image("city.jpg")));
                        case "greenMap" -> onlinePlayer.setMap(new GreenMap(new Image("green.jpg")));
                        case "blueMap" -> onlinePlayer.setMap(new BlueMap(new Image("blue.jpg")));
                        case "iceMap" -> onlinePlayer.setMap(new IceMap(new Image("ice.jpg")));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return find;
    }

    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clash-of-clans", "root", "4013623007");
        return con;
    }

    public ResultSet readDatabase() throws ClassNotFoundException, SQLException {
        Statement stmt = connection().createStatement();
        String text = "SELECT * from player";
        return stmt.executeQuery(text);
    }

    public boolean checkID(String ID, ResultSet rs) {
        try {
            while (rs.next()) {
                if (rs.getString("ID").equals(ID)) {
                    return false;
                }
            }
            connection().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void saveToDatabase(Player player) throws Exception {
        //connected to the database
        String sql = "INSERT INTO `player` (`ID`,`password`,`map`) VALUES ('" + player.getID() + "','" + player.getPass() + "','" + player.getMap().getID() + "')";
        Statement s = connection().prepareStatement(sql);
        s.execute(sql);
        connection().close();

        //saved to database
    }
}
