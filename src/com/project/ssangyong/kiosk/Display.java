package com.project.ssangyong.kiosk;
// 첫 화면구성, 사용자가 이용할 display가 구현된 class

import java.util.Scanner;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;

public class Display extends Main
{
	private static final int DISPLAY_MANAGER=0;			// 관리자 모드 접속 번호 초기값 설정
	private static final int E_MENU = 1;				// 메뉴기준 모드 접속 번호 초기값 설정
	private static final int E_STORE = 2;				// 식당기준 모드 접속 번호 초기값 설정
	public static final int DISPLAY_KOR=1;				// 한식 접속 번호 초기값 설정
	public static final int DISPLAY_CHI=2;				// 중식 접속 번호 초기값 설정
	public static final int DISPLAY_JAP=3;				// 일식 접속 번호 초기값 설정
	public static final int DISPLAY_BUN=4;				// 분식 접속 번호 초기값 설정
	private static final int DISPLAY_MASTER=9;			// 점주 모드 접속 번호 초기값 설정
	public static int inbun=0;							// 매뉴갯수 선택 초기값 설정
	private static String yes;
	String selcc;
	private static int[] jumun = new int[100];			// 주문번호 저장할 변수
	int nujeoktime=0;
	int temp;


	public void mainDisplay()
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			System.out.println("=================================================================================");
			System.out.println("|                                                                               |");
			System.out.println("|   _________________________________________________________________________   |");
			System.out.println("|   |                                                                       |   |");
			System.out.println("|   |                                                                       |   |");
			System.out.println("|   |                        <화면을 터치해 주세요♡>                       |   |");
			System.out.println("|   |                                                                       |   |");
			System.out.println("|   |                       |                       |                _      |   |");
			System.out.println("|   |                       |            ##         |               [ ]     |   |");
			System.out.println("|   |                       |           #           |       _      _[ ]_    |   |");	
			System.out.println("|   |         ****          |        *******        |     _[_]_   [     ]   |   |");
			System.out.println("|   |       *   () *        |        *     *        |    [  S  ]  [  B  ]   |   |");
			System.out.println("|   |      *  !!ㅣ  *       |        *     *        |    [  O  ]  [  E  ]   |   |");
			System.out.println("|   |      *  !!ㅣ  *       |         *   *         |    [  J  ]  [  E  ]   |   |");
			System.out.println("|   |       * !!ㅣ *        |         *   *         |    [__U__]  [__R__]   |   |");
			System.out.println("|   |         ****          |         *****         |                       |   |");
			System.out.println("|   |                       |                       |                       |   |");
			System.out.println("|   |                       |                       |                       |   |");
			System.out.println("|   |     <RESTAURANT>      |         <CAFE>        |          <PUB>        |   |");
			System.out.println("|   |                       |                       |                       |   |");
			System.out.println("|   |_______________________|_______________________|_______________________|   |");
			System.out.println("|                                                                               |");
			System.out.println("|                   <CASH>      <COIN>      <CARD>      <CARD>                  |");
			System.out.println("|                                                                               |");
			System.out.println("|                  ********     ******      ******     ********                 |");
			System.out.println("|                  |======|     | [] |      | [] |     |======|                 |");
			System.out.println("|                  ********     ******      | [] |     ********                 |");
			System.out.println("|                                           ******                              |");
			System.out.println("|                                   <RECEIPT>                                   |");
			System.out.println("|                             =====================                             |");
			System.out.println("|                             |    ____________   |                             |");
			System.out.println("|                             |   (____________)  |                             |");
			System.out.println("|                             |                   |                             |");
			System.out.println("=================================================================================");
			
			sc.next();		
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}	
		
	}

	// 메인이벤트 출력 메소드
	public void mainEvent()
	{
		Event1 ts = new Event1();
		ts.eventFirst();
		ts.eventDisplay();
	}//end mainEvent

	// 메뉴기준, 식당기준 선택 메소드
	public void mainSelect() throws Exception
	{
		ManagerMenu mm = new ManagerMenu();	// 관리자 메소드 호출
		Gagae gg = new Gagae();				// 가게 메소드 호출
		Master mast = new Master();			// 점주 메소드 호출
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("            ##");
			System.out.println("          #    #");
			System.out.println("        #        #");
			System.out.println("      #            #");
			System.out.println("    #    ________    #");	
			System.out.println("  #      |  ㅣ  |      #");
			System.out.println("#        |  ㅣ  |        #");
			System.out.println("==========WelCome==========");
			System.out.println("|      1. 메뉴기준        |");
			System.out.println("|      2. 식당기준        |");
			System.out.println("===========================");

			System.out.print("원하시는 기준을 입력해 주세요 : ");	// 메뉴 및 식당기준 선택
			int choice;
			choice = sc.nextInt();
			System.out.println();
			

			switch (choice)
			{
				case E_MENU: userMenu(); break;				// 사용자 메뉴 메소드 
				case E_STORE: userStore(); break;			// 사용자 가게 선택 메소드
				case DISPLAY_MANAGER: mm.menu(); break;		// 관리자 메뉴 메소드
				case DISPLAY_MASTER: mast.masMenu(); break;	// 점주   메뉴 메소드
			}	
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			mainSelect();
		}
		
		
	}//end mainSelect
	
	//사용자 메뉴 선택 메소드
	public void userMenu() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Siljuck sj = new Siljuck();						// 실적 클래스 객체 인스턴스 생성

		MapSet ms = new MapSet();						// 전체 메뉴 set에 담기 인스턴스 생성

		MenuFind mf = new MenuFind();					// 해당 메뉴를 포함하는 점포 출력 인스턴스 생성
		
		try
		{
			ms.mainList();									// 전체 메뉴 set에 담는 메소드 호출
			String str;
			
			System.out.println("\n[메뉴이름 선택]");
			System.out.println("====================");
			ms.print();										// 전체 메뉴 중복없이 출력(오름차순)
			System.out.println("====================");
			System.out.println("99. 이전화면");
			System.out.print(">> 메뉴명을 입력하세요 : ");
			str = sc.next();

			if (str.equals("99"))		// 99 입력시 equals 와 비교하여 이전으로 return;
			{
				return;
			}
			
			if (!all.contains(str))
			{
				System.out.println(">> 해당 메뉴는 존재하지 않습니다.");
				System.out.println();
				System.out.println();
				return;
			}

			System.out.printf("\n[%s]\n", str);
			mf.find(str);
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			userMenu();		// userMenu() 메소드로 돌아가는 메소드의 재귀
		}
		
		
	}// enduserMenu

	//사용자 식당 기준 선택 메소드
	public void userStore() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Gagae gg = new Gagae();			// Gagae gg 클래스 인스턴스 생성
		try
		{
			System.out.println("============================");
			System.out.println("1.한식 (Korean Food)");
			System.out.println("2.중식 (Chinese food )");
			System.out.println("3.일식 (Japanese food");
			System.out.println("4.분식 (flour based food)");
			System.out.println("----------------------------");
			System.out.println("99. 이전화면");
			System.out.println("============================");
			System.out.print("원하시는 음식종류를 입력해 주세요 : ");
			String select = sc.next();
			if (select.equals("99"))
			{
				return;
			}
			
			System.out.println();
		
			
			if ("1".equals(select) || "한식".equals(select))		// 1번 또는 한식입력시 선택 가능 조건
			{
				gg.hanShow();
				System.out.println("----------------------------");
				System.out.println("99. 이전화면");
				System.out.println("============================");
				System.out.print( "식당을 입력 해주세요 : ");
				String a = sc.next();
				if (a.equals("99"))
				{
					userStore();
				}
				if (!ghan.containsKey(a))		//ghan 키값 존재여부 확인
				{
				System.out.println("식당 정보를 찾을 수 없습니다.");
				return;
				}
				menuDisplay(a);
			
			}
		

			else if ("2".equals(select) || "중식".equals(select))		// 2번 또는 중식입력시 선택 가능 조건
			{
				gg.chiShow();

				System.out.print( "식당을 입력 해주세요 : ");
				String a = sc.next();
				if (!gchi.containsKey(a))		//gchi 키값 존재여부 확인
				{
					System.out.println("식당 정보를 찾을 수 없습니다.");
					return;
				}
				menuDisplay(a);
			}

			else if ("3".equals(select) || "일식".equals(select))		// 3번 또는 일식입력시 선택 가능 조건
			{
				gg.japShow();

				System.out.print( "식당을 입력 해주세요 : ");
				String a = sc.next();
				if (!gjap.containsKey(a))		//gjap 키값 존재여부 확인
				{
					System.out.println("식당 정보를 찾을 수 없습니다.");
					return;
				}
				menuDisplay(a);
			}

			else if ("4".equals(select) ||"분식".equals(select))		// 4번 또는 분식입력시 선택 가능 조건
			{
				gg.bunShow();

				System.out.print( "식당을 입력 해주세요 : ");
				String a = sc.next();
				if (!gbun.containsKey(a))		//gbun 키값 존재여부 확인
				{
					System.out.println("식당 정보를 찾을 수 없습니다.");
					return;
				}
				menuDisplay(a);
			}
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			userStore();		// userStore() 메소드로 돌아가는 메소드의 재귀
		}
		
		
	}// end userStore()
	
	//사용자 메뉴리스트 출력 디스플레이  메소드
	public void menuDisplay(String a) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String seld = "n";
		String abc;
		int inbun;
		try
		{
			do
			{
				Siljuck sj = new Siljuck();		// Siljuck 클래스 인스턴스 생성

				sj.setGname(a);					// Gname() - >가게 이름 Set

				System.out.println("=====================================================");
				System.out.printf("[     %s     ]\n",a);
				System.out.println();
				if (ghan.containsKey(a))
				{
					System.out.printf("점주 : %s\n",ghan.get(a).getMaster());
					System.out.printf("번호 : %s\n",ghan.get(a).getTel());
					System.out.println();
					System.out.println("번호\t가격   \t  소요시간 \t메뉴");
					System.out.println("----------------------------------------------------");

					Iterator<Integer> it = menu.keySet().iterator();		// ghan 메뉴 전체 출력 Iterator
					
					int q=1;

					while (it.hasNext())
					{
						Integer s = it.next();
						if (menu.get(s).getGagaeName().equals(a))
						{
							//System.out.printf("%2d. %10s %,10d원 %10d분\n",q++, menu.get(s).getMenuName(), menu.get(s).getPrice(), menu.get(s).getTime());

							System.out.printf("%2d. %,7d원 \t%5d분 \t%s \n",q++, menu.get(s).getPrice(), menu.get(s).getTime(), menu.get(s).getMenuName());
						}
					}
				}
				else if (gchi.containsKey(a))
				{
					System.out.printf("점주 : %s\n",gchi.get(a).getMaster());
					System.out.printf("번호 : %s\n",gchi.get(a).getTel());
					System.out.println();
					System.out.println("번호\t가격   \t  소요시간 \t메뉴");
					System.out.println("----------------------------------------------------");

					Iterator<Integer> it1 = menu.keySet().iterator();		// gchi 메뉴 전체 출력 Iterator
					
					int q1=1;

					while (it1.hasNext())
					{
						Integer s1 = it1.next();
						if (menu.get(s1).getGagaeName().equals(a))
						{
							System.out.printf("%2d. %,7d원 \t%5d분 \t%s \n",q1++, menu.get(s1).getPrice(), menu.get(s1).getTime(), menu.get(s1).getMenuName());
																			//순번				가격					소요시간				메뉴
						}
					}
				}
				else if (gjap.containsKey(a))
				{
					System.out.printf("점주 : %s\n",gjap.get(a).getMaster());
					System.out.printf("번호 : %s\n",gjap.get(a).getTel());
					System.out.println();
					System.out.println("번호\t가격   \t  소요시간 \t메뉴");
					System.out.println("----------------------------------------------------");

					Iterator<Integer> it2 = menu.keySet().iterator();			// gjap 메뉴 전체 출력 Iterator
					
					int q2=1;

					while (it2.hasNext())
					{
						Integer s2 = it2.next();
						if (menu.get(s2).getGagaeName().equals(a))
						{
							System.out.printf("%2d. %,7d원 \t%5d분 \t%s \n",q2++, menu.get(s2).getPrice(), menu.get(s2).getTime(), menu.get(s2).getMenuName());
																			//순번				가격					소요시간				메뉴
							//System.out.println( " "+q2++ +"."  + "\t" +menu.get(s2).getPrice() +  "원    " +menu.get(s2).getTime()+"분"+ "\t\t"+ menu.get(s2).getMenuName());
						}
					}
				}
				else if (gbun.containsKey(a))
				{
					System.out.printf("점주 : %s\n",gbun.get(a).getMaster());
					System.out.printf("번호 : %s\n",gbun.get(a).getTel());
					System.out.println();
					System.out.println("번호\t가격   \t  소요시간 \t메뉴");
					System.out.println("----------------------------------------------------");
	 
					Iterator<Integer> it3 = menu.keySet().iterator();			// gbun 메뉴 전체 출력 Iterator
					
					int q3=1;

					while (it3.hasNext())
					{
						Integer s3 = it3.next();
						if (menu.get(s3).getGagaeName().equals(a))
						{
							System.out.printf("%2d. %,7d원 \t%5d분 \t%s \n",q3++, menu.get(s3).getPrice(), menu.get(s3).getTime(), menu.get(s3).getMenuName());
																			//순번				가격					소요시간				메뉴
						}
					}
				}
				
				System.out.println("=======================================================");
				System.out.print(" 메뉴를 입력해 주세요 : ");
				abc = sc.next();
				
				Iterator<Integer> it = menu.keySet().iterator();
				
				int q=1;

				while (it.hasNext())
				{
					Integer s = it.next();

					if (menu.get(s).getGagaeName().equals(a) && menu.get(s).getMenuName().equals(abc))
					{
						sj.setMname(abc);									//실적 클래스에서 메뉴 이름을 받아와  set()
						sj.setPri(menu.get(s).getPrice());					//실적 클래스에서 메뉴이름 키로 가격 받아와  get()
						sj.setJori(menu.get(s).getTime());					//실적 클래스에서 메뉴이름 키로 조리 시간을 받아와  get()
						sj.setGname(menu.get(s).getGagaeName());			//실적 클래스에서 메뉴이름 키로 가게 이름을 받아와  get()

						System.out.print(">> 선택한 메뉴의 갯수를 입력해주세요 : ");
						inbun = sc.nextInt();

						for (int e=0; e<inbun; e++)
						{
							basket.put(n++, sj);
						}
								
						System.out.print("▶ 추가 주문 하시겠습니까?(Y/N) : ");
						seld = sc.next();
						System.out.println();
						
						if (seld.equals("y") || seld.equals("Y"))
							jangbaguni();// 장바구니 메소드
						else if (seld.equals("n") || seld.equals("N"))
						{
							
							jangMenu();
						}


						break;
					}
					else if (!it.hasNext())
						System.out.println("▶ 메뉴를 찾을 수 없습니다.\n");
				}

			}
			while (seld.equals("y") || seld.equals("Y"));
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			menuDisplay(a);
		}
		
		
	}// end menuDispaly

	// 장바구니 메소드 
	public void jangbaguni() 
	{	
		int pp=0;
		int ppp=0;
		int sum=0;
		try
		{
			System.out.println("\n\t[        장바구니          ]");
			System.out.println("**************************************************");

			Iterator<Integer> it = basket.keySet().iterator();
			while (it.hasNext())
			{
				pp = it.next();
				//System.out.println(pp);

				System.out.printf("%2d   | %s | %,d | \t%s(%d)\n", pp+1, basket.get(pp).getGname(), basket.get(pp).getPri(), basket.get(pp).getMname(), pp);
																	//순번			가게이름						가격					메뉴이름	수량
				System.out.println();
				nujeoktime += basket.get(pp).getJori();
				sum += basket.get(pp).getPri();

				if (temp < basket.get(pp).getJori())
				{
					temp = basket.get(pp).getJori();
				}
				ppp++;
							
			}
			
			System.out.println("[조리 대기 시간]");

			//평균 조리시간 출력
			System.out.printf(" ▶ 평균 : %.2f분\n", nujeoktime / (double)(ppp));
			nujeoktime = 0;
			ppp = 0;

			//최대 조리시간 출력
			System.out.printf(" ▶ 최대 : %.2f분\n", (double)temp);
			temp = 0;
			System.out.printf("\n\n[총 금액] : %,d원\n", sum);
			System.out.println("**************************************************\n");
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			jangbaguni();
		}	
	}// end jangbaguni() 


	//장바구니 거래 내용 메소드
	public void jangMenu() throws Exception
	{	
		int cho;
		Casher ch = new Casher();
		Scanner sc = new Scanner(System.in);
		try
		{
			do
			{
				jangbaguni(); // 사용자 jangbaguni() 메소드 호출

				System.out.println(" [ 장바구니 메뉴 ]");
				System.out.println("===================");
				System.out.println(" 1. 결제 진행");
				System.out.println(" 2. 메뉴 삭제");
				System.out.println(" 3. 결제 취소");
				System.out.println("===================\n");

				System.out.print(">> 메뉴를 선택해주세요 : ");
				cho = sc.nextInt();

				switch (cho)
				{
				case 1: ch.cashService(); yes="y"; n=0; break;
				case 2: jangDel(); yes="n"; break;
				case 3: jangExit(); break;
				}
			}
			while (yes.equals("n") || yes.equals("N"));
			
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			jangMenu();
		}

	}// end jangMenu()

	// 장바구니 삭제 메소드
	public void jangDel() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int del;
		try
		{
			System.out.print(">> 삭제할 메뉴이름 옆 (주문번호)를 입력해주세요 : ");
			del = sc.nextInt();
			
			System.out.printf("\n%s | %s | %,d\n\n", basket.get(del).getGname(), basket.get(del).getMname(), basket.get(del).getPri());
			System.out.print(">> 이 메뉴를 삭제하시겠습니까?(Y/N) : ");
			yes = sc.next();
	////////////////////////////////////////////////////////////////////////////////////
			if (yes.equals("y") || yes.equals("Y"))
			{
				
/*
				Iterator<Integer> it = menu.keySet().iterator();

				while (it.hasNext())
				{
					Integer toin = it.next();
					System.out.println(basket.get(del).getMname());

					if (menu.get(toin).getMenuName().equals(basket.get(del).getMname()) && menu.get(toin).getGagaeName().equals(basket.get(del).getGname()))
					{
						menu.get(toin).setMinusSell(1);
						
					}
				}
				*/
				basket.remove(del);
	////////////////////////////////////////////////////////////////////////////////////				

				if (!basket.containsKey(del))
					System.out.println("▶ 삭제되었습니다.");
				else if (basket.containsKey(del))
					System.out.println("▶ 삭제되지 않았습니다.");
			}
			jangbaguni();
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			jangDel();
		}	

	}// end jangDel()
		
	// 장바구니 전체 삭제 메소드
	public void jangExit()
	{
		int y;
		int k=0;
		
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print(">> 장바구니를 비우시겠습니까?(Y/N) : ");
			yes = sc.next();

	
			Iterator<Integer> it = basket.keySet().iterator();
			TreeMap<Integer, MenusVO> tre = new TreeMap<Integer, MenusVO>(menu);
		
		
		

			if (yes.equals("y") || yes.equals("Y"))
			{
				basket.clear();
				/*
				while (it.hasNext())
				{

					/////////////////////////////////////////
					y = it.next();

					if (!basket.containsKey(y))
					{
						k=0;
						continue;
					}
					

					while (menu.size() != k)
					{
						
						if (tre.get(k).getMenuName().equals(basket.get(y).getMname()) && tre.get(k).getGagaeName().equals(basket.get(y).getGname()))
						{
							
							menu.get(k).setMinusSell(1);
							//--number;
						}
						basket.remove(y);
						
						k++;		
						
					}
					/////////////////////////////////////////
					*/
					
						
					
				}
				n=0;
				System.out.println("장바구니가 비워졌습니다.");
			
			}
			catch (Exception ex)
			{
				System.out.println("\n올바르게 입력주세요!\n");
				jangExit();
			}

		}// end jangExit()
}


