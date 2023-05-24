package assignment01;

public class Assignment01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 제출과제

        // 문제1)
        // 1 + (1 + 2) + (1 + 2 + 3) + (1 + 2 + 3 + 4)+ (1 + 2 + 3 + 4 + 5) + ... + (1 + 2 + ... + 9 + 10)의 총 합을 출력하세요
		
		int result = 0;
		int sum = 0;
		for (int i=1; i<=10; i++) {
			result = result + i;
//			System.out.println(result);
			for (int j=1; j<i; j++) {
				sum = sum + j;
//				System.out.println(sum);
//				System.out.println(result+sum);
			}
		}
		int total = result + sum;
		System.out.println("문제 1 : " + total);

	}

}
