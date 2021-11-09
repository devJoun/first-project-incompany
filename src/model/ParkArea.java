package model;

public class ParkArea {
	private String area; // 주차 공간
	
	Car car = null;
	
	public ParkArea(String area) {
		this.area = area;
	}
	
	public Car inCar(Car car) {
		this.car = car;
		return this.car;
	}

	public void outCar() {
		this.car = null;
	}

	public boolean getCar() { 
		if (car == null)
			return false;
		return true;
	}

	@Override
	public String toString() { 
		return area;

	}

}
