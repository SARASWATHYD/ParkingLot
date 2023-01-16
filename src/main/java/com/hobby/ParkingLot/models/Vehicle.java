package com.hobby.ParkingLot.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Vehicle {
    private String vehicleNumber;
    private VehicleCategory vehicleCategory;
}
