package model;

public interface ParkTower {

	public static final String type = "타워";

	public abstract void parkStart() throws InterruptedException; // 주차

	public abstract void parkCheck(); // 주차 현황

	public abstract void parkOut(); // 차 빼기

	public String getTowerName(); // 타워이름 가져오기
}
