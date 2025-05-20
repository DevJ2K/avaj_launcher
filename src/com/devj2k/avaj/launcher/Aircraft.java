package com.devj2k.avaj.launcher;


public class Aircraft {
    protected final long id;
    protected final String name;
    protected final Coordinates coordinates;

    public Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }
}
