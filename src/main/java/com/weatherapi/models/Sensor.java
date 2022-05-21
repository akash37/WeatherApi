package com.weatherapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="sensor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sensor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="record_id")
    private Long recordId;

    @Column(name="sensor_id")
    private Integer sensorId;

    @Column(name="temperature")
    private Double temperature;

    @Column(name="timestamp")
    private Long timestamp;
}
