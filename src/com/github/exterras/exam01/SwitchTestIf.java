package com.github.exterras.exam01;

import java.util.Scanner;

public class SwitchTestIf {
	public static void main(String[] args) {
	
		int month = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ش��ϴ� ���� ������ �˷��帳�ϴ�.(���ڸ�)");
		
		System.out.print("�Է� : ");
		
		try {
			month = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("�Է��� �߸��ϼ̽��ϴ�. 1~12 ������ ���ڸ� �Է��ϼ���.");
			return;
		}
		
		if(month >= 3 && month <= 5){
			System.out.println(month +" ���� ���Դϴ�.");
		} else if (month >= 6 && month <= 8){
			System.out.println(month +" ���� �����Դϴ�.");
		} else if (month >= 9 && month <= 11){
			System.out.println(month +" ���� �����Դϴ�.");
		} else if (month == 12 || (month >= 1 && month <= 2) ){
			System.out.println(month +" ���� �ܿ��Դϴ�.");
		} else {
			System.out.println("�Է��Ͻ� ���� ���� ���Դϴ�.");
		}
		
	}
}
