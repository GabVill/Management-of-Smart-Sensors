package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.SmartSensor;

public interface SmartSensorRepository extends MongoRepository<SmartSensor, Integer>{
	
}