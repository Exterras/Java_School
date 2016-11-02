package com.github.exterras.exam01;

public class WhileTest3 {
	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		
		int initI = i;
		int initJ = j;
		
		while(++i < --j){
			
		};
		
		System.out.println(initI+" 와 "+initJ+"의 중간값은 "+i+" 입니다.");
	}
}	