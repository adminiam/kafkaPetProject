package com.example.kafkapetproject.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "locations")
@NoArgsConstructor
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Integer id;
    @Column(name = "truck")
    private int truckId;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    public Truck(int truck, double latitude, double longitude) {
        this.truckId = truck;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
