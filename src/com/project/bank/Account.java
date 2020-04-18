package com.project.bank;

import java.util.Scanner;

public class Account extends Customer
{
	private static long temp, temp1;				//-- (java.35) 돈 계산용 임시 저장 변수 선언
	private static String gejwa;			//-- (java.143) 받는 분의 계좌를 받을 변수 선언
	private static long account=0L;			//-- 돈 계산용 임시 저장 변수 선언
							
	//String st;
	//int money;
	//int Account1=100000000;
	//int Account2=0;
/*
	void inmoney (int amount)	// 입금
	{
		money += amount;
	}
	void outmoney (int amount)	// 출금
	{
		money -=amount;
	}
*/
/*
	public String toString()
	{
	return "현재 잔액은 " + money + "입니다";
	}
*/

	public String transfer(long amount, Account otherAccount)		//-- 계좌이체 돈 계산 메소드
	{
		if(super.getTongjang() >= amount)								//-- 보내려는 금액과 현재 잔고를 비교
		{
			
			temp1 = super.getTongjang() - amount;					//-- 현재 잔고보다 금액이 작을 경우,
			otherAccount.account += amount;							//	 내 잔고에서 금액을 뺀 후 저장
			super.setTongjang(temp1);								//	 내 잔고에 금액 저장

			return "▷이체할 금액은 " + amount + " 입니다";
		}
		else													//-- 현재 잔고보다 금액이 클 경우,
		{														//	 프로그램 종료 및 안내문 출력
			return "잔액이 부족합니다ㅠㅠ 열심히 벌어서 돈을 더 넣어주세요. ^^/\n"; 
		}
	}// end trasfer()


	public void account()										//-- 계좌이체 이행 메소드
	{
		Scanner sc = new Scanner(System.in);

		//Account me = new BankAccount();
		Account you = new Account();							//-- 상대방 인스턴스 생성
		Customer me = new Account();							//-- 고객 인스턴스 생성
		JuminCompare jc = new JuminCompare();					//-- 주민번호 비교 인스턴스 생성
		PassCompare pc = new PassCompare();						//-- 비밀번호 비교 인스턴스 생성

		while (true)	// 무한루프 → 신분증 확인 및 거래 지속여부 확인
		{
			try
			{
				System.out.println(" ======= 계좌이체서비스 입니다♡ =======");
				System.out.print("▷신분증 확인할게요.^^(Y/N) : ");		// 신분증 확인
				super.selectC = (char)System.in.read();
				System.in.skip(2);

				if (super.selectC != 'Y' && super.selectC != 'y')	// y가 아닐 경우 재차 질문
				{
					System.out.println("거래를 하실 수 없어요ㅠㅠ");
					System.out.print("\n▷계속 거래를 진행하시겠습니까?(Y/N): ");
					super.selectC = (char)System.in.read();
					System.in.skip(2);

				}
				else												//-- y 일 경우 거래 계속 진행
				{
					System.out.println("신분증 확인중입니다. ^^\n");
					jc.juminCom();									//-- 등록된 주민번호와 입력 주민번호 대조
					pc.passCom();									//-- 등록된 비밀번호와 입력 비밀번호 대조
	
				}

				
				if (super.selectC != 'Y' && super.selectC != 'y')	//--	java.61 에 대한 질문에 y가 아닐 경우
				{
					System.out.println("다음에 또 이용해주세요. ^^*");
					System.out.println("================================");
					break;
					
				}
				else												//-- y 일 경우 넘어간다.
				{
					System.out.println();
					break;
					
				}
			}
			catch (Exception e)										//-- Exception 잡아내기 설정
			{
				System.out.println(e.toString());
			}
			
		}

		

		// test	
		//System.out.println("① : " + choice);
		
		if (super.selectC != 'Y' && super.selectC != 'y')			//-- 앞서 선택이 y가 아닐경우
		{
			return;													//   account() 메소드 종료
		}

		try
		{
			System.out.print("▷이체할 금액을 입력해주세요.^^ : ");	//-- 이체 금액 입력	
			temp = (long)sc.nextInt();	
		}
		catch (Exception e)
		{
			
			System.out.println("앗, 숫자만 입력해주세요. :(");			//-- 숫자 외에 다른 것 입력 시 종료
			System.out.println("\n거래를 다시 이용해주세요!!");
			return;
		}
		//System.out.println("② : " + choice);
	
		
		
		
		
		do
		{
			System.out.println("(1. 꼼마 2. 신한 3. 국민 4. 농협)");//-- 은행 선택
			System.out.print("\n▷받는 계좌의 은행을 선택해주세요 : ");
			super.select = sc.next();

			if ("꼼마".equals(super.select) || "1".equals(super.select) || "신한".equals(super.select) || "2".equals(super.select) || "국민".equals(super.select) || "3".equals(super.select) || "농협".equals(super.select) || "4".equals(super.select))		//-- 예금 실행 조건
			{

				do													//-- 계좌번호 비교
				{
					System.out.print("\n▷받는 분의 계좌번호를 입력해주세요.^^ (예시 : 010xxxxxxxx) : ");
					gejwa = sc.next();

					if (gejwa.length() !=11)
					{
						System.out.println("▷계좌번호를 다시 입력해주시기 바랍니다.\n");
					}
				}
				while (gejwa.length() !=11);							//-- 11자리가 넘어갈 경우에 다시 입력

				

				gejwa = ((Account)me).transfer(temp, you);				//-- 다운 캐스팅 
																		//-- 계좌이체 이행

				if (gejwa.equals("잔액이 부족합니다ㅠㅠ 열심히 벌어서 돈을 더 넣어주세요. ^^/\n"))
				{
					System.out.println();
					return;
				}
				

				


				try
				{
					System.out.printf("%,d원 금액이 맞습니까?(Y/N) :", temp);
					super.selectC = (char)System.in.read();
					System.in.skip(2);

					if (super.selectC != 'Y' && super.selectC != 'y')		// 출력한 금액과 같지 않은 경우 다시 입력
					{
						System.out.println("다시 거래를 이용해주시기 바랍니다.");
						return ;
					}
					
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
				}


				System.out.printf("\n▷이체 하신 %,d 원(￦)이 정상적으로 이체되었습니다\n", temp);
				System.out.printf("▷▷현재 남은 계좌 잔액은 : %,d 원(￦)입니다.^^\n", super.getTongjang());
				System.out.println("		====== 안녕히가세요. 또 이용해주세요! ^^* ========\n");
				
				break;
			}
			else
			{
				System.out.println("은행 선택을 다시 해주세요. 고객님..!!");
				System.out.println("====================================");
				System.out.println();
			}
		}
		while (true);
		
	



		
	}// end account()


}// end class Account





/*
public class Account
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		BankAccount me = new BankAccount();
		BankAccount you = new BankAccount();

		System.out.println(" 이체하실 금액을 입력해주세요.^^ ");		
		int amount = sc.nextInt();		
		System.out.println(" 이체 받을 계좌번호를 입력해주세요.^^ (예시 : 010xxxxxxxx) : ");
		String gejwa = sc.next();
		System.out.println(me.transfer(amount, you)); 
		System.out.println(" 현재 남은 계좌 잔액은 : " + super.getCash() + " 원(￦)입니다.^^");
		System.out.println("이체 하신 " + you.Account2 + " 원(￦)이 정상적으로 처리되었습니다" );
	}
}
*/