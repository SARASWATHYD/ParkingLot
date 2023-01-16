package com.hobby.ParkingLot.models;

import com.hobby.ParkingLot.enums.ParkingSlotType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String name, Address address,  List<ParkingFloor> parkingFloors){
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(String name, Address address,  List<ParkingFloor> parkingFloors){
        if(parkingLot==null){
            return new ParkingLot(name,address,parkingFloors);
        }
        return parkingLot;
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String,ParkingSlot>> parkingSlots){
        ParkingFloor parkingFloor = new ParkingFloor(name,parkingSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor){
        parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle){
        ParkingSlot parkingSlot =getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot==null)
            return null;
        Ticket parkingTicket = createTicketForSlot(parkingSlot,vehicle);
        return parkingTicket;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot,Vehicle vehicle){
        return Ticket.createTicket(vehicle,parkingSlot);
    }

    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int)(endTime - ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        //we can persist this in DB
        return price;
    }


    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle){
        ParkingSlot parkingSlot = null;
        for(ParkingFloor parkingFloor: parkingFloors){
            parkingSlot = parkingFloor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot!=null)
                break;
        }
        return parkingSlot;
    }





}
