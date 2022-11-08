package valueObject;


public class SmartSensor{
	
	private int sensorId;
	private String productionHouse;
	private String type;
	private int value;
	
	
	public SmartSensor() {
		
	}
	
	public SmartSensor(int sensorId,String productionHouse, String type, int value) {
		this.setSensorId(sensorId);
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}