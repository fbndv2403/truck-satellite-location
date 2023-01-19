package com.teclogi.fase2.entities;


public class SatelliteLocationEntity {
    private String name;
    private Float distance;

    public SatelliteLocationEntity() {
    }

    public SatelliteLocationEntity(String name, Float distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
