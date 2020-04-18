package com.project.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WhatKind extends Customer
{

	public void whatKind()
	{
		// BufferedReader 인스턴스 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 예금 인스턴스 생성
		Yegum yg = new Yegum();
		// 출금 인스턴스 생성
		Chulgum cg = new Chulgum();
		// 환전 인스턴스 생성
		Exchange ex = new Exchange();
		// 계좌이체 인스턴스 생성
		Account ac = new Account();
		// 선택 인스턴스 생성
		YesNo ys = new YesNo();
		// 통장개설 인스턴스 생성
		TongJang tj = new TongJang();
		

		try
		{
			Thread.sleep(2000);							//-- 시간 텀 두기
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		

		System.out.println("	 ======= 안녕하세요 고객님~^^! =======");
		
		

		
		while (true)									//-- 업무선택 무한 루프
		{												//   선택이 제대로 안되었을 때 다시 선택할 수 있도록

			System.out.println("(1. 예금 2. 출금 3. 환전 4. 계좌이체 5. 계좌개설 6. 계좌조회)");
			System.out.print("▷어떤 업무를 보시겠어요^^*? : ");
			
			
			
			try
			{
				super.select = br.readLine();
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
			/* // Test
			System.out.println(select);
			select = "예금";
			System.out.println("예금".equals(select));
			*/
			

			if ("예금".equals(super.select) || "1".equals(super.select))		//-- 예금 실행 조건
			{
				if (super.getTongname() == super.getPhone())
				{
					yg.yegum();
					ys.yesNo();
					if (super.selectC != 'Y' && super.selectC != 'y')
					{
						return;
					}
				}
				else
				{
					System.out.println("계좌가 개설되어있지 않습니다. 업무를 재선택해주세요.\n");
	
					
				}
				
				
			}
			else if ("출금".equals(super.select) || "2".equals(super.select))	//-- 출금 실행 조건
			{
				if (super.getTongname() == super.getPhone())
				{
					cg.chulgum();
					ys.yesNo();
					if (super.selectC != 'Y' && super.selectC != 'y')
					{
						return;
					}
				}
				else
				{
					System.out.println("계좌가 개설되어있지 않습니다. 업무를 재선택해주세요.\n");
					
				}
				
				
			}
			else if ("환전".equals(super.select) || "3".equals(super.select))	//-- 환전 실행 조건
			{
				
				
				ex.inputEx();
				ys.yesNo();
				if (super.selectC != 'Y' && super.selectC != 'y')
				{
					return;
				}
				

			}
			else if ("계좌이체".equals(super.select) || "4".equals(super.select))//-- 계좌이체 실행 조건
			{
				
				if (super.getTongname() == super.getPhone())
				{
					ac.account();
					ys.yesNo();
					if (super.selectC != 'Y' && super.selectC != 'y')
					{
						return;
					}
				}
				else
				{
					System.out.println("계좌가 개설되어있지 않습니다. 업무를 재선택해주세요.\n");
					
				}
				
			}
			else if ("계좌개설".equals(super.select) || "5".equals(super.select))
			{
				tj.gaeseol();
				ys.yesNo();
				if (super.selectC != 'Y' && super.selectC != 'y')
				{
					return;
				}
			}
			else if ("계좌조회".equals(super.select) || "6".equals(super.select))
			{
				
				if (super.getTongname() == super.getPhone())
				{
					tj.check();
					ys.yesNo();
					if (super.selectC != 'Y' && super.selectC != 'y')
					{
						return;
					}
				}
				else
				{
					System.out.println("계좌가 개설되어있지 않습니다. 업무를 재선택해주세요.\n");
				
				}

			}
			else
			{
				System.out.println("거래 선택을 다시 해주세요. 고객님..!!");
				System.out.println("====================================");
				System.out.println();
			}
		}


	}// end whatkind()

}// end class WhatKind