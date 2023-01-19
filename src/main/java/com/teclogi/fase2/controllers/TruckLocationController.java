package com.teclogi.fase2.controllers;

import com.teclogi.fase2.entities.TruckLocationEntity;
import com.teclogi.fase2.entities.TruckPosition;
import com.teclogi.fase2.payload.TruckResponse;
import com.teclogi.fase2.services.TruckLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
public class TruckLocationController {
    @Autowired
    private TruckLocationService truckLocationService;

    private TruckResponse truckResponse = new TruckResponse();


    @PostMapping("/")
    public ResponseEntity<TruckResponse> truckIsInDanger (@RequestBody TruckLocationEntity truckLocationEntity) {
        Boolean truckInDanger = this.truckLocationService.truckMessage(truckLocationEntity);

        if(!truckInDanger) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.truckResponse.setTruckPosition(new TruckPosition(-100.0f, 75.5f));
        this.truckResponse.setInDanger(truckInDanger);

       return new ResponseEntity<>(truckResponse, HttpStatus.OK);
    }
}
