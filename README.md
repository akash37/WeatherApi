# WeatherApi
Weather API Using Spring Boot

Controllers have endpoints which satisfies the requirements.

Single model is created which is persisted in the database.

MySQL is used for this project.

Table created is sensor_data
create table sensor_data(
   record_id INT NOT NULL AUTO_INCREMENT,
   sensor_id INT NOT NULL,
   temperature FLOAT,
   timestamp BIGINT,
   PRIMARY KEY (record_id)
);

JPA is used to persist data between Java object and relational database. 

Unit Test cases has been written for the endpoints.
