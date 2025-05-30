package com.devj2k.avaj.launcher;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Tower {
    List<Flyable> observers = new CopyOnWriteArrayList<>();

    public void register(Flyable flyable) {
        // FtLogger.tower(flyable.() + "#" + flyable.getName() + "(" + flyable.getStringId() + ") registered to weather tower.");
        if (observers.add(flyable)) {
        }
    }

    public void unregister(Flyable flyable) {
        // FtLogger.tower(flyable.() + "#" + flyable.getName() + "(" + flyable.getStringId() + ") registered to weather tower.");
        if (observers.remove(flyable)) {
            
        }
    }

    protected void conditionChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }
}
