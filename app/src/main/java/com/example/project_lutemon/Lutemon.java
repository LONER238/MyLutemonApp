package com.example.project_lutemon;

public abstract class Lutemon {
    protected String name, color;
    protected int attack, defense, maxHealth, currentHealth, experience;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.experience = 0;
    }

    public String getStats() {
        return name + " (" + color + ") att: " + getAttackPower() + "; def: " + defense + "; exp:" + experience + "; health: " + currentHealth + "/" + maxHealth;
    }

    public int getAttackPower() {
        return attack + experience;
    }

    public void train() {
        experience++;
    }

    public void heal() {
        currentHealth = maxHealth;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void defend(int damage) {
        int totalDamage = damage - defense;
        currentHealth -= Math.max(totalDamage, 0);
    }

    public void gainExperience() {
        experience++;
    }

    public String getName() { return name; }
}
