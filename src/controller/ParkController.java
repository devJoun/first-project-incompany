package controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import model.ParkArea;
import model.ParkTower;
import model.Tower1;

public class ParkController {

	public void ParkController() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("주차하려는 타워를 선택해주세요.");
		System.out.println("1:기쁨타워  2:ㅁㅁ타워");
		int tower = sc.nextInt();

		if (tower == 1) {
			ParkTower tower1 = new Tower1();
			System.out.println(tower1.getTowerName() + "에 오신것을 환영합니다.");
			while (true) {
				System.out.println("1:주차시작  2:주차현황  3:차빼기  4:종료");
				int choice = sc.nextInt();
				if (choice == 1) {
					tower1.parkStart();
				} else if (choice == 2) {
					tower1.parkCheck();
				} else if (choice == 3) {
					tower1.parkOut();
				} else {
					System.out.println("종료합니다.");
					break;
				}
			}
		} else if (tower == 2) {
			System.out.println("ㅁㅁ타워는 공사중입니다.");
		} else {
			System.out.println("아직 지어지지 않은 주차 타워에요. 다시 검색해주세요.");
		}
	}
}


