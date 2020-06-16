package com.project.ssangyong.bank;

import java.util.Scanner;

public class TongJang extends Customer
{

	private static String temp;


	public void gaeseol()	// 계좌 개설 메소드
	{
		try
		{
			System.out.println("\n ======= 계좌개설서비스 입니다♡ =======");
			System.out.printf("\n▷고객님의 핸드폰 번호 %s 로 계좌번호를 만드시겠어요?(Y/N) : ", super.getPhone());
			super.selectC = (char)System.in.read();
			System.in.skip(2);

			if (super.selectC != 'Y' && super.selectC != 'y')
			{
				System.out.println("\n▷계좌를 개설하실 수 없어요..ㅠㅠ");
				return;
			}
			super.setTongname(super.getPhone());
			System.out.println("\n▷▷고객님의 핸드폰 번호 ("+super.getTongname()+")로 계좌번호가 개설되었어요.^^\n");
			
			System.out.printf("▷▷현재 통장 잔고는 %,d원 입니다.\n", super.getTongjang());
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
	}// end gaeseol()

	

	public void check()		// 계좌 조회 메소드
	{
	  

	  Scanner sc = new Scanner (System.in);
	  do
	  {
		  System.out.print("▷금액을 조회하실 계좌번호를 입력 해주세요 : ");
		  temp = sc.next();

		  if (temp.equals(super.getPhone())==true)
		  {
			 System.out.printf("▷▷고객님 계좌 %s에 들어있는 잔액은 %,d ￦ 입니다\n",super.getPhone(), super.getTongjang());
		  }

	  
		 if (temp.equals(super.getPhone())==false)
		 {
			System.out.println("▷등록된 계좌가 없어요. 다시 입력해 주세요");
			
		 }
	  }
	  while (temp.equals(super.getPhone())==false);
	  
	}// end check()
}// end class Tongjang