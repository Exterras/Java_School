package com.github.exterras.practice01;

class A1 {
	double d1;

	A1() {
		System.out.println("클래스 A1의 생성자 수행");
		d1 = 10 * 10;
	}
}

class A2 extends A1 {
	double d2;

	A2() {
		System.out.println("클래스 A2의 생성자 수행");
		d2 = 10 * 10 * 10;
	}
}

class A3 extends A2 {
	double d3;

	A3() {
		System.out.println("클래스 A3의 생성자 수행");
		d3 = 10 * 10 * 10 * 10;
	}
}

class SuperTest2 {
	public static void main(String args[]) {
		A3 super1 = new A3();
		System.out.println("10의 2제곱 : " + super1.d1);
		System.out.println("10의 3제곱 : " + super1.d2);
		System.out.println("10의 4제곱 : " + super1.d3);
	}
}