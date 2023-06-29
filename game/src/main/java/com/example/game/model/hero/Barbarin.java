package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Barbarin extends Hero{

    static final long speed = 5000;
    static final int power = 80;
    static final AttackType attackType =AttackType.DEFENSIVE;
    static final int attackRadius=0;
    static final int health = 800;
    static final long attackStream = 3000;
    public Barbarin() {
        super( speed, power, attackType, attackRadius, health, attackStream);
    }

    @Override
    public long getAttackStream() {
        return super.getAttackStream();
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
