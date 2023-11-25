package com.hostmdy.model;

public class Images {
	
	private Long id;
	private String front;
	private String back;
	private String left;
	private String right;
	private String front_interior;
	private String back_interior;
	private String engine;
	
	public Images() {
		// TODO Auto-generated constructor stub
	}

	public Images(String front) {
		super();
		this.front = front;
	}

	public Images(String front, String back, String left, String right, String front_interior, String back_interior,
			String engine) {
		super();
		this.front = front;
		this.back = back;
		this.left = left;
		this.right = right;
		this.front_interior = front_interior;
		this.back_interior = back_interior;
		this.engine = engine;
	}

	public Images(Long id, String front, String back, String left, String right, String front_interior,
			String back_interior, String engine) {
		super();
		this.id = id;
		this.front = front;
		this.back = back;
		this.left = left;
		this.right = right;
		this.front_interior = front_interior;
		this.back_interior = back_interior;
		this.engine = engine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getFront_interior() {
		return front_interior;
	}

	public void setFront_interior(String front_interior) {
		this.front_interior = front_interior;
	}

	public String getBack_interior() {
		return back_interior;
	}

	public void setBack_interior(String back_interior) {
		this.back_interior = back_interior;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", front=" + front + ", back=" + back + ", left=" + left + ", right=" + right
				+ ", front_interior=" + front_interior + ", back_interior=" + back_interior + ", engine=" + engine + "]";
	}
	
}
