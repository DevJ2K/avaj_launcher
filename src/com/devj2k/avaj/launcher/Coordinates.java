package com.devj2k.avaj.launcher;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public void setLongitude(int longitude) {
        if (longitude < 0) {
            this.longitude = 0;
        }
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        if (latitude < 0) {
            this.latitude = 0;
        }
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        if (height < 0) {
            this.height = 0;
        } else if (height > 100) {
            this.height = 100;
        } else {
            this.height = height;
        }
    }
}
