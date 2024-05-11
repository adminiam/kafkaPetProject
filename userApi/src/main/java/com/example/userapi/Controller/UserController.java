package com.example.userapi.Controller;

import com.example.userapi.Model.Truck;
import com.example.userapi.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAllTrucksById/{id}")
    public List<Truck> consuming(@PathVariable int id){
        return service.getTruckLocationById(id);
    }
}
