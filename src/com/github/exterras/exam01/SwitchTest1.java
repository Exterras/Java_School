package com.github.exterras.exam01;

import java.util.Scanner;

public class SwitchTest1 {
	public static void main(String[] args) {
		
		int month = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("해당하는 월의 계절을 알려드립니다.(숫자만)");
		
		System.out.print("입력 : ");
		
		try {
			month = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("입력을 잘못하셨습니다. 1~12 사이의 숫자만 입력하세요.");
			return;
		}
		
		switch (month) {
		// 봄
		case 3:
		case 4:
		case 5:
			System.out.println(month +" 월은 봄입니다.");
		break;
		
		// 여름-
		case 6:
		case 7:
		case 8:
			System.out.println(month +" 월은 여름입니다.");
		break;
		
		// 가을
		case 9:
		case 10:
		case 11:
			System.out.println(month +" 월은 가을입니다.");
		break;
		
		// 겨울
		case 12:
		case 1:
		case 2:
			System.out.println(month +" 월은 겨울입니다.");
		break;

		default:
			System.out.println("입력하신 월은 없는 월입니다.");
			break;
		}
	}
}
