package com.github.exterras.exam01;

import java.util.Scanner;

public class SwitchTest1 {
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
		
		switch (month) {
		// ��
		case 3:
		case 4:
		case 5:
			System.out.println(month +" ���� ���Դϴ�.");
		break;
		
		// ����-
		case 6:
		case 7:
		case 8:
			System.out.println(month +" ���� �����Դϴ�.");
		break;
		
		// ����
		case 9:
		case 10:
		case 11:
			System.out.println(month +" ���� �����Դϴ�.");
		break;
		
		// �ܿ�
		case 12:
		case 1:
		case 2:
			System.out.println(month +" ���� �ܿ��Դϴ�.");
		break;

		default:
			System.out.println("�Է��Ͻ� ���� ���� ���Դϴ�.");
			break;
		}
	}
}
