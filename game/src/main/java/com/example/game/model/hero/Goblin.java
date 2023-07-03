package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Goblin extends Hero{

    static final long speed = 8000;
    static final int power = 90;
    static final AttackType attackType =AttackType.DEFENSIVE;
    static final int attackRadius= 50;
    static final int health =500;
    static final long attackStream = 2000;
    public Goblin() {
        super(speed, power, attackType, attackRadius, health, attackStream);
    }

    @Override
    public long getAttackStream() {
        return super.getAttackStream();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public long getSpeed() {
        return super.getSpeed();
    }

    @Override
    public int getPower() {
        return super.getPower();
    }

    @Override
    public AttackType getAttackType() {
        return super.getAttackType();
    }

    @Override
    public int getAttackRadius() {
        return super.getAttackRadius();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
