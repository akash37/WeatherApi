package com.weatherapi.controller;

import com.weatherapi.models.Sensor;
import com.weatherapi.requests.AverageBySensorRequest;
import com.weatherapi.requests.AverageMetricRequest;
import com.weatherapi.response.AverageBySensorResponse;
import com.weatherapi.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SensorController {
    @Autowired
    SensorService sensorService;

    @PostMapping("/addSensorData")
    public ResponseEntity<Sensor> addSenorData(@RequestBody Sensor sensorRequest){
        final Sensor sensor = sensorService.addSensorData(sensorRequest);
        return new ResponseEntity<>(sensor, HttpStatus.OK);
    }

    @GetMapping("/getAllSensorData")
    public List<Sensor> getAllSensorData(){
        return sensorService.getSensorData();
    }

    @GetMapping("/getSensorDataById")
    public ResponseEntity<List<Sensor>> getSensorDataById(@RequestBody AverageBySensorRequest averageBySensorRequest){
        final List<Sensor> listOfSensors = sensorService.getAllSensorDataBySensorIdAndTimeBetween(averageBySensorRequest);
        return new ResponseEntity<>(listOfSensors, HttpStatus.OK);
    }

    @GetMapping("/getAllSensorDataByTimeBetween")
    public ResponseEntity<List<Sensor>> getAllSensorDataByTimeBetween(@RequestBody AverageMetricRequest averageMetricRequest){
        final List<Sensor> listOfSensors = sensorService.getAllSensorDataByTimeBetween(averageMetricRequest);
        return new ResponseEntity<>(listOfSensors, HttpStatus.OK);
    }


    @GetMapping("/getAverageSensorDataById")
    public ResponseEntity<AverageBySensorResponse> getAverageSensorDataById(@RequestBody AverageBySensorRequest averageBySensorRequest){
        final AverageBySensorResponse response = sensorService.getAverageSensorDataBySensorIdAndTimeBetween(averageBySensorRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAverageSensorData")
    public ResponseEntity<List<AverageBySensorResponse>> getAverageSensorData(@RequestBody AverageMetricRequest averageMetricRequest){
        final List<AverageBySensorResponse> listOfSensors = sensorService.getAverageSensorDataByTimeBetween(averageMetricRequest);
        return new ResponseEntity<>(listOfSensors, HttpStatus.OK);
    }


    @GetMapping("/test")
    public String test(){
        return "hello";
    }


}
