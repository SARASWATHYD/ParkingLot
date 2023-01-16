package com.hobby.ParkingLot.models;

import com.hobby.ParkingLot.enums.ParkingSlotType;

import java.util.Map;

public class ParkingFloor {
    private String name;
    Map<ParkingSlotType, Map<String,ParkingSlot>> parkingSlots;
    public ParkingFloor(String name, Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots ){
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle){
        VehicleCategory vehicleCategory  = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;
        for(Map.Entry<String,ParkingSlot> iterate : relevantParkingSlot.entrySet()){
            if(iterate.getValue().isAvailable()){
                slot = iterate.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }

        return slot;
    }

    private ParkingSlotType pickCorrectSlot( VehicleCategory vehicleCategory){
        if(VehicleCategory.TwoWheeler.equals(vehicleCategory)) return ParkingSlotType.TwoWheeler;
        if(VehicleCategory.SUV.equals(vehicleCategory)) return ParkingSlotType.Medium;
        if(VehicleCategory.Hatchback.equals(vehicleCategory)) return ParkingSlotType.Compact;
        if(VehicleCategory.Bus.equals(vehicleCategory)) return ParkingSlotType.Large;
        return null;
    }


}
