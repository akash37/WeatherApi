package com.weatherapi.controller;

import com.weatherapi.models.Sensor;
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


    @GetMapping("/test")
    public String test(){
        return "hello";
    }


}
