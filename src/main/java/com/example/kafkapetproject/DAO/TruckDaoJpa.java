package com.example.kafkapetproject.DAO;

import com.example.kafkapetproject.Model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TruckDaoJpa extends JpaRepository<Truck,Long> {
    @Query("SELECT t FROM Truck t WHERE t.truckId = :id ORDER BY t.id DESC LIMIT 1")
    Truck findLatestTruckById(@Param("id") Integer id);
}
