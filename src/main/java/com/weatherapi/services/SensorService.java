package com.weatherapi.services;

import com.weatherapi.models.Sensor;
import com.weatherapi.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    SensorRepository sensorRepository;

    public Sensor addSensorData(Sensor sensor){
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        sensor.setTimestamp(timeStampMillis);
        return sensorRepository.save(sensor);
    }

    public List<Sensor> getSensorData(){
        return sensorRepository.findAll();
    }
}
