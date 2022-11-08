package services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import models.SmartSensor;
import repositories.SmartSensorRepository;

@Service
@EnableMongoRepositories(basePackageClasses = SmartSensorRepository.class)
public class SmartSensorService {
	
	@Autowired
	private SmartSensorRepository smartSensorRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private RestTemplate restTemplate;
	
	public List<SmartSensor> getAllSensors() {
		return smartSensorRepository.findAll();
	}

	public Optional<SmartSensor> getSmartSensorById(int id) {

		return smartSensorRepository.findById(id);
	}
	
	public String save(SmartSensor smartSensor){
		smartSensorRepository.save(smartSensor);
		
		return "Added Smart Sensor into the db with Id" + smartSensor.getSensorId();
	}

	public String updateSmartSensor(int id, SmartSensor smartSensor) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(id));
		mongoTemplate.find(query, SmartSensor.class);
		smartSensorRepository.save(smartSensor);
		
		restTemplate.execute("http://THRESHOLD-SERVICE/"+id+"/thresholdExceeded", HttpMethod.POST, null, null);
		
		return "Updated Smart Sensor into the db with Id" + smartSensor.getSensorId();
		
	}

	public String deleteSmartSensor(int id) {
		smartSensorRepository.deleteById(id);
		
		return "Deleted Smart Sensor into the db with Id" + id; 
		
	}
	

}