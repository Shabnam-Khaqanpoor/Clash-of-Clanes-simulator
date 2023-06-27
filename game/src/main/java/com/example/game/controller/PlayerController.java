package com.example.game.controller;

import com.example.game.model.Player;
import com.example.game.model.map.Map;

import java.sql.*;

public class PlayerController {

    public void signUp(String ID, String pass,Map map) throws Exception {
        if (!checkID(ID, readDatabase()) || pass.length() <= 6) {
            throw new Exception();
        }
        //check from database to be unique the ID and check the password to be more than 6 characters
        else {
            Player player = new Player(ID, pass, map);
            saveToDatabase(player);
            //saveed to database
        }
    }

    public boolean login(String ID, String pass) {
        try {
            ResultSet rs = readDatabase();
            while (rs.next()) {
                if (rs.getString("ID").equals(ID) && rs.getString("password").equals(pass)) {
                        return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        String sql = "INSERT INTO `player` (`ID`,`password`,`map`) VALUES ('" + player.getID() + "','" + player.getPass() + "','" + player.getMap().getMapImage() + "')";
        Statement s = connection().prepareStatement(sql);
        s.execute(sql);
        connection().close();

        //saved to database
    }
}
