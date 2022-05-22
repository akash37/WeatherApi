package com.weatherapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AverageBySensorResponse {
    private Integer sensorId;
    private Double averageTemperature;
}
