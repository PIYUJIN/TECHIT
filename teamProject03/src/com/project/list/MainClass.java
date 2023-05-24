package com.project.list;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Factory 객체 생성한다.
        Factory factory = new Factory();
        
        // 자동차 종류
        int carType = 0;
        
        do {
            // 자동자 종류를 입력받는다.
            carType = factory.inputCarType();
            
            if(carType != 0) {
                // 자동차 정보를 입력받는다.
                factory.inputCarInfo(carType);
            }
        } while(carType != 0);
        
        factory.printCarInfo();
	}

}


