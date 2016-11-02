package com.github.exterras.exam01;

public class WhileTest1 {
	public static void main(String[] args) {
		int hap = 0;
		int count = 1;
		
		while (count <= 10) {
			hap += count;
			count++;
		}
		
		// for문 사용
		/* for(int count = 1; count <= 10; count++){
		 * 	hap += count;
		 * }
		*/
		
		System.out.println("1부터 10까지의 합은"+hap+"입니다.");
	}
}