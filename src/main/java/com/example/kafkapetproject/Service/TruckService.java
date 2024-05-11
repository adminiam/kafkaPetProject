package com.example.kafkapetproject.Service;

import com.example.kafkapetproject.DAO.TruckDaoJpa;
import com.example.kafkapetproject.Model.Truck;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
@Getter
@EnableScheduling
public class TruckService {
    @Autowired
    private ProducerService producerService;
    @Autowired
    private TruckDaoJpa truckDaoJpa;
    @Setter
    private boolean schedulingEnabled = false;

    private void generateLocation(int id) {
        Truck truck = truckDaoJpa.findLatestTruckById(id + 1);
        Random rnd = new Random();
        Truck newTruck = new Truck(truck.getTruckId(), truck.getLatitude() + rnd.nextDouble(0.000005),
                truck.getLongitude() + rnd.nextDouble(0.000005));
        producerService.produceLocation(newTruck);
        truckDaoJpa.save(newTruck);
    }

    @Scheduled(fixedDelay = 10000)
    public void startTruckSimulation() {
        ExecutorService executorService = Executors.newFixedThreadPool(truckDaoJpa.findAll().size());
        if (schedulingEnabled)
            for (int id = 0; id < truckDaoJpa.findAll().size(); id++) {
                final int finalId = id;
                executorService.submit(() -> generateLocation(finalId));
            }
    }
}
