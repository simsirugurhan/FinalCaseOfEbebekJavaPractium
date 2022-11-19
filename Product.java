package patikaStore;

public class Product {
	private int id;
	private Double unitPrice;
	private int discountRate;
	private int stockAmount;
	private String productName;
	private Company company;
	private String screenSize;

	public Product(int id, Double unitPrice, int discountRate, int stockAmount, String productName, Company company,
			String screenSize, String ram) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
		this.stockAmount = stockAmount;
		this.productName = productName;
		this.company = company;
		this.screenSize = screenSize;
		this.ram = ram;
	}

	private String ram;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

}
