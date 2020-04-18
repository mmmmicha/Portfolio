package com.project.bank;

import java.util.Scanner;

public class Yegum extends Customer		// 예금 클래스
{
	
	private static long temp1;			// 은행, 고객 사이의 돈 거래를 위한 매개변수 (java.108 참고)
	private static long temp2;
	
	public void yegum()					// 예금 메소드			
	{
		
		// Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		// Bank 인스턴스를 생성하여 ChangGu 객체에 업캐스팅
		ChangGu ch = new Bank();
		// PassCompare 인스턴스 생성
		PassCompare pc = new PassCompare();
		// JuminCompare 인스턴스 생성
		JuminCompare jc = new JuminCompare();
		

		
		

		while (true)	// 무한루프 → 신분증 확인 및 거래 지속여부 확인
		{
			try
			{
				System.out.println(" ======= 예금서비스 입니다♡ =======");
				System.out.print("▷신분증 확인할게요.^^(Y/N) : ");		// 신분증 확인
				super.selectC = (char)System.in.read();
				System.in.skip(2);

				if (super.selectC != 'Y' && super.selectC != 'y')	// y가 아닐 경우 재차 질문
				{
					System.out.println("거래를 하실 수 없습니다.\n");
					System.out.print("▷계속 거래를 진행하시겠어요?(Y/N): ");
					super.selectC = (char)System.in.read();
					System.in.skip(2);

				}
				else												// y 일 경우 거래 계속 진행
				{
					System.out.println("신분증을 확인하겠습니다.\n");
					jc.juminCom();									// 등록된 주민번호와 입력 주민번호 대조
					pc.passCom();									// 등록된 비밀번호와 입력 비밀번호 대조
	

				}

				
				if (super.selectC != 'Y' && super.selectC != 'y')	//	java.37 에 대한 질문에 y가 아닐 경우
				{
					System.out.println("다음에 또 이용해주세요. ^^*");
					System.out.println("================================");
					break;
					
				}
				else												// y 일 경우 넘어간다.
				{
					System.out.println();
					break;
					
				}
			}
			catch (Exception e)										// Exception 잡아내기 설정
			{
				System.out.println(e.toString());
			}
			
		}

		// 주민번호 입력(맞는지 안맞는지)
		
			
		

		// 신분증 검사 메소드 필요
		if (super.selectC != 'Y' && super.selectC != 'y')			// 앞서 선택이 y가 아닐경우
		{
			return;													// yegum() 메서드 종료
		}

		System.out.print("▷얼마를 입금하시겠어요? (금액 숫자만 입력) : ");

		temp1 = (long)sc.nextInt();								// Customer 부모 클래스에 입금금액 저장

		try
		{
			System.out.printf("\n▷입금하실 금액이 %,d 원이 맞을까요?(Y/N) :", temp1);
			super.selectC = (char)System.in.read();
			System.in.skip(2);

			if (super.selectC != 'Y' && super.selectC != 'y')		// 출력한 금액과 같지 않은 경우 다시 입력
			{
				System.out.println("거래를 다시 이용해주시기 바랍니다.");
				return ;
				
			}
			else													// 정상 입금 확인으로 거래 종료
			{
				
				System.out.println("▷▷입금이 완료되었습니다!");
				temp2 = super.getTongjang() + temp1;
				super.setTongjang(temp2);
				System.out.printf("\n▷▷현재 통장 잔액은 : %,d 원 입니다. 우와~\n", super.getTongjang());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
			
		temp2 = ch.getBCash() - temp1;							// 은행 돈 최신화
		ch.setBCash(temp2);
		
	}// end yegum()


}// end class Yegum
