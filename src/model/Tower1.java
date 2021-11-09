package model;

import java.util.Scanner;

public class Tower1 implements ParkTower{

	String towerName = "기쁨타워";

	int cnt1 = 0; // 1층 주차 공간 번호
	int cnt2 = 0; // 2층 주차 공간 번호
	int cnt3 = 0; // 3층 주차 공간 번호
	Floor floor3 = new Floor(3);
	Floor floor2 = new Floor(2);
	Floor floor1 = new Floor(1);

	@Override
	public void parkStart() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.print("주차하려는 층을 입력하세요 : ");
		int flr = sc.nextInt();
		if (flr == 1) {
			cnt1++;
			System.out.println(flr + "층에 " + cnt1 + "번에 주차가 되었습니다.");
			floor1.park();
		} else if (flr == 2) {
			cnt2++;
			System.out.println(flr + "층에 " + cnt2 + "번에 주차가 되었습니다.");
			floor2.park();
		} else if (flr == 3) {
			cnt3++;
			System.out.println(flr + "층에 " + cnt3 + "번에 주차가 되었습니다.");
			floor3.park();
		} else {
			System.out.println("잘못된 층입니다. 다시 시작하여 주십시오.");
		}
	}

	@Override
	public void parkCheck() {
		floor3.check();
		floor2.check();
		floor1.check();
	}

	@Override
	public void parkOut() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주차한 곳의 층을 입력하세요 : ");
		int flr = sc.nextInt();
		System.out.println();
		System.out.print("주차한 곳의 번호를 입력하세요 : ");
		int rm = sc.nextInt() - 1;
		if (flr == 1) {
			ParkArea area = floor1.getParkArea(rm);
			if (area.getCar()) {
				area.outCar();
			}
		} else if (flr == 2) {
			ParkArea area = floor2.getParkArea(rm);
			if (area.getCar()) {
				area.outCar();
			}
		} else if (flr == 3) {
			ParkArea area = floor3.getParkArea(rm);
			if (area.getCar()) {
				area.outCar();
			}
		} else {
			System.out.println("없는 층입니다.");
		}
	}

	public String getTowerName() {
		return towerName;
	}
}
