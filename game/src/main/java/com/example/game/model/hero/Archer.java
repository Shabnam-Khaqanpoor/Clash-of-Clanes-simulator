package com.example.game.model.hero;


public class Archer extends Hero {
    static final long speed = 10000;
    static final int power =500;
    static final AttackType attackType =AttackType.ATTACK;
    static final int attackRadius= 150;
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
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
