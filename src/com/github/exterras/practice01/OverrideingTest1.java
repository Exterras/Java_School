package com.github.exterras.practice01;

class Da {
	void show(String _str){
		System.out.println("상위 클래스의 메소드 show(String _str) 수행 : " + _str);
	}
}

class Db extends Da{
	void show(){
		System.out.println("하위 클래스의 메소드 show() 수행 : ");
	}
}

public class OverrideingTest1 {
	public static void main(String[] args) {
		Db over = new Db();
		over.show("알기 쉽게 해설한 자바");
		over.show();
	}
}
