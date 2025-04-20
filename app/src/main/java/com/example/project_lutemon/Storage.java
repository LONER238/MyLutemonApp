package com.example.project_lutemon;

import java.util.ArrayList;

class Storage {
    private static Storage storage = null;
    private ArrayList<Lutemon> home = new ArrayList<>();
    private ArrayList<Lutemon> training = new ArrayList<>();
    private ArrayList<Lutemon> arena = new ArrayList<>();

    private Storage() {}

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addToHome(Lutemon l) { home.add(l); }
    public void moveToTraining(Lutemon l) { home.remove(l); training.add(l); }
    public void moveToArena(Lutemon l) { home.remove(l); arena.add(l); }
    public void returnToHome(Lutemon l) { arena.remove(l); l.heal(); home.add(l); }

    public ArrayList<Lutemon> getHome() { return home; }
    public ArrayList<Lutemon> getTraining() { return training; }
    public ArrayList<Lutemon> getArena() { return arena; }
}
