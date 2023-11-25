package com.hostmdy.model;

public class Car {
	
	private Long id;
	private String name;
	private String brand;
	private String model;
	private Double price;
	private Integer mileage;
	private String engine;
	private Integer horsepower;
	private String license;
	private String features;
	private Long image_id;
	private String front;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(Long id, String name, String brand, String model, Double price, Integer mileage, String engine,
			Integer horsepower, String license, String features, String front) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.engine = engine;
		this.horsepower = horsepower;
		this.license = license;
		this.features = features;
		this.front = front;
	}

	public Car(Long id, String name, String brand, String model, Double price, Integer mileage, String engine,
			Integer horsepower, String license, String features) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.engine = engine;
		this.horsepower = horsepower;
		this.license = license;
		this.features = features;
	}

	public Car(String name, String brand, String model, Double price, Integer mileage, String engine,
			Integer horsepower, String license, String features, Long image_id) {
		super();
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.engine = engine;
		this.horsepower = horsepower;
		this.license = license;
		this.features = features;
		this.image_id = image_id;
	}

	public Car(Long id, String name, String brand, String model, Double price, Integer mileage, String engine,
			Integer horsepower, String license, String features, Long image_id) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.engine = engine;
		this.horsepower = horsepower;
		this.license = license;
		this.features = features;
		this.image_id = image_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public Integer getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public Long getImage_id() {
		return image_id;
	}

	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", mileage=" + mileage + ", engine=" + engine + ", horsepower=" + horsepower + ", license=" + license
				+ ", features=" + features + ", image_id=" + image_id + "]";
	}
	
}
