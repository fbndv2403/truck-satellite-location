package com.teclogi.fase2.payload;

import com.teclogi.fase2.entities.TruckPosition;

public class TruckResponse {
    private Boolean isInDanger;
    private TruckPosition truckPosition = new TruckPosition();
    public TruckResponse() {
    }

    public TruckResponse(Boolean isInDanger) {
        this.isInDanger = isInDanger;
    }

    public Boolean getInDanger() {
        return isInDanger;
    }

    public void setInDanger(Boolean inDanger) {
        isInDanger = inDanger;
    }

    public TruckPosition getTruckPosition() {
        return truckPosition;
    }

    public void setTruckPosition(TruckPosition truckPosition) {
        this.truckPosition = truckPosition;
    }
}
