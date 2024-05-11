package com.example.userapi.Service;

import com.example.userapi.DAO.UserDaoJpa;
import com.example.userapi.Model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserDaoJpa daoJpa;
    public List<Truck> getTruckLocationById(int id){
        return daoJpa.findAllByTruckId(id);
    }




}
