package com.weatherapi.controller;

import com.weatherapi.requests.AverageBySensorRequest;
import com.weatherapi.requests.AverageMetricRequest;
import com.weatherapi.response.AverageBySensorResponse;
import com.weatherapi.services.SensorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class SensorControllerTest {
    @InjectMocks
    SensorController sensorController;

    @Mock
    SensorService sensorService;

    @Test
    public void testing(){
        Assertions.assertEquals(2, 2);
    }

    @Test
    public void testGetAverageSensorDataByIdShouldReturnNull(){
        final AverageBySensorRequest averageBySensorRequest = mock(AverageBySensorRequest.class);
        final AverageBySensorResponse averageBySensorResponse = new AverageBySensorResponse(null, null);
        when(sensorService.getAverageSensorDataBySensorIdAndTimeBetween(averageBySensorRequest)).thenReturn(averageBySensorResponse);

        final ResponseEntity<AverageBySensorResponse> response = sensorController.getAverageSensorDataById(averageBySensorRequest);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(averageBySensorResponse, response.getBody());
    }

    @Test
    public void testGetAverageSensorDataByIdShouldReturnData(){
        final AverageBySensorRequest averageBySensorRequest = mock(AverageBySensorRequest.class);
        final AverageBySensorResponse averageBySensorResponse = mock(AverageBySensorResponse.class);
        when(sensorService.getAverageSensorDataBySensorIdAndTimeBetween(averageBySensorRequest)).thenReturn(averageBySensorResponse);

        final ResponseEntity<AverageBySensorResponse> response = sensorController.getAverageSensorDataById(averageBySensorRequest);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(averageBySensorResponse, response.getBody());
    }

    // Second API
    @Test
    public void testGetAverageSensorDataShouldReturnEmptyList(){
        final AverageMetricRequest averageMetricRequest = mock(AverageMetricRequest.class);
        final List<AverageBySensorResponse> averageBySensorResponse = new ArrayList<>();
        when(sensorService.getAverageSensorDataByTimeBetween(averageMetricRequest)).thenReturn(averageBySensorResponse);

        final ResponseEntity<List<AverageBySensorResponse>> response = sensorController.getAverageSensorData(averageMetricRequest);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(averageBySensorResponse.size() , response.getBody().size());
    }

    @Test
    public void testGetAverageSensorDataShouldReturnData(){
        final AverageMetricRequest averageMetricRequest = mock(AverageMetricRequest.class);
        final List<AverageBySensorResponse> averageBySensorResponse = new ArrayList<>();
        averageBySensorResponse.add(mock(AverageBySensorResponse.class));
        when(sensorService.getAverageSensorDataByTimeBetween(averageMetricRequest)).thenReturn(averageBySensorResponse);

        final ResponseEntity<List<AverageBySensorResponse>> response = sensorController.getAverageSensorData(averageMetricRequest);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(averageBySensorResponse.size(), response.getBody().size());
    }

}
