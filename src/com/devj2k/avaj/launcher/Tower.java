package com.devj2k.avaj.launcher;

import java.util.List;


public class Tower {
    List<Flyable> observers;

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionChanged() {

    }
}
