package com.github.exterras.exam01;

import java.util.Scanner;

public class DoWhileTest2 {
	public static void main(String[] args) {
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		do {
			System.out.println("반복문 종류 설명");
			System.out.println("1. While 반복문");
			System.out.println("2. Do - While 반복문");
			System.out.println("3. For 반복문");
			System.out.println("알고자 하는 메뉴를 선택하시오 (1~3)");
			
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("입력을 잘못하셨습니다. 1~3 사이의 숫자만 입력하세요.");
				break;
			}
			
		} while (choice < 1 || choice > 3);
		
		switch (choice) {
		case 1:
			System.out.println("1. While 반복문");
			System.out.println("조건을 먼저 검사하고 조건이 참일 경우 반복 부분을 수행하는 반복문");
			break;
		case 2:
			System.out.println("2. Do - While 반복문");
			System.out.println("반복 부분을 먼저 수행하고 조건을 검사하고 최소 한번은 수행되는 반복문");
			break;
		case 3:
			System.out.println("3. For 반복문");
			System.out.println("지정된 횟수만큼 반복 부분을 수행하는 반복문");
			break;
		default:
			break;
		}
	}
}