package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection= "thresholds")
public class Threshold{
	
	@Id
	private int thresholdId;
	private int sensorId;
	private int userId;
	private float value;
	private ThresholdType type;
	
	public Threshold() {
		
	}
	
	public Threshold(int thresholdId, int sensorId, int userId, float value, ThresholdType type) {
		this.setThresholdId(thresholdId);
		this.setSensorId(sensorId);
		this.setUserId(userId);
		this.setValue(value);
		this.setType(type);
		
	}
	
	public Threshold( int sensorId, int userId, float value, ThresholdType type) {
		this.setSensorId(sensorId);
		this.setUserId(userId);
		this.setValue(value);
		this.setType(type);
		
	}
	
	public int getThresholdId() {
		return thresholdId;
	}
	
	public void setThresholdId(int thresholdId) {
		this.thresholdId=thresholdId;
	}
	
	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value=value;
	}
	
	public ThresholdType getType() {
		return type;
	}
	
	public void setType(ThresholdType type) {
		this.type=type;
	}


}