package controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.SmartSensor;
import services.SmartSensorService;

@RestController
@ComponentScan(basePackageClasses = SmartSensorService.class)
public class SmartSensorController{
	
	
	@Autowired
	private SmartSensorService smartSensorService;

	@GetMapping("/sensors")
	public List<SmartSensor> getAllensors() {

		return smartSensorService.getAllSensors();
	}
	
	@GetMapping("/sensors/{id}")
	public Optional<SmartSensor> getSmartSensor(@PathVariable int id) {

		return smartSensorService.getSmartSensorById(id);
	}
	
	@PostMapping("/sensors/add")
	public String save(@RequestBody SmartSensor smartSensor){
		return smartSensorService.save(smartSensor);
	}
	
	@RequestMapping(value = "/sensors/update/{id}", method = RequestMethod.PUT)
	public String updateSmartSensor(@PathVariable int id, @RequestBody SmartSensor smartSensor){
		return smartSensorService.updateSmartSensor(id, smartSensor);
	}

	@RequestMapping(value = "/sensors/delete/{id}", method = RequestMethod.DELETE)
	public String deleteSmartSensor(@PathVariable int id){
		return smartSensorService.deleteSmartSensor(id);
	}

}
