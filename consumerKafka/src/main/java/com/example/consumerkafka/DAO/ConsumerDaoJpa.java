package com.example.consumerkafka.DAO;

import com.example.consumerkafka.Model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsumerDaoJpa extends JpaRepository<Truck,Long> {
}
