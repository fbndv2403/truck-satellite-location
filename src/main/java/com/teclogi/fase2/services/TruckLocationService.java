package com.teclogi.fase2.services;

import com.teclogi.fase2.entities.TruckLocationEntity;
import org.springframework.stereotype.Service;

@Service
public class TruckLocationService {

    public Boolean truckMessage(TruckLocationEntity truckLocationEntity) {
        Boolean truckDanger = truckLocationEntity.validateMessage();
        return truckDanger;
    }

}
