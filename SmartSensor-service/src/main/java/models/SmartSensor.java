package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "smart sensors")
public class SmartSensor{
	@Id
	private int sensorId;
	private String productionHouse;
	private String type;
	private float value;
	
	
	public SmartSensor() {
		
	}
	
	public SmartSensor(int sensorId,String productionHouse, String type, float value) {
		this.setSensorId(sensorId);
		this.setProductionHouse(productionHouse);
		this.setType(type);
		this.setValue(value);
	}
	
	public SmartSensor(String productionHouse, String type, float value) {
		this.setProductionHouse(productionHouse);
		this.setType(type);
		this.setValue(value);
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public String getProductionHouse() {
		return productionHouse;
	}

	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
}