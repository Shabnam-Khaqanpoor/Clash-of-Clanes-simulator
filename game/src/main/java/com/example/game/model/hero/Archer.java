package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Archer extends Hero {
    static final long speed = 10000;
    static final int power = 50;
    static final AttackType attackType =AttackType.ATTACK;
    static final int attackRadius= 5;
    static final int health = 1000;
    static final long attackStream = 5000;

    public Archer() {
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
