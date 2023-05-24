package assignment01;

public class Assignment03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 제출과제

		// 문제3)
		// 방정식 2x + 4y = 10 에서 가능한 모든 x, y 의 조합을 출력하세요
		// 단, x는 0 ~ 10, y는 0 ~ 10 까지 이다.

		System.out.println("--------------------");
		System.out.println("문제 3");

		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if ((2 * i + 4 * j) == 10) {
					System.out.println(i + " " + j);
				}
			}
		}
	}

}
