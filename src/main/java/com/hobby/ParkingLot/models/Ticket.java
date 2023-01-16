package com.hobby.ParkingLot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ticket {
    private String ticketNumber;
    private long startTime;
    private long endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        return Ticket.builder()
                .parkingSlot(parkingSlot)
                .vehicle(vehicle)
                .startTime(System.currentTimeMillis())
                .ticketNumber(vehicle.getVehicleNumber()+System.currentTimeMillis())
                .build();
    }

}
