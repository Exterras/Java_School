package com.github.exterras.practice01;

class Ad1{
	int d1;
	int s;
	public Ad1(int _s1) {
		System.out.println("클래스 Ad1의 생성자 수행");
		this.s = _s1;
		this.d1 = this.s * this.s; 
	}
}

class Ad2 extends Ad1{
	int d2;
	int t;
	public Ad2(int _s1, int _t1) {
		super(_s1);
		System.out.println("클래스 Ad2의 생성자 수행");
		this.t = _t1;
		this.d2 = this.t * this.t;
	}
}

public class SuperTest3 {
	public static void main(String[] args) {
		int[] inputNum = {10, 20};
		
		Ad2 super2 = new Ad2(inputNum[0], inputNum[1]);
		System.out.println(inputNum[0] + "의 제곱은 " + super2.d1);
		System.out.println(inputNum[1] + "의 제곱은 " + super2.d2);
	}
}
