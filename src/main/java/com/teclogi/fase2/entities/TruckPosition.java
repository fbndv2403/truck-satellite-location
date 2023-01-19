package com.teclogi.fase2.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TruckPosition {

    private Float posX;
    private Float posY;

    public TruckPosition() {
    }

    public TruckPosition(Float posX, Float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Float getPosX() {
        return posX;
    }

    public void setPosX(Float posX) {
        this.posX = posX;
    }

    public Float getPosY() {
        return posY;
    }

    public void setPosY(Float posY) {
        this.posY = posY;
    }
}
