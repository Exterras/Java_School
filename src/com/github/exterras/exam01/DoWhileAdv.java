package com.github.exterras.exam01;

import java.util.Scanner;

public class DoWhileAdv {
	private static int choice;
	private static boolean flag;
	Scanner scanner = new Scanner(System.in);
	
	public void noticeFunc(){
		System.out.println("�ݺ��� ���� ����");
		System.out.println("1. While �ݺ���");
		System.out.println("2. Do - While �ݺ���");
		System.out.println("3. For �ݺ���");
		System.out.println("4. ����");
		System.out.println("�˰��� �ϴ� �޴��� �����Ͻÿ� (1~3)");
		choice = scanner.nextInt();
	}
	
	public void controllerFunc(){
		switch (choice) {
			case 1:
				System.out.println("1. While �ݺ���");
				System.out.println("������ ���� �˻��ϰ� ������ ���� ��� �ݺ� �κ��� �����ϴ� �ݺ���");
				System.out.println();
				break;
			case 2:
				System.out.println("2. Do - While �ݺ���");
				System.out.println("�ݺ� �κ��� ���� �����ϰ� ������ �˻��ϰ� �ּ� �ѹ��� ����Ǵ� �ݺ���");
				System.out.println();
				break;
			case 3:
				System.out.println("3. For �ݺ���");
				System.out.println("������ Ƚ����ŭ �ݺ� �κ��� �����ϴ� �ݺ���");
				System.out.println();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				flag = false;
				break;
			default:
				System.out.println("�޴� ������ �߸� �ϼ̽��ϴ�.");
				System.out.println();
				break;
		}
	}
	
	public static void main(String[] args) {
		
		DoWhileAdv adv = new DoWhileAdv();
		flag = true;
		
		while (flag) {
			adv.noticeFunc();
			adv.controllerFunc();
		}
	}
}
