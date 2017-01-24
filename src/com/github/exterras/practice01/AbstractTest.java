package com.github.exterras.practice01;

abstract class Shape {
	abstract void draw();

	abstract void computeArea(double a, double b);
}

class Circle extends Shape {
	void draw() {
		System.out.println("원을 그리는 기능");
	}

	void computeArea(double r1, double r2) {
		System.out.println("원의 넓이 : " + (3.14 * r1 * r2));
	}
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("사각형을 그리는 기능");
	}

	void computeArea(double h, double v) {
		System.out.println("사각형의 넓이 : " + (h * v));
	}
}

class Triangle extends Shape {
	void draw() {
		System.out.println("삼각형을 그리는 기능");
	}

	void computeArea(double a, double h) {
		System.out.println("삼각형의 넓이 : " + (a * h / 2));
	}
}

public class AbstractTest {
	public static void main(String args[]) {
		Circle c = new Circle();
		c.draw();
		c.computeArea(5.0, 5.0);
		Rectangle r = new Rectangle();
		r.draw();
		r.computeArea(5.0, 10.0);
		Triangle t = new Triangle();
		t.draw();
		t.computeArea(5.0, 10.0);
		System.out.println("==객체 형변환과 오버라이딩을 이용==");
		Shape s = new Circle();
		s.draw();
		s.computeArea(5.0, 5.0);
		s = new Rectangle();
		s.draw();
		s.computeArea(5.0, 10.0);
		s = new Triangle();
		s.draw();
		s.computeArea(5.0, 10.0);
	}
}