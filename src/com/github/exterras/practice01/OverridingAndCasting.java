package com.github.exterras.practice01;

class Am {
	void callme() {
		System.out.println("클래스 Am의 callme() 메소드 실행");
	}
}

class Bm extends Am {
	void callme() {
		System.out.println("클래스 Bm의 callme() 메소드 실행");
	}
}

class Cm extends Am {
	void callme() {
		System.out.println("클래스 Cm의 callme() 메소드 실행");
	}
}

public class OverridingAndCasting {
	public static void main(String args[]) {
		Am r = new Am();
		r.callme();
		r = new Bm();
		r.callme();
		r = new Cm();
		r.callme();
	}
}