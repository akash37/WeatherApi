package com.weatherapi.repository;

import com.weatherapi.models.Sensor;
import com.weatherapi.response.AverageBySensorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findAllByTimestampBetween(Long timestampStart, Long timestampEnd);
    List<Sensor> findAllBySensorIdAndTimestampBetween(Integer sensorId, Long timestampStart, Long timestampEnd);

    @Query("SELECT NEW com.weatherapi.response.AverageBySensorResponse(s.sensorId, AVG(s.temperature)) FROM Sensor AS s WHERE s.sensorId = :sensorID AND s.timestamp BETWEEN :timestampStart AND :timestampEnd")
    AverageBySensorResponse averageBySensorIdAndTimestampBetween(@Param("sensorID") Integer sensorId,
                                                                       @Param("timestampStart") Long timestampStart,
                                                                       @Param("timestampEnd") Long timestampEnd);


    @Query("SELECT NEW com.weatherapi.response.AverageBySensorResponse(s.sensorId, AVG(s.temperature)) FROM Sensor AS s WHERE s.timestamp BETWEEN :timestampStart AND :timestampEnd GROUP BY s.sensorId")
    List<AverageBySensorResponse> averageAllSensorByTimestampBetween(@Param("timestampStart") Long timestampStart,
                                                                 @Param("timestampEnd") Long timestampEnd);



}
