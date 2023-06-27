package com.example.game.model.hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Hero {
    private ArrayList<ImageView> imageViews;
    private int speed;
    private int power;
    private int attackStream;
    private AttackType attackType;
    private int attackRadius;
    private int health;

    public Hero(ArrayList<ImageView> imageViews,int speed, int power, AttackType attackType, int attackRadius, int health,int attackStream) {
        this.imageViews =imageViews;
        this.speed = speed;
        this.power = power;
        this.attackType = attackType;
        this.attackRadius = attackRadius;
        this.health = health;
        this.attackStream=attackStream;
    }

    public int getAttackStream() {
        return this.attackStream;
    }

    public int getSpeed() {
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
        return "heroID= " + imageViews +
                "\nspeed= " + speed +
                "\npower= " + power +
                "\nattackType= " + attackType +
                "\nattackRadius= " + attackRadius +
                "\nhealth= " + health;
    }

    public static class Barbarian extends Hero{
        public Barbarian(ArrayList<ImageView> imageViews, int speed, int power, AttackType attackType, int attackRadius, int health, int attackStream) {
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
}
