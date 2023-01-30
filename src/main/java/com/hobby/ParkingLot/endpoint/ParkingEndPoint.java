package com.hobby.ParkingLot.endpoint;

import com.hobby.ParkingLot.models.Vehicle;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingEndPoint {

    @PostMapping
    public ResponseEntity parkVehicle(@RequestBody Vehicle vehicle){

        return ResponseEntity.ok("Vechicle Parked!"+vehicle.getVehicleNumber());

    }

    @DeleteMapping
    public ResponseEntity unParkVehicle(@RequestBody Vehicle vehicle){

        return ResponseEntity.ok("Vechicle UnParked!"+vehicle.getVehicleNumber());

    }

}
