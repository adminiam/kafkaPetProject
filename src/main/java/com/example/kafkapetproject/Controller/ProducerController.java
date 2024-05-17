package com.example.kafkapetproject.Controller;

import com.example.kafkapetproject.Service.TruckService;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProducerController {
    private final TruckService truckService;

    public ProducerController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("/enableScheduling")
    public String enableScheduling() {
        truckService.setSchedulingEnabled(true);
        return"The app has been started";
    }

    @GetMapping("/disableScheduling")
    public String disableScheduling() {
        truckService.setSchedulingEnabled(false);
        return "The app was stopped";
    }
}
