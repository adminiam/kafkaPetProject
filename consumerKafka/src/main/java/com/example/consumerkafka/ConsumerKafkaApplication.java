package com.example.consumerkafka;

import com.example.consumerkafka.Service.ConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerKafkaApplication.class, args);
        ConsumerService consumerService = new ConsumerService();
        consumerService.consume();
    }

}
