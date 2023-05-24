// 6팀
// 임보성, 피유진, 오준용

package assignment02;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//다음 조건에 맞는 자바 프로그램을 만들어주세요
//- 학생의 정보를 관리하는 프로그램을 작성합니다.
//- 학생의 정보는 이름, 학년, 국어, 영어, 수학 으로 구성됩니다.
//- 프로그램을 시작하면 다음 메뉴가 나타납니다.
//1. 학생정보 입력
//2. 학생정보 검색
//3. 과목별 총점 출력
//4. 과목별 평균 출력
//5. 종료
//
//- 메뉴에서 1을 입력하면 학생정보를 입력받습니다.
//- 학생 한명의 정보를 받으면 메뉴 화면이 나오도록 합니다.
//- 학생정보 입력화면 구성은 자유입니다.
//
//- 메뉴에서 2를 입력하면 학생 이름을 이름받습니다.
//- 입력받은 이름의 학생의 정보를 출력합니다.
//- 만약 이름에 "모두" 를 입력하면 모든 학생의 정보가 
//- 출력 되도록 한다
//- 동명의 이름의 학생이 어려명일 경우 모두 보여줍니다
//- 이름 입력화면과 정보 출력화면은 자유롭게 구성합니다.
//
//- 메뉴에서 3을 입력하면 각 과목별 총점을 출력합니다.
//- 출력 화면 구성은 자유입니다.
//
//- 메뉴에서 4를 입력하면 각 과목별 평균을 출력합니다.
//- 출력 화면 구성은 자유입니다.
//
//- 메뉴에서 5를 입력하면 프로그램을 종료합니다.
//
//- 입력한 학생의 정보는 모두 파일로 저장해주시고 데이터도 파일에서 읽어와주세요
//
//- 하나의 java 파일에 작성해주세요
//- 작성한 java 파일을 제출해주세요
//- 자바 파일의 이름은 자유
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// - 학생의 정보는 이름, 학년, 국어, 영어, 수학 으로 구성됩니다.
		// - 프로그램을 시작하면 다음 메뉴가 나타납니다.
		// 1. 학생정보 입력
		// 2. 학생정보 검색
		// 3. 과목별 총점 출력
		// 4. 과목별 평균 출력
		// 5. 종료

		try {
			FileInputStream fis = new FileInputStream("students.txt");
			fis.close();
		} catch (FileNotFoundException e) {
			makeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		StudentInfoManager studentInfoManager = new StudentInfoManager();

		int task = 5;

		do {

			task = studentInfoManager.inputSelectTask();

			if (task != 5) {

				studentInfoManager.implementSelectTask(task);
			}
		} while (task != 5);
	}

	public static void makeFile() {
		try {
			FileOutputStream fos = new FileOutputStream("students.txt");
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class StudentInfoManager {
	// 스캐너
	private Scanner scanner;

	private ArrayList<Student> studentList;

	public StudentInfoManager() {
		this.scanner = new Scanner(System.in);
	}

	// 메뉴 선택 입력 메서드
	public int inputSelectTask() {
		System.out.println("1. 학생정보 입력");
		System.out.println("2. 학생정보 검색");
		System.out.println("3. 과목별 총점 출력");
		System.out.println("4. 과목별 평균 출력");
		System.out.println("5. 종료");
		System.out.print("선택 : ");
		int task = scanner.nextInt();
		return task;
	}

	// 선택한 작업 실행 메서드
	public void implementSelectTask(int task) {
		switch (task) {
		case 1:
			inputStudentInfo();
			break;
		case 2:
			searchStudentInfo();
			break;
		case 3:
			printTotalScore();
			break;
		case 4:
			printAverage();
			break;
		}
	}

	// - 학생의 정보는 이름, 학년, 국어, 영어, 수학 으로 구성됩니다.
	// - 입력한 학생의 정보는 모두 파일로 저장해주시고 데이터도 파일에서 읽어와주세요
	//
	// - 하나의 java 파일에 작성해주세요
	// - 작성한 java 파일을 제출해주세요
	// - 자바 파일의 이름은 자유

	// 1. 학생정보 입력
	// - 메뉴에서 1을 입력하면 학생정보를 입력받습니다.
	// - 학생 한명의 정보를 받으면 메뉴 화면이 나오도록 합니다.
	// - 학생정보 입력화면 구성은 자유입니다.
	public void inputStudentInfo() {
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("학년 : ");
		int grade = scanner.nextInt();
		System.out.print("국어 : ");
		int korean = scanner.nextInt();
		System.out.print("영어 : ");
		int english = scanner.nextInt();
		System.out.print("수학 : ");
		int math = scanner.nextInt();

		try {
			loadData();

			Student student = new Student(name, grade, korean, english, math);

			if (studentList == null) {
				studentList = new ArrayList<Student>();
			}
			studentList.add(student);
			// 기본 스트림
			FileOutputStream fos = new FileOutputStream("students.txt");
			// 객체 출력 스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// 객체를 쓴다.
			oos.writeObject(studentList);

			oos.flush();
			oos.close();
			fos.close();

			studentList.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. 학생정보 검색
	// - 메뉴에서 2를 입력하면 학생 이름을 이름받습니다.
	// - 입력받은 이름의 학생의 정보를 출력합니다.
	// - 만약 이름에 "모두" 를 입력하면 모든 학생의 정보가
	// - 출력 되도록 한다
	// - 동명의 이름의 학생이 어려명일 경우 모두 보여줍니다
	// - 이름 입력화면과 정보 출력화면은 자유롭게 구성합니다.
	public void searchStudentInfo() {
		loadData();

		System.out.print("학생 이름 : ");
		String searchName = scanner.next();

		Boolean allFlag = false;
		if (searchName.equals("모두")) {
			allFlag = true;
		}

		for (Student student : studentList) {
			if (allFlag || student.name.equals(searchName)) {
				student.printData();
			}
		}

		studentList.clear();
	}

	// 3. 과목별 총점 출력
	// - 메뉴에서 3을 입력하면 각 과목별 총점을 출력합니다.
	// - 출력 화면 구성은 자유입니다.
	public void printTotalScore() {
		loadData();

		int totalKorean = 0, totalEnglish = 0, totalMath = 0;
		for (Student student : studentList) {
			totalKorean += student.korean;
			totalEnglish += student.english;
			totalMath += student.math;
		}

		System.out.printf("국어 총점 : %d\n", totalKorean);
		System.out.printf("영어 총점 : %d\n", totalEnglish);
		System.out.printf("수학 총점 : %d\n", totalMath);
		System.out.println();
		
		studentList.clear();
	}

	// 4. 과목별 평균 출력
	// - 메뉴에서 4를 입력하면 각 과목별 평균을 출력합니다.
	// - 출력 화면 구성은 자유입니다.
	public void printAverage() {
		loadData();

		int studentNumber = 0, totalKorean = 0, totalEnglish = 0, totalMath = 0;
		for (Student student : studentList) {
			studentNumber += 1;
			totalKorean += student.korean;
			totalEnglish += student.english;
			totalMath += student.math;
		}

		System.out.printf("국어 평균 : %d\n", totalKorean / studentNumber);
		System.out.printf("영어 평균 : %d\n", totalEnglish / studentNumber);
		System.out.printf("수학 평균 : %d\n", totalMath / studentNumber);
		System.out.println();
		
		studentList.clear();
	}

	// 학생 정보 읽어오는 메서드
	public void loadData() {
		try {
			// 기본 스트림 생성
			FileInputStream fis = new FileInputStream("students.txt");
			// 객체 읽기 스트림
			ObjectInputStream ois = new ObjectInputStream(fis);

			// 객체를 복원한다.
			studentList = (ArrayList<Student>) ois.readObject();

			ois.close();
			fis.close();
		} catch (EOFException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Student implements Serializable {

	String name;
	int grade;
	int korean;
	int english;
	int math;

	public Student(String name, int grade, int korean, int english, int math) {
		this.name = name;
		this.grade = grade;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public void printData() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("학년 : %d\n", grade);
		System.out.printf("국어 : %d\n", korean);
		System.out.printf("영어 : %d\n", english);
		System.out.printf("수학 : %d\n", math);
		System.out.println();
	}
}