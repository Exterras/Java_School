package com.github.exterras.exam01;

public class Star {
	public static void main(String[] args) {
	
		int lineNum = 5;
		int maxStar = 5;
		
		for (int i = 0; i < lineNum; i++) {
			for (int j = i; j >= 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < lineNum; i++) {
			for (int j = i; j < maxStar; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < lineNum; i++) {
			for (int j = 0; j < (maxStar-1)-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < lineNum; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < maxStar-i; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
}