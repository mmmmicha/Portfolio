package com.project.bank;

import java.util.Currency;			// 현재 위치(나라) 설정 후, 그 위치에 기반한 정보 method들 사용 가능
import java.util.Locale;			// Currency class의 method 사용 시, 나라 설정을 위한 class
import java.util.Scanner;

class Exchange extends Customer
{ 
	public final double USD;		// 각 나라의 환율 정보를 담을 변수 선언
	public final double JPY;
	public final double EUR;
	public final double CNY;
	public final double GBP;
	Currency cur;					// Currency class 객체 선언
	String giho;					// 각 나라의 화폐 기호 담을 변수 선언

	Exchange()						// 사용자정의생성자. 각 나라에 맞는 환율로 초기화 해줌.
	{
		USD=1218.40;	
		JPY=11.5768;
		EUR=1357.85;
		CNY=169.94;
		GBP=1494.49;
	}

	private static int money;		// 입력받은 환전할 금액 담을 변수
	private static int to;			// 선택된 나라 담을 변수
	private static long temp;		// 현재 자금 갱신을 위한 변수
	private static long won;		// 환전 후 지급할/지급받을 원화 담을 변수

	// Exchange class의 main method
	public void inputEx()	
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" ======= 환전서비스 입니다♡ =======");
		System.out.println("\n▷사전환전서비스를 신청하셨나요? ^^*");
		System.out.print("1.네		2.아니요...;;		: ");
		super.select = sc.next();
		
		if ("1".equals(super.select))		// 사전환전 신청(1번)
		{
			preEx();		// 사전환전 method 호출
		}

		else if ("2".equals(super.select))	// 사전환전 미신청(2번)
		{
			System.out.println("\n▷걱정마세요! 원하시는 환전서비스를 말씀해주세요. ^^*");
			System.out.print("1.한국 돈 -> 외국 돈  	2.외국 돈 -> 한국 돈	3.그냥 다음에 할래요   : ");
			super.select = sc.next();

			if ("1".equals(super.select))		// 사전환전 - 원화에서 외화(1번)
			{
				exchangeEx();		// 환전 안내 method 호출

				System.out.printf("\n▷%,d%s 는 %,d￦ 입니다. 환전하시겠어요? ^^\n", money, giho, won);
				System.out.print("1.네		2.아니요, 다음에 할래요		 : ");
				super.select = sc.next();

				if ("1".equals(super.select))			// 사전환전 - 1번 - 환전확정(1번)
				{
					
					System.out.printf("\n▷ %s %,d%s 를 %d￦ 에 환전하셨습니다. \n", cur.getSymbol(), money, giho, won);
					
					temp = super.getCash() - won;				// 환전한만큼 자금에서 제외 				
					super.setCash(temp);

					System.out.printf("▷▷현재 잔액은 %,d￦, %s %,d%s 입니다.\n", super.getCash(), cur.getSymbol(), money, giho);
					System.out.println("\n            ========= 이용해주셔서 감사합니다 ^^* ========== ");
				}
				else if ("2".equals(super.select))			// 사전환전 - 1번 - 거래취소(2번)
				{
					cancelEx();		// 거래 취소 method 호출
				}
				else
					wrongEx();
			}
			else if ("2".equals(super.select))		// 사전환전 - 외화에서 원화(2번)
			{
				exchangeEx();		// 환전 안내 method 호출


				System.out.printf("\n▷%,d%s 는 %,d￦ 입니다. 환전하시겠습니까? ^^\n", money, giho, won);
				System.out.print(/*"1.네. 계좌에 넣어주세요	*/	"1.네. 현금으로 주세요 		2.아니요, 다음에 할래요		: ");
				super.select = sc.next();

				if ("1".equals(super.select))				// 사전환전 - 2번 - 계좌입금(1번)
				{
					
					System.out.printf("\n▷ %s %,d%s 를 %d원에 환전하셨습니다. \n", cur.getSymbol(), money, giho, won);
				
					temp = super.getCash() + won;						// 환전한만큼 자금에 추가
					super.setCash(temp);

					System.out.printf("▷▷현재 잔액은 %,d원 입니다.\n", super.getCash());
					System.out.println("\n			   ========= 이용해주셔서 감사합니다 ^^* ========== ");
				}
				/*
				else if ("2".equals(super.select))			// 사전환전 - 2번 - 현금지급(2번)
				{
					System.out.printf("\n▷ %s %,d%s 를 %,d원에 환전하셨습니다. \n▷▷여기 환전한 금액 드릴게요. ^^ ☞┌───┐", cur.getSymbol(), money, giho, won);
					System.out.printf("														  ☞└───┘\n");
					System.out.println("\n				 ========= 이용해주셔서 감사합니다 ^^* ========== ");
				}
				*/
				else if ("2".equals(super.select))			// 사전환전 - 2번 - 거래취소(2번)
				{
					cancelEx();
				}
				else
					wrongEx();
			}
			else if ("3".equals(super.select))		// 사전환전 - 거래취소(3번)
			{
				cancelEx();
			}
			else 
				wrongEx();	
		}
		else
			wrongEx();						// 잘못된 입력 method 호출
	}// end inputEx()


	// 사전 환전 method
	public void preEx()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("\n▷사전환전서비스에서 어떤 우대 방법을 선택하셨나요? ^^*");
		System.out.print("1.환율우대욧		2.보험우대욥	 : ");
		super.select = sc.next();
			
		if ("1".equals(super.select))
		{
			System.out.print("\n▷ 환율우대로 환율할인 2% 되었습니다.");
			System.out.print("\n▷ 계좌의 금액은 사전신청하셨을 때 출금되었습니다.\n");
			System.out.print("\n		====== 이용해주셔서 감사합니다. 즐거운 여행되세요^^/ ======\n");
			return;
		}
		else if ("2".equals(super.select))
		{
			System.out.print("\n▷ 보험우대로 환율할인 1% 되었습니다");
			System.out.print("\n▷ 계좌의 금액은 사전신청하셨을 때 출금되었습니다.\n");
			System.out.print("\n		====== 이용해주셔서 감사합니다. 즐거운 여행되세요^^/ ======\n");
			return;
		}
	}//end preEx()


	// 환전 안내 method
	public void exchangeEx()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("\n▷어느 나라로 떠나세요? 부럽다아 ^^*");
			System.out.printf("1.미국(USD)	  2.유럽(EUR)	  3.일본(JPY) \n4.중국(CNY)	  5.영국(GBP)	  6.기타화폐(Other)		: ");
			to = sc.nextInt();
			if (0<to && to<6)						// 선택지 외 번호 입력 시												
				continue;
			System.out.println("\n▷입력하신 나라의 화폐는 준비되어 있지 않습니다ㅠㅠ"); 
		}
		while (to<1 || 5<to);

		System.out.print("\n▷얼마나 환전해드릴까요?");
		System.out.print("\n (해당 나라의 화폐 기준으로 입력해주세요) :");
		money = sc.nextInt();
				
		won = (long)calEx(to, money);				// 환전 계산 method 호출. (parameter로 to-나라, money-환전할 금액)
	}//end exchangeEx()
	
		
	// 환전 계산 method
	public double calEx(int country, int money)
	{
		double result=0;

		switch (country)
		{
		case 1: 
			cur = Currency.getInstance(Locale.US);		// 현재 위치를 Locale형 field값으로 설정		
			giho = cur.getSymbol(Locale.US);			// 설정한 나라의 화폐 기호를 받아옴
			result = money*USD;								
			break;
		case 2:
			cur = Currency.getInstance(Locale.FRANCE);
			giho = cur.getSymbol(Locale.FRANCE);
			result = money*EUR;
			break;
		case 3:
			cur = Currency.getInstance(Locale.JAPAN);
			giho = cur.getSymbol(Locale.JAPAN);
			result = money*JPY;
			break;
		case 4:
			cur = Currency.getInstance(Locale.CHINA);
			giho = cur.getSymbol(Locale.CHINA);
			result = money*CNY;
			break;
		case 5:
			cur = Currency.getInstance(Locale.UK);
			giho = cur.getSymbol(Locale.UK);
			result = money*GBP;
			break;
		}

		return result * 1.2;										// 계산 마친 금액 반환. 은행 수수료(20%) 제외.
	}// end calEx													


	// 거래 취소 method
	public void cancelEx()
	{
		System.out.println("\n    ======= 환전이 취소되었습니다. 처음부터 다시 진행해주세요. ^^* =======  ");
		return;
	}// end cancleEx()

	
	// 잘못된 선택 method (선택지 외 다른 번호 입력 시)
	public void wrongEx()
	{
		System.out.println("\n		 ======= 잘못된 입력입니다. 기회는 없습니다. 처음부터 다시 진행해주세요. ^^* =======  ");
		return;
	}// end wrongEx()
}



/* 테스트

public class ExTest
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Exchange ex = new Exchange();			// Exchange 클래스 기반 인스턴스 생성
		//Locale lc = new Locale("kor");			// Locale 클래스 기반 인스턴스 생성

		ex.inputEx();								// Exchange 클래스 input() 메소드 호출
	
	}
}
*/


