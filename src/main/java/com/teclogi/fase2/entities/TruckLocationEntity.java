package com.teclogi.fase2.entities;

import java.util.LinkedList;

public class TruckLocationEntity {
    private LinkedList<SatelliteLocationEntity> satellites;
    private LinkedList<String> message;
    private TruckMessage truckMessage = new TruckMessage();

    public TruckLocationEntity() {
    }

    public TruckLocationEntity(LinkedList<SatelliteLocationEntity> satellites, LinkedList<String> message) {
        this.satellites = satellites;
        this.message = message;
    }

    public LinkedList<SatelliteLocationEntity> getSatellites() {
        return satellites;
    }

    public void setSatellites(LinkedList<SatelliteLocationEntity> satellites) {
        this.satellites = satellites;
    }

    public LinkedList<String> getMessage() {
        return message;
    }

    public void setMessage(LinkedList<String> message) {
        this.message = message;
    }

    public LinkedList<Float> getDistances() {
        LinkedList<Float> distances = new LinkedList<>();
        for (SatelliteLocationEntity distance: satellites) {
            distances.add(distance.getDistance());
        }
        return distances;
    }

    public LinkedList<String> getNames() {
        LinkedList<String> names = new LinkedList<>();
        for (SatelliteLocationEntity name: satellites) {
            names.add(name.getName());
        }
        return names;
    }

    public Boolean validateMessage() {
        this.truckMessage.setMessage(message);
        Boolean truckDanger = this.truckMessage.validateMessage();

        return truckDanger;
    }
}
