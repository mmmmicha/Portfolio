package com.project.bank;

import java.util.Scanner;

public class PassCompare extends Customer
{

	private static String temp;					//-- 임시적으로 비밀번호를 저장하기 위한 temp 변수 선언

	public void passCom()						//-- 비밀번호 비교 메소드
	{

		// Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);

		// 테스트 
		// System.out.println(super.selectC);

		if (super.selectC != 'Y' && super.selectC != 'y')	//-- 선택이 y가 아닌 경우 거래 지속(JuminCompar 클래스와 연결)
		{
			do												//-- 입력 비밀번호가 4자리가 맞을 때까지 반복
			{
				System.out.print("▷비밀번호를 입력해 주세요. (4자리): ");
				temp = sc.next();

				if (temp.length() !=4)
				{
					System.out.println("▷비밀번호를 다시 입력해주시기 바랍니다.\n");
				}

			}	
			while (temp.length() !=4); 

			if (temp.equals(super.getPass())==true)			//-- 입력받은 비밀번호와 기존의 저장된 비밀번호가 같으면 거래 지속
			{
				System.out.println("비밀번호가 확인 되었습니다.");
				super.selectC = 'y';						//-- 예금, 출금의 거래를 지속
			}

			do
			{
				if (temp.equals(super.getPass())==false)	//-- 입력받은 결과와 기존의 결과가 다르면 재 입력
				{
					System.out.print("▷비밀 번호가 틀렸습니다ㅠㅠ 다시 입력해 주세요. : ");
					temp = sc.next();						
				}
				super.selectC = 'y';
			}
			while (temp.equals(super.getPass())==false);
		}
		else
		{
			super.selectC = 'n';							//-- 예금, 출금의 거래를 중단
		}

		

	}// end passCom()

}// end class PassCompare