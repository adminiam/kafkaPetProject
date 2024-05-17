package com.example.kafkapetproject.Service;

import com.example.kafkapetproject.Model.Truck;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.util.Properties;

@Service
public class ProducerService {
    private final Gson gson;

    public ProducerService(Gson gson) {
        this.gson = gson;
    }

    private Properties createProperties() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // Установка сериализатора ключей
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    public void produceLocation(Truck truck) {
        KafkaProducer<String, String> producer = new KafkaProducer<>(createProperties());
        String truckJson = gson.toJson(truck);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("truck_topic", truckJson);
        producer.send(producerRecord);
        producer.flush();

    }
}
