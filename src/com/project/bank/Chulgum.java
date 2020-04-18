package com.project.bank;

import java.util.Scanner;

public class Chulgum extends Customer		// 출금 클래스
{

	private static long temp1;				// 은행, 고객 사이의 돈 거래를 위한 매개변수 (java.106 참고)
	private static long temp2;
	
	public void chulgum()					// 출금 메소드 선언 및 정의
	{
		// Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		// ChangGu 인스턴스 생성
		ChangGu ch = new Bank();
		// PassCompare 인스턴스 생성
		PassCompare pc = new PassCompare();
		// JuminCompare 인스턴스 생성
		JuminCompare jc = new JuminCompare();

		

		while (true)						// 무한 루프 → 신분증 확인 및 거래 지속여부 확인
		{
			try
			{
				System.out.println("  ======= 출금서비스 입니다 ♡ =======");
				System.out.print("▷신분증 확인할게요. ^^ (Y/N) : ");	//-- 신분증 확인
				super.selectC = (char)System.in.read();
				System.in.skip(2);

				if (super.selectC != 'Y' && super.selectC != 'y')	//-- y가 아닐 때 재차 거래여부 확인
				{
					System.out.println("거래를 하실 수 없어요ㅠㅠ");
					System.out.print("▷계속 거래를 진행하시겠어요?(Y/N): ");
					super.selectC = (char)System.in.read();
					System.in.skip(2);
				}
				else												//-- 신분증 본격 확인
				{
					System.out.println("신분증을 확인하겠습니다.\n");	
					jc.juminCom();									//-- 등록된 주민번호와 대조하여 확인	
					pc.passCom();									//-- 등록된 비밀번호와 대조하여 확인
					
				}

				

				if (super.selectC != 'Y' && super.selectC != 'y')	//-- y가 아닐 경우
				{
					System.out.println("		 ========== 다음에 또 이용해주세요! ^-^ ==========");
					break;											//	 무한 루프 종료
					
				}
				else												//-- y가 맞을 경우
				{
					System.out.println();							//	 거래 지속 진행
					break;											//	 무한 루프 종료
					
				}
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
			
			
		}

	
			
		

		if (super.selectC != 'Y' && super.selectC != 'y')			//-- 앞서 y가 아닌 경우
		{
			return;													//   출금 메소드 종료
		}
		System.out.print("▷얼마를 출금하시겠어요? (금액 숫자만 입력) : ");

		temp1 = sc.nextInt();										//-- 임시적으로 출금할 금액 저장
		if (super.getTongjang() >= (long)temp1)
		{
			try
			{
				System.out.printf("\n▷출금하실 금액이 %,d 원이 맞을까요? (Y/N) :", temp1);
				super.selectC = (char)System.in.read();					//-- Customer 부모 클래스에 출금할 금액 저장
				System.in.skip(2);

				if (super.selectC != 'Y' && super.selectC != 'y')		//-- 앞서 y가 아닌 경우 거래 종료
				{
					System.out.println("		========= 거래를 다시 이용해주세요. ^^* ========");
					return ;
					
				}
				else													//-- 앞서 y인 경우 고객 정보 최신화
				{	
					temp2 = super.getTongjang() - temp1;
					super.setTongjang(temp2);
					System.out.println("▷출금이 완료되었습니다.");
					System.out.printf("\n▷▷현재 통장 잔액은 : %,d 원 입니다.\n", super.getTongjang());

				}
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
			 
				
			temp2 = ch.getBCash() - temp1;								//-- 은행 돈 최신화
			ch.setBCash(temp2);
		}
		else
		{
			System.out.println("▷▷잔액이 부족합니다ㅠㅠ 열심히 벌어서 돈을 더 넣어주세요! ^^/");
		}
		
	
	}// end output()

}// end class Chulgum