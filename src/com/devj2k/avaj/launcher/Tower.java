package com.devj2k.avaj.launcher;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Tower {
    List<Flyable> observers = new CopyOnWriteArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }
}
