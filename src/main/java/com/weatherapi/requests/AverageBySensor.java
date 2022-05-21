package com.weatherapi.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AverageBySensor {
    private Integer sensorId;
    private Long startTimestamp;
    private Long endTimestamp;
}
