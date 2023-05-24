package com.test.main;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		학생 3명의 데이터를 입력받는다.
//		이름, 학년, 국어, 영어, 수학 점수를 받는다.
//		정보 입력이 완료되면 다음과 같이 출력되게 한다.
//		-------------------------------------------
//		이름 : 홍길동
//		학년 : 1
//		국어 : 100
//		영어 : 80
//		수학 : 70
//
//		이름 : 홍길동
//		학년 : 1
//		국어 : 100
//		영어 : 80
//		수학 : 70
//
//		이름 : 홍길동
//		학년 : 1
//		국어 : 100
//		영어 : 80
//		수학 : 70
//
//		과목별 총점
//		국어 : 300
//		영어 : 400
//		수학 : 500
//
//		과목별 평균
//		국어 : 80
//		영어 : 70
//		수학 : 60
		
		Student s1 = new Student();
		s1.studentMethod();
//		System.out.println();
	
		Student s2 = new Student();
		s2.studentMethod();
//		System.out.println();
		
		Student s3 = new Student();
		s3.studentMethod();
//		System.out.println();
		
		int kor_total = s1.kor + s2.kor + s3.kor;
		int kor_avg = kor_total / 3;
		
		int eng_total = s1.eng + s2.eng + s3.eng;
		int eng_avg = eng_total / 3;
		
		int math_total = s1.math + s2.math + s3.math;
		int math_avg = math_total / 3;
		
		s1.PrintMethod();
		s2.PrintMethod();
		s3.PrintMethod();
		System.out.println("과목별 총점");
		System.out.println("국어 : " + kor_total);
		System.out.println("영어 : " + eng_total);
		System.out.println("수학 : " + math_total);
		System.out.println();
		System.out.println("과목별 평균");
		System.out.println("국어 : " + kor_avg);
		System.out.println("영어 : " + eng_avg);
		System.out.println("수학 : " + math_avg);
		
	}

}

class Student{

	String name;
	int grade;
	int kor;
	int eng;
	int math;

	public void studentMethod() {
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요 : ");
		name = scan.next();
		
		System.out.print("학년을 입력해주세요 : ");
		grade = scan.nextInt();
		
		System.out.print("국어 점수를 입력해주세요 : ");
		kor = scan.nextInt();
		
		System.out.print("영어 점수를 입력해주세요 : ");
		eng = scan.nextInt();
		
		System.out.print("수학 점수를 입력해주세요 : ");
		math = scan.nextInt();
	}
	
	public void PrintMethod() {
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println();
	}
}

