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

import models.Threshold;
import services.ThresholdService;
import valueObject.SmartSensorResponse;
import valueObject.UserResponse;



@RestController
@ComponentScan(basePackageClasses = ThresholdService.class)
public class ThresholdController{
	
	
	@Autowired
	private ThresholdService thresholdService;

	@GetMapping("/thresholds")
	public List<Threshold> getAllThresholds() {

		return thresholdService.getAllThresholds();
	}
	
	@GetMapping("/thresholds/{id}")
	public Optional<Threshold> getThreshold(@PathVariable int id) {

		return thresholdService.getThresholdById(id);
	}
	
	
	@PostMapping("/thresholds/add")
	public String save(@RequestBody Threshold threshold){
		return thresholdService.save(threshold);
	}
	
	@RequestMapping(value = "/thresholds/update/{id}", method = RequestMethod.PUT)
	public String updateThreshold(@PathVariable int id, @RequestBody Threshold threshold){
		return thresholdService.updateThreshold(id, threshold);
	}

	@RequestMapping(value = "/thresholds/delete/{id}", method = RequestMethod.DELETE)
	public String deleteThreshold(@PathVariable int id){
		return thresholdService.deleteThreshold(id);
	}
	
	
	@GetMapping("/thresholds/{id}/sensor")
	public SmartSensorResponse getSensorId(@PathVariable int id) {
		return thresholdService.getSensorId(id);
	}
	
	@GetMapping("/thresholds/{id}/user")
	public UserResponse getUserId(@PathVariable int id) {
		return thresholdService.getUserId(id);
	}
	
	@PostMapping("/thresholds/{id}/thresholdExceeded")
	public String ThresholdExceeded(@PathVariable int id) {
		return thresholdService.ThresholdExceeded(id);
	}
	
}