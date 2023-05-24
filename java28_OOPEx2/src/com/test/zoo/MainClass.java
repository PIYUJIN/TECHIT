package com.test.zoo;

import java.util.*;

import java.util.Scanner;

public class MainClass {
	// 동물원
    // 모든 클래스는 com.test.zoo 라는 패키지에 만들어준다.
    // 동물들의 특징은 다음과 같다.
    // 코끼리
    // 다리 : 4개, 코 : 길다, 몸 : 크다, 식사방법 : 코를 이용해 먹는다.
    // 사막여우
    // 다리 : 4개, 코 : 짧다, 몸 : 작다, 식사방법 : 손을 이용해 먹는다.
    // 캥거루
    // 다리 : 2개, 코 : 짧다, 몸 : 크다, 식사방법 : 나뭇잎을 뜯어 먹는다.
    // 다리, 코, 몸, 식사방법은 변수로 정의한다.
    // 각 동물은 자신의 정보를 출력하는 메서드를 가지고 있다.
    
    // 예시
    // 동물의 종류를 입력해주세요
    // 1. 코끼리, 2. 사막여우, 3. 캥거루, 0. 입력끝 : 1
    // 동물의 이름을 입력해주세요 : 맘모스
    // 위의 입력을 0을 입력할 때 까지 반복한다....
    // 0을 눌러 입력이 끝나면 모든 동물의 정보를 출력한다.
    // 타입 : 코끼리
    // 이름 : 맘모스
    // 다리 : 4개
    // 코 : 길다
    // 몸 : 크다
    // 식사방법 : 손을 이용해 먹는다.
    // .......
	
	// 입력 받기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		Animal [] animals = new Animal[100];
		int type;
		int i = 0;
		while (true) {
			System.out.println("동물의 종류를 입력해주세요");
			System.out.print("1. 코끼리, 2. 사막여우, 3.캥거루, 0. 입력끝 : ");
			type = scanner.nextInt();
			if (type == 0)
				break;
			System.out.print("동물의 이름을 입력해주세요 : ");
			String name = scanner.next();
			if (type == 1)
				animals[i] = new Elephant(name);
			else if (type == 2)
				animals[i] = new Fox(name);
			else if (type == 3)
				animals[i] = new Kangaroo(name);
			i += 1;
		}
	
		for (int idx = 0; idx < i; idx++) {
			animals[idx].printAnimalInfo();
		}
	}

}

class Animal {
	String type;
	String name;
	int legs;
	String nose;
	String body;
	String eat;
	
    // 타입 : 코끼리
    // 이름 : 맘모스
    // 다리 : 4개
    // 코 : 길다
    // 몸 : 크다
    // 식사방법 : 손을 이용해 먹는다.
	public void printAnimalInfo() {
		System.out.printf("타입 : %s\n", type);
		System.out.printf("이름 : %s\n", name);
		System.out.printf("다리 : %d개\n", legs);
		System.out.printf("코 : %s\n", nose);
		System.out.printf("몸 : %s\n", body);
		System.out.printf("식사방법 : %s\n", eat);
	}
}

class Elephant extends Animal {
	public Elephant(String name) {
		type = "코끼리";
		super.name = name;
		legs = 4;
		nose = "길다";
		body = "크다";
		eat = "코를 이용해 먹는다.";
	}
}

class Fox extends Animal {
    // 다리 : 4개, 코 : 짧다, 몸 : 작다, 식사방법 : 손을 이용해 먹는다.
	public Fox(String name) {
		type = "사막여우";
		super.name = name;
		legs = 4;
		nose = "짧다";
		body = "작다";
		eat = "손을 이용해 먹는다.";
	}
}

class Kangaroo extends Animal {
    // 다리 : 2개, 코 : 짧다, 몸 : 크다, 식사방법 : 나뭇잎을 뜯어 먹는다.
	public Kangaroo(String name) {
		type = "캥거루";
		super.name = name;
		legs = 2;
		nose = "짧다";
		body = "크다";
		eat = "나뭇잎을 뜯어 먹는다.";
	}
}
