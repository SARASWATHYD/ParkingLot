package com.hobby.ParkingLot.models;

import com.hobby.ParkingLot.enums.ParkingSlotType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private String name;
    @Builder.Default
    private boolean isAvailable = true;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType){
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    protected void removeVehicle(Vehicle vehicle){
        this.vehicle = null;
        this.isAvailable = true;
    }


}
