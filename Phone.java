package patikaStore;

public class Phone extends Product {

	private String[] memory;

	private String batteryPower;

	private String[] color;

	public Phone(int id, Double unitPrice, int discountRate, int stockAmount, String productName, Company company,
			String screenSize, String ram, String[] memory, String batteryPower, String[] color) {
		super(id, unitPrice, discountRate, stockAmount, productName, company, screenSize, ram);
		this.memory = memory;
		this.batteryPower = batteryPower;
		this.color = color;
	}

	public String[] getMemory() {
		return memory;
	}

	public void setMemory(String[] memory) {
		this.memory = memory;
	}

	public String getBatteryPower() {
		return batteryPower;
	}

	public void setBatteryPower(String batteryPower) {
		this.batteryPower = batteryPower;
	}

	public String[] getColor() {
		return color;
	}

	public void setColor(String[] color) {
		this.color = color;
	}

}
