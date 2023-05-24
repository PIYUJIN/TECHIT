package assignment01;

public class Assignment02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 제출과제
		
        // 문제2)
        // 1 + (-2) + 3 + (-4) + 5 + (-6) + 7 + (-8) + ...
        // 이런식으로 더했을 때 몇 까지 더해야지 총 합이 100 이상이 되는지 구하세요.

		int sum_hund =0;
		int x = 0;
		for (int i=0; sum_hund<100; i++) {
			if(i%2==0) {
				sum_hund -= i;
			}
			else {
				sum_hund += i;
			}
			x = i;
		}
		System.out.println("문제 2 : " + x);
	}

}
