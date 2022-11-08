package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Threshold;

public interface ThresholdRepository extends MongoRepository<Threshold, Integer> {

}
