package com.github.exterras.practice01;

class An{
	int i, j;
}

class Bn extends An{
	int k;
}

class Cn extends Bn{
	int m;
}

public class InstanceofAndCasting {
	public static void main(String[] args) {
		An a = new An();
		Bn b = new Bn();
		Cn c = new Cn();
		
		if (a instanceof An) { System.out.println("a는 A 클래스의 객체"); }
		if (b instanceof Bn) { System.out.println("b는 B 클래스의 객체"); }
		if (c instanceof Cn) { System.out.println("c는 C 클래스의 객체"); }
		if (c instanceof An) { System.out.println("c는 A 클래스의 객체"); }
		if (a instanceof Cn) { System.out.println("a는 C 클래스의 객체"); }
		else { System.out.println("a는 C 클래스의 객체가 아님 : 형변환 불"); }
	}
}
