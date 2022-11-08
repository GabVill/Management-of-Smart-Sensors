package valueObject;


import models.Threshold;

public class SmartSensorResponse {
	
	private Threshold threshold;
	private SmartSensor smartSensor;
	
	public Threshold getThreshold() {
		return threshold;
	}
	
	public void setThreshold(Threshold threshold) {
		this.threshold = threshold;
	}
	
	public SmartSensor getSmartSensor() {
		return smartSensor;
	}
	
	public void setSmartSensor(SmartSensor smartSensor) {
		this.smartSensor = smartSensor;
	}

}