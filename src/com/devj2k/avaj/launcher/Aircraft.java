package com.devj2k.avaj.launcher;


public class Aircraft extends Flyable {
    protected final long id;
    protected final String name;
    protected final Coordinates coordinates;
    protected final String stringId;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.stringId = String.valueOf(this.id);
    }

    @Override
    public void updateConditions() {
        System.out.println("Default update conditions method...");
    }
}
