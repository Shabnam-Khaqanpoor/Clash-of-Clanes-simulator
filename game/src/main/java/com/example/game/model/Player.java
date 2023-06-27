package com.example.game.model;
import com.example.game.model.map.Map;

import java.util.Random;

public class Player {
    private String ID;
    private String pass;
    private int level;
    private int win;
    private int lost;
    private Map map;

    public Player(String ID, String pass, Map map,int level) {
        this.ID=ID;
        this.pass=pass;
        this.map=map;
        this.level= level;
    }

    public String getID() {
        return this.ID;
    }

    public String getPass() {
        return this.pass;
    }

    public int getLevel() {
        return this.level;
    }

    public int getWin() {
        return this.win;
    }

    public int getLost() {
        return this.lost;
    }

    public Map getMap() {
        return this.map;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWin(int win) {this.win = win;}

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String toString(){
        return "ID : "+this.ID+"\nLevel : "+this.level+"\nNumber of win : "+this.win+"\nNumber of lost : "+this.lost;
    }
}
