package com.github.exterras.exam01;

import java.util.Scanner;

public class DoWhileAdv {
	private String choice;
	private static boolean flag;
	private Scanner scanner = new Scanner(System.in);
	
	public void noticeFunc(){
		System.out.println("반복문 종류 설명");
		System.out.println("1. While 반복문");
		System.out.println("2. Do - While 반복문");
		System.out.println("3. For 반복문");
		System.out.println("4. 종료");
		System.out.println("알고자 하는 메뉴를 선택하시오 (1~4)");
		
		try {
			choice = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("입력을 잘못하셨습니다. 1~4 사이의 숫자만 입력하세요.");
		}
	}
	
	public void controllerFunc(){
		switch (choice) {
			case "1":
				System.out.println("1. While 반복문");
				System.out.println("조건을 먼저 검사하고 조건이 참일 경우 반복 부분을 수행하는 반복문");
				System.out.println();
				break;
			case "2":
				System.out.println("2. Do - While 반복문");
				System.out.println("반복 부분을 먼저 수행하고 조건을 검사하고 최소 한번은 수행되는 반복문");
				System.out.println();
				break;
			case "3":
				System.out.println("3. For 반복문");
				System.out.println("지정된 횟수만큼 반복 부분을 수행하는 반복문");
				System.out.println();
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				flag = true;
				break;
			default:
				System.out.println("메뉴 선택을 잘못 하셨습니다.");
				System.out.println();
				break;
		}
	}
	
	public static void main(String[] args) {
		
		DoWhileAdv adv = new DoWhileAdv();
		while (!flag) {
			adv.noticeFunc();
			adv.controllerFunc();
		}
	}
}