package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Giant extends Hero{

    static final long speed = 7000;
    static final int power = 70;
    static final AttackType attackType =AttackType.ATTACK;
    static final int attackRadius= 100;
    static final int health = 600;
    static final long attackStream = 3000;
    public Giant() {
        super( speed, power, attackType, attackRadius, health, attackStream);
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
