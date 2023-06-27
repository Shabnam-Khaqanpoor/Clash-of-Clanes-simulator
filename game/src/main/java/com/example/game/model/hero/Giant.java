package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Giant extends Hero{
    public Giant(ArrayList<ImageView> imageViews, int speed, int power, AttackType attackType, int attackRadius, int health, int attackStream) {
        super(imageViews, speed, power, attackType, attackRadius, health, attackStream);
    }

    @Override
    public int getAttackStream() {
        return super.getAttackStream();
    }

    @Override
    public int getSpeed() {
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
