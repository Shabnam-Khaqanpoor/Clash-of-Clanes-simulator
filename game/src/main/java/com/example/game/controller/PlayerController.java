package com.example.game.controller;

import com.example.game.model.Player;
import com.example.game.model.map.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class PlayerController {

    public static Player onlinePlayer;
    Random random = new Random();

    public void signUp(String ID, String pass, Map map) throws Exception {
        if (!checkID(ID, readDatabase()) || pass.length() <= 6) {
            throw new Exception();
        }
        //check from database to be unique the ID and check the password to be more than 6 characters
        else {
            Player player = new Player(ID, pass, map, random.nextInt(10) + 1);
            onlinePlayer = player;
            saveToDatabase(player);
            //saveed to database
        }
    }

    public boolean login(String ID, String pass) {
        Boolean find=false;
        try {
            ResultSet rs = readDatabase();
            while (rs.next()) {
                if (rs.getString("ID").equals(ID) && rs.getString("password").equals(pass)) {
                    find=true;
                    switch (rs.getString("map")) {
                        case "cityMap" -> {
                            onlinePlayer = new Player(ID, pass, new CityMap( new ImageView(new Image(new ImageIcon("-5823628951187209297_121[52].jpg").getImage().toString()))), rs.getInt("level"));
                            onlinePlayer.setLost(rs.getInt("lost"));
                            onlinePlayer.setWin(rs.getInt("win"));
                        }
                        case "greenMap" -> {
                            onlinePlayer = new Player(ID, pass, new GreenMap( new ImageView(new Image(new ImageIcon("-5823628951187209297_121[51].jpg").getImage().toString()))), rs.getInt("level"));
                            onlinePlayer.setLost(rs.getInt("lost"));
                            onlinePlayer.setWin(rs.getInt("win"));
                        }
                        case "blueMap" -> {
                            onlinePlayer = new Player(ID, pass, new BlueMap( new ImageView(new Image(new ImageIcon("-5823628951187209297_121[50].jpg").getImage().toString()))), rs.getInt("level"));
                            onlinePlayer.setLost(rs.getInt("lost"));
                            onlinePlayer.setWin(rs.getInt("win"));
                        }
                        case "iceMap" -> {
                            onlinePlayer = new Player(ID, pass, new IceMap( new ImageView(new Image(new ImageIcon("-5823628951187209297_121[49].jpg").getImage().toString()))), rs.getInt("level"));
                            onlinePlayer.setLost(rs.getInt("lost"));
                            onlinePlayer.setWin(rs.getInt("win"));
                        }
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
