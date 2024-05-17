package com.example.userapi.DAO;


import com.example.userapi.Model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDaoJpa extends JpaRepository<Truck,Long> {
    List<Truck> findAllByTruckId(int id);
}
