package com.example.game.controller;

import com.example.game.model.Player;

import java.sql.*;
import java.util.ArrayList;

public class MapController {
    public static ArrayList<Player> accounts = new ArrayList<>();
    public static ArrayList<String> maps = new ArrayList<>();

    public void readDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clash-of-clans", "root", "4013623007");
        Statement stmt = con.createStatement();
        String text = "SELECT * from player";
        ResultSet rs = stmt.executeQuery(text);

        try {
            while (rs.next()) {
                accounts.add(new Player(rs.getString("ID"),rs.getString("password"), rs.getInt("level"), rs.getInt("win"), rs.getInt("lost")));
                maps.add(rs.getString("map"));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
