package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Hero {
    private ImageView imageView;
    private long speed;
    private int power;
    private int attackRadius;
    private long attackStream;
    private AttackType attackType;
    private int health;

    public Hero( long speed, int power, AttackType attackType, int attackRadius, int health, long attackStream) {
        this.speed = speed;
        this.power = power;
        this.attackType = attackType;
        this.attackRadius = attackRadius;
        this.health = health;
        this.attackStream = attackStream;
    }

    public long getAttackStream() {
        return this.attackStream;
    }

    public long getSpeed() {
        return speed;
    }

    public int getPower() {
        return this.power;
    }

    public AttackType getAttackType() {
        return this.attackType;
    }

    public int getAttackRadius() {
        return this.attackRadius;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public String toString() {
        return "speed = " + speed +
                "\npower = " + power +
                "\nattackRadius = " + attackRadius +
                "\nattackStream = " + attackStream +
                "\nattackType = " + attackType +
                "\nhealth = " + health;
    }
}
