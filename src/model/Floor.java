package model;

import java.util.LinkedList;
import java.util.List;

public class Floor{
	
	List<ParkArea> areaList = new LinkedList<ParkArea>(); // 주차관리는 삭제가 빈번하게 일어나기 때문에 LinkedList가 적합

	public Floor(int floor) { // 각 층의 주차공간에 번호 매기기
		int areaNum = 0;
		if (floor == 1) {
			areaNum = 25;
		} else if (floor == 2) {
			areaNum = 10;
		} else if (floor == 3) {
			areaNum = 15;
		}
		for (int i = 0; i < areaNum; i++) {
			areaList.add(new ParkArea((floor + "-" + (i + 1))));
		}
	}

	public void park() throws InterruptedException { // 주차공간을 시각적으로 주차X : 주차 불가능, 주차O : 주차 가능으로 표현
		Car car = new Car("");
		parking(car);
	}

	public ParkArea parking(Car car) { // 주차공간에 주차
		ParkArea area = searchArea();
		area.inCar(car);
		return area;
	}

	public ParkArea searchArea() { // 주차공간에 차가 없으면 area형태로 반환, 차가있으면 Null
		for (ParkArea parkArea : areaList) {
			if (parkArea.getCar() == false) {
				return parkArea;
			}
		}
		return null;
	}

	public void check() { // 주차 공간에 차가있다 => true면 주차X, 차가 없다 => false면 주차O 출력
		for (int i = 0; i < areaList.size(); i++) {
			ParkArea area = getParkArea(i);
			boolean getCar = area.getCar();
			System.out.print(area.toString() + "  ");
			if (getCar == true) {
				System.out.print(" 주차X  |");
			} else {
				System.out.print(" 주차O  |");
			}
		}
		System.out.println("");
	}

	model.ParkArea getParkArea(int i) { // 주차 리스트 가져오는 용도
		return areaList.get(i);
	}
}
