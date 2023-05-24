package java13_OperlandEx;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        // 문제1
        // 다음 변수에 저장되어 있는 값이 짝수면 "짝수"를
        // 홀수면 "홀수"를 결과하는 3항 연산 식을 작성하세요.
        int a1 = 123;
        String s = (a1%2==0) ? "짝수" : "홀수";
        System.out.println(s);
        

        // 문제2
        // 다음 변수에 저장되어 있는 값을 십의 자리 이하를 버리는
        // 코드를 작성하여 출력한다.
        // 예) 421 -> 400
        int a2 = 421;
        int result2 = (a2/100)*100;
        System.out.println(result2);

        // 문제3
        // 다음 변수에 저장되어 있는 값을 각 자리별로 뜯어내어 출력한다.
        // 예) 123
        // 1
        // 2
        // 3
        int a3 = 123;
        int hundred = a3/100;
        int ten = (a3%100)/10;
        int one = a3%10;
        System.out.println(hundred);
        System.out.println(ten);
        System.out.println(one);
        


        // 문제4)
        // 주어진 화씨 온도를 섭씨 온도로 계산한다.
        // 섭씨온도 = 5 / 9 x (회씨온도 - 32)
        int a4 = 100;
        int result = (a4-32)/9*5;
        System.out.printf("섭씨온도 :  %d \n", result);


        // 문제5)
        // 다음에 주어진 대문자 알파벳을 소문자로 바꿔서 출력한다.
        // 대문자 A는 65이고, 소문자 a는 정수로 97이다.
        char a5 = 'C';
        char small_char = (char)(a5 + 32);
        System.out.println(small_char);

	}

}
