package com.github.exterras.exam01;

import java.util.Scanner;

public class DoWhileTest2 {
	public static void main(String[] args) {
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		do {
			System.out.println("�ݺ��� ���� ����");
			System.out.println("1. While �ݺ���");
			System.out.println("2. Do - While �ݺ���");
			System.out.println("3. For �ݺ���");
			System.out.println("�˰��� �ϴ� �޴��� �����Ͻÿ� (1~3)");
			
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("�Է��� �߸��ϼ̽��ϴ�. 1~12 ������ ���ڸ� �Է��ϼ���.");
				break;
			}
			
		} while (choice < 1 || choice > 3);
		
		switch (choice) {
		case 1:
			System.out.println("1. While �ݺ���");
			System.out.println("������ ���� �˻��ϰ� ������ ���� ��� �ݺ� �κ��� �����ϴ� �ݺ���");
			break;
		case 2:
			System.out.println("2. Do - While �ݺ���");
			System.out.println("�ݺ� �κ��� ���� �����ϰ� ������ �˻��ϰ� �ּ� �ѹ��� ����Ǵ� �ݺ���");
			break;
		case 3:
			System.out.println("3. For �ݺ���");
			System.out.println("������ Ƚ����ŭ �ݺ� �κ��� �����ϴ� �ݺ���");
			break;
		default:
			break;
		}
	}
}
