// 결제 구현한 class
package com.project.ssangyong.kiosk;

import java.util.Scanner;
import java.util.Iterator;

public class Casher extends Main
{

	private static int won50000 = 100;
	private static int won10000 = 100;
	private static int won5000 = 100;
	private static int won1000 = 100;
	private static int won500 = 100;

	Casher(int won50000, int won10000, int won5000, int won1000, int won500) // Casher 사용자 정의 생성자(파라미터 有)
	{
		this.won50000 = won50000;
		this.won10000 = won10000;
		this.won5000 = won5000;
		this.won1000 = won1000;
		this.won500 = won500;
	}

	Casher()	// Casher 사용자 정의 생성자
	{
	}

	// getter/setter ------------------------------------------

	public int getWon50000()
	{
		return won50000;
	}
	public void setWon50000(int won50000)
	{
		this.won50000 = won50000;
	}


	public int getWon10000()
	{
		return won10000;
	}
	public void setWon10000(int won10000)
	{
		this.won10000 = won10000;
	}
	

	public int getWon5000()
	{
		return won5000;
	}
	public void setWon5000(int won5000)
	{
		this.won5000 = won5000;
	}
	

	public int getWon1000()
	{
		return won1000;
	}
	public void setWon1000(int won1000)
	{
		this.won1000 = won1000;
	}

	
	public int getWon500()
	{
		return won500;
	}
	public void setWon500(int won500)
	{
		this.won500 = won500;
	}

//=========================================================================================

	public void cashService() throws Exception		//-- 거래의 display와 계산 처리를 한꺼번에 하는 메소드
	{
		Scanner sc = new Scanner (System.in);	
		int ch;										//-- 결제서비스 이용에 대한 선택 변수 선언
		int a,b,c,d,e;								//-- 사용자 매수입력 변수 선언
		int menus = 0; //test용						//-- 사용자 주문 품목에 대한 총합 금액 변수 선언
		String answer;								//-- Y/N 선택용 변수 선언
		String phone;
		Display diss = new Display();				//-- Display 인스턴스 생성

		// 장바구니의 담겨있는 품목들을 오늘의 실적 자료구조에 다 담는 과정
		// 담은 후에는 장바구니를 다 비워주며, 메뉴 자료구조안에 있는 메뉴 각각의 인스턴스 내의 매출량 속성을 최신화 함

		Iterator<Integer> it = basket.keySet().iterator();	//-- 장바구니 정렬용 Iterator 인스턴스 생성
		Iterator<Integer> its;

		while (it.hasNext())
		{
			int inp = it.next();
			today.put((today.size()+inp), basket.get(inp));
			menus += basket.get(inp).getPri();
			
			its = menu.keySet().iterator();
			while (its.hasNext())
			{
				int inn = its.next();
				if (basket.get(inp).getGname().equals(menu.get(inn).getGagaeName()) && basket.get(inp).getMname().equals(menu.get(inn).getMenuName()))
				{
					menu.get(inn).setPlusSell(1);
					break;
				}
			}
			
		}

	
		basket.clear();
		n=0;
		// 장바구니 key값 초기화
		System.out.println(basket.size());
		
		// 결제서비스 Display 출력
		System.out.println("=============================");
		System.out.println("|       [결제 서비스]       |");
		System.out.println("|         1. 현금           |");
		System.out.println("|         2. 카드           |");
		System.out.println("=============================");
		System.out.print(  "(1~2번)결제 방법을 선택해 주세요 : ");
		ch = sc.nextInt();
		
			// 현금 서비스 이용
		if (ch ==1)
		{
			int sum=0;
			
			do
			{
				System.out.printf("결제할 금액 : %,d원",menus);		//-- 전에 누적한 장바구니의 총금액
			
				System.out.println("[결제 화폐]");

				System.out.print("오 만원권 (매수) : ");
				a = sc.nextInt();
				System.out.print("만원권 (매수) : ");
				b = sc.nextInt();
				System.out.print("오 천원권 (매수) : ");
				c = sc.nextInt();
				System.out.print("천원권 (매수) : ");
				d = sc.nextInt();
				System.out.print("오백원 (갯수) : ");
				e = sc.nextInt();

				sum += (a*50000) + (b*10000) + (c*5000) + (d *1000) + (e * 500);	//-- 입력한 매수대로 금액 누적

				System.out.printf("메뉴 가격 : %,d원\n",menus);
				System.out.printf("입력한 총금액 : %,d원\n",sum);
				
				if ((sum-menus)<0)		//-- 입력한 금액이 부족할 시 금액을 추가할 수 있는 기회를 제공
				{
					Thread.sleep(1000);
					System.out.println("입금한 잔액이 부족합니다");
					System.out.print("추가로 금액을 입력하시겠습니까? (Y/N) : ");
					answer = sc.next();

					if (!answer.equals("Y")&&!answer.equals("y"))
					{
						System.out.println("다시 거래를 이용해 주십시오. 감사합니다.");
						return;	
					}
				}
			}
			while ((sum-menus)<0);// end do while()

				//-- 매수 현금보관함(거스름돈)으로 투입
				setWon50000(getWon50000() + a);
				setWon10000(getWon10000() + b);
				setWon5000(getWon5000() + c);
				setWon1000(getWon1000() + d);
				setWon500(getWon500() + e);
				
				//-- 거스름돈을 내림차순으로 거슬러 주는 시스템
				int aa=0;
				int bb=0;
				int cc=0;
				int dd=0;
				int ee=0;
				int tot = sum-menus;

				while (tot>=50000)
				{
					if (getWon50000()==0)
						break;

					tot -= 50000;
					aa++;
				}

				while (tot>=10000)
				{
					if (getWon10000()==0)
						break;

					tot -= 10000;
					bb++;
				}

				while (tot>=5000)
				{
					if (getWon5000()==0)
						break;

					tot -= 5000;
					cc++;
				}

				while (tot>=1000)
				{
					if (getWon1000()==0)
						break;

					tot -= 1000;
					dd++;
				}

				while (tot>=500)
				{
					if (getWon500()==0)
						break;

					tot -= 500;
					ee++;
				}

				//-- tot이 0까지 안깎일 경우 거스름돈이 부족한 상황이므로 거래를 다시 시작하도록 안내
			if (tot>0)
			{
				System.out.println("\n자판기의 거스름돈이 부족합니다.\n\n");
				System.out.println("죄송합니다. 관리자에 문의해주십시오.");

				System.out.println("금액을 반환하겠습니다.\n");
				setWon50000(getWon50000() - a);
				setWon10000(getWon10000() - b);
				setWon5000(getWon5000() - c);
				setWon1000(getWon1000() - d);
				setWon500(getWon500() - e);
				return;

			}

			//-- 결제가 완료되면 거스름돈 누적 수 만큼 원래 수량에서 빼줌.
			setWon50000(getWon50000() - aa);
			setWon10000(getWon10000() - bb);
			setWon5000(getWon5000() - cc);
			setWon1000(getWon1000() - dd);
			setWon500(getWon500() - ee);
			
			System.out.printf("거스름돈 : %,d 원\n", (sum-menus)); 

			System.out.println("결제가 완료되었습니다.");
		}
		// 카드 서비스 이용
		if (ch == 2)
		{
			System.out.println("[카드 결제]");
			System.out.println("카드를 넣어주세요. (아무키나 누르세요) ");
			sc.next();
			System.out.println("결제 진행중 입니다...");
			Thread.sleep(2000);
			System.out.printf("%,d 원이 결제 완료 되었습니다.\n",menus);
		}
		Thread.sleep(1000);
	}
	// 거스름돈 현황 출력
	public void cashRestPrint()
	{
		System.out.println();
		System.out.println("==[1. 거스름돈 현황]==");
		System.out.println("----------------------");
		System.out.printf("남은 5만원권 : %d 매\n", getWon50000());
		System.out.printf("남은 1만원권 : %d 매\n", getWon10000());
		System.out.printf("남은 5천원권 : %d 매\n", getWon5000());
		System.out.printf("남은 1천원권 : %d 매\n", getWon1000());
		System.out.printf("남은 5백원 : %d 개\n", getWon500());
		System.out.println("======================\n\n");
	}
	// 거스름돈 보충 메소드
	public void cashRestUp()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("=============[2. 거스름돈 보충]=============");
		System.out.println("--------------------------------------------");
		System.out.print(">> 보충할 매수 혹은 개수를 입력하세요(5만원, 1만원, 5천원, 1천원, 500원 순)(띄어쓰기 구분) : ");
		setWon50000(getWon50000() + sc.nextInt());
		setWon10000(getWon10000() + sc.nextInt());
		setWon5000(getWon5000() + sc.nextInt());
		setWon1000(getWon1000() + sc.nextInt());
		setWon500(getWon500() + sc.nextInt());
		System.out.println(">> 완료되었습니다.");
		System.out.println();
		System.out.println();
	}
	// 거스름돈 회수 메소드
	public void cashRestGet() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("============[3. 거스름돈 회수]============");
		System.out.println("------------------------------------------");
		
		System.out.print(">> 회수하고 싶은 돈을 차례로 입력해주세요.\n\n");

		System.out.print(">> 50000원권의 갯수를 입력해주세요.\n");
		int get50000 = sc.nextInt();	
		System.out.print(">> 10000원권의 갯수를 입력해주세요.\n");
		int get10000 = sc.nextInt();						
		System.out.print(">> 5000원권의 갯수를 입력해주세요.\n");
		int get5000 = sc.nextInt();	
		System.out.print(">> 1000원권의 갯수를 입력해주세요.\n");
		int get1000 = sc.nextInt();
		System.out.print(">> 500원권의 갯수를 입력해주세요.\n");
		int get500 = sc.nextInt();	

		if (getWon50000() >= get50000 && getWon10000() >= get10000 && getWon5000() >= get5000 && getWon1000() >= get1000 && getWon500() >= get500)
		{
			setWon50000(getWon50000() - get50000);
			setWon10000(getWon10000() - get10000);
			setWon5000(getWon5000() - get5000);
			setWon1000(getWon1000() - get1000);
			setWon500(getWon500() - get500);
			System.out.println(">> 완료되었습니다.");
			System.out.println();
			System.out.println();
		}
		else if (getWon50000() < get50000 || getWon10000() < get10000 || getWon5000() < get5000 || getWon1000() < get1000 || getWon500() < get500)
		{
			System.out.print(">> 회수 가능한 최대치의 돈을 가져가시겠습니까?(Y/N) : ");
			String yesorno = sc.next();
			if (yesorno.equals("Y") || yesorno.equals("y"))
			{
				setWon50000(getWon50000() - getWon50000());
				setWon10000(getWon10000() - getWon10000());
				setWon5000(getWon5000() - getWon5000() );
				setWon1000(getWon1000() - getWon1000() );
				setWon500(getWon500() - getWon500()  );
				System.out.println(">> 완료되었습니다.");
				System.out.println();
				System.out.println();
			}
			else if (yesorno.equals("N") || yesorno.equals("n"))
			{
				System.out.print(">> 회수할 돈을 다시 확인해주세요.\n\n");
			}
		}	
	}// end cashRestGet()
}// end Casher

