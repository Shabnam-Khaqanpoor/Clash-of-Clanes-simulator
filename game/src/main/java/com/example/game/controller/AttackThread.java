package com.example.game.controller;

import com.example.game.Start;

public class AttackThread implements Runnable {
    @Override
    public void run() {
        if (Start.account.getMap().getBuildings().size() == 0) {
            Start.win = true;
        } else if (Start.heroes.size() == 0) {
            Start.win = true;
            Start.enemy = Start.account;
        }
    }
}
