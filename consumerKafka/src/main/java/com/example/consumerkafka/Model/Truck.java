package com.example.consumerkafka.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "consumerLocations")
@NoArgsConstructor
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location_consumer")
    private Integer id;
    @Column(name = "truck_consumer")
    private int truckId;
    @Column(name = "latitude_consumer")
    private double latitude;
    @Column(name = "longitude_consumer")
    private double longitude;
}