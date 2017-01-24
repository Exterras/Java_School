package com.github.exterras.practice01;

class AAA {
	int i;
	int j;

	void setij(int x, int y) {
		i = x;
		j = y;
	}
}

class BBB extends AAA {
	int total;

	void sum() {
		total = i + j;
	}
}

public class MethodInheritanceTest {
	public static void main(String args[]) {
		BBB subOb = new BBB();
		subOb.setij(10, 12);
		subOb.sum();
		System.out.println("두 수의 합계는 : " + subOb.total);
	}
}