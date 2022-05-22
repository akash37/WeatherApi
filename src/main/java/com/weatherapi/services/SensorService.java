package com.weatherapi.services;

import com.weatherapi.models.Sensor;
import com.weatherapi.repository.SensorRepository;
import com.weatherapi.requests.AverageBySensorRequest;
import com.weatherapi.requests.AverageMetricRequest;
import com.weatherapi.response.AverageBySensorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Sensor> getAllSensorDataByTimeBetween(AverageMetricRequest averageMetricRequest){
        return sensorRepository.findAllByTimestampBetween(averageMetricRequest.getStartTimestamp(),
                averageMetricRequest.getEndTimestamp());
    }

    public List<Sensor> getAllSensorDataBySensorIdAndTimeBetween(AverageBySensorRequest averageBySensorRequest){
        return sensorRepository.findAllBySensorIdAndTimestampBetween(averageBySensorRequest.getSensorId(),
                averageBySensorRequest.getStartTimestamp(), averageBySensorRequest.getEndTimestamp());
    }

    public AverageBySensorResponse getAverageSensorDataBySensorIdAndTimeBetween(AverageBySensorRequest averageBySensorRequest){
        return sensorRepository.averageBySensorIdAndTimestampBetween(averageBySensorRequest.getSensorId(),
                averageBySensorRequest.getStartTimestamp(), averageBySensorRequest.getEndTimestamp());
    }

    public List<AverageBySensorResponse> getAverageSensorDataByTimeBetween(AverageMetricRequest averageMetricRequest){
        return sensorRepository.averageAllSensorByTimestampBetween(averageMetricRequest.getStartTimestamp(),
                averageMetricRequest.getEndTimestamp());
    }
}
