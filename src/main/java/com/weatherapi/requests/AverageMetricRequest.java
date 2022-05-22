package com.weatherapi.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AverageMetricRequest {
    private Long startTimestamp;
    private Long endTimestamp;
}
