package patikaStore;

public class Notebook extends Product {

	private String memory;

	public Notebook(int id, Double unitPrice, int discountRate, int stockAmount, String productName, Company company,
			String screenSize, String ram, String memory) {
		super(id, unitPrice, discountRate, stockAmount, productName, company, screenSize, ram);
		this.memory = memory;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
	
}
