package com.project.ssangyong.kiosk;
// 관리자모드를 구현한 class

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

public class ManagerMenu extends Main
{
	// BufferedReader 인스턴스 생성
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static final int MANAGER_MASTERIN = 1;		//-- 점주 등록
	private static final int MANAGER_MASTEROUT = 2;		//-- 점주 삭제

	private static final int MANAGER_GAGAE = 3;			//-- 점포 등록 삭제
	
	private static final int GAGAE_PLUS = 8;			//-- 점포 등록
	private static final int GAGAE_MINUS = 9;			//-- 점포 삭제

	private static final int MANAGER_MENU = 4;			//-- 메뉴 추가 삭제

	private static final int MENU_PLUS = 10;			//-- 메뉴 추가
	private static final int MENU_MINUS = 11;			//-- 메뉴 삭제

	private static final int MANAGER_TODAY = 5;			//-- 당일 총 실적
	private static final int MANAGER_EVENT = 6;			//-- 이벤트 추가/삭제

	private static final int MANAGER_CASH = 7;			//-- 결제 관리
	private static final int CASH_REST = 12;			//-- 거스름돈 현황
	private static final int CASH_UP = 13;				//-- 거스름돈 보충
	private static final int CASH_GET = 14;				//-- 거스름돈 회수

	//final int EXIT = 99;


	private static final String managerKey = "1234asdf";//-- 매니저 비밀번호 설정
	
	public static int select;							//-- 선택 선언(Integer)
	private static String selectS;						//-- 선택 선언(String)

	// menu Display 메소드
	public void menu()
	{
		
		try
		{
			System.out.print("\n>> 비밀번호를 입력하세요 : ");
			String pass = br.readLine();
			
			// 입력된 비밀번호와 등록되어있는 비밀번호 비교
			if (pass.equals(managerKey))
				System.out.println("▶ 인증되었습니다.\n\n");
			else if (!pass.equals(managerKey))
			{
				System.out.println("▶ 접근할 수 없습니다.\n\n");
				return;
			}

			// Event1 인스턴스 생성
			Event1 ts = new Event1();

			// 99번을 눌렀을 때 이전으로 돌아갈 수 있는 반복문 설정
			do
			{
				System.out.println("=====================");
				System.out.println(" [관리자 모드]");
				System.out.println("1. 점주 등록");
				System.out.println("2. 점주 삭제");
				System.out.println("3. 점포 등록 삭제");
				System.out.println("4. 메뉴 추가 삭제");
				System.out.println("5. 당일 실적 총 현황");
				System.out.println("6. 이벤트 추가 삭제");
				System.out.println("7. 결제 관리");
				System.out.println("--------------------");
				System.out.println("99. 이전화면");
				System.out.println("====================");
				System.out.print(">> (1~7중) 선택하세요 : ");

				
				
				select();

				switch (select)
				{
					case MANAGER_MASTERIN: masterKeyIn(); break;
					case MANAGER_MASTEROUT: masterKeyOut(); break;
					case MANAGER_GAGAE: MgagaeMenu(); break;
					case MANAGER_MENU: MmenuMenu(); break;
					case MANAGER_TODAY: managerToday(); break;
					case MANAGER_EVENT: eventControl(); break;
					case MANAGER_CASH: cashMenu(); break;
					case EXIT: return;
				}
		
			}while (true);

		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			menu();
		}
			
		
	
		
		
	}// end menu()


	public void select() throws IOException
	{
		select = Integer.parseInt(br.readLine());
	}



	// 점포 추가 삭제 메소드
	public void MgagaeMenu()
	{
		try
		{
			System.out.print(">> 비밀번호를 입력하세요 : ");
			String temp = br.readLine();
			
			// 입력된 비밀번호와 기존의 비밀번호 비교
			if (temp.equals(managerKey))
				System.out.println("▶ 인증되었습니다.\n\n");
			else if (!temp.equals(managerKey))
			{
				System.out.println("▶ 비밀번호가 틀렸습니다.\n\n");
				return;
			}

			System.out.println("\n[추가 삭제]");
			System.out.println("-------------");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.print("(1,2) 선택하세요. : ");

			// 선택문 호출
			select();

			switch (select + 7)
			{
				case GAGAE_PLUS: MgagaePlus(); break;		//-- 점포 추가
				case GAGAE_MINUS: MgagaeMinus(); break;		//-- 점포 삭제
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			MgagaeMenu();
		}
			
	}// end MgagaeMenu()
		

	// 점포 추가 메소드
	public void MgagaePlus()
	{	
		// Gagae 인스턴스 생성
		Gagae gg = new Gagae();
		try
		{
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 점포 유형을 선택하세요 : ");

			// 점포 종류 변수에 입력받기(Gagae 클래스)
			gg.kind = Integer.parseInt(br.readLine());
			
			switch (gg.kind)
			{
				case 1: gg.addGhan(); break;
				case 2: gg.addGchi(); break;
				case 3: gg.addGjap(); break;
				case 4: gg.addGbun(); break;

			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			MgagaePlus();
		}
		
	}// end MgagaePlus()


	public void MgagaeMinus()
	{
		// Gagae 인스턴스 생성
		Gagae gg = new Gagae();
		try
		{
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 점포 유형을 선택하세요 : ");

			// 점포 종류 변수에 입력받기(Gagae 클래스)
			gg.kind = Integer.parseInt(br.readLine());
			
			switch (gg.kind)
			{
				case 1: gg.delGhan(); break;
				case 2: gg.delGchi(); break;
				case 3: gg.delGjap(); break;
				case 4: gg.delGbun(); break;
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			MgagaeMinus();
		}
		
		
	}// end MmenuMenu()

	// 메뉴 추가 삭제 메소드
	public void MmenuMenu()
	{
		
		try
		{
			System.out.println("\n[추가 삭제]");
			System.out.println("-------------");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.print("(1,2) 선택하세요. : ");
			
			// select 메소드 호출
			select();

			switch (select + 9)
			{
				case MENU_PLUS: MmenuPlus(); break;		//-- 메뉴 추가
				case MENU_MINUS: MmenuMinus(); break;	//-- 메뉴 삭제	
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			MmenuMenu();
		}
		
		
	}


	public void MmenuPlus()
	{
		// Gagae 인스턴스 생성
		Gagae gg = new Gagae();
		try
		{
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 점포 유형을 선택하세요 : ");

			// 점포 종류 변수에 입력받기(Gagae 클래스)
			gg.kind = Integer.parseInt(br.readLine());

			System.out.print("\n>> 점포 이름을 입력하세요 :");
			// 점포 이름 변수에 입력받기(Gagae 클래스)
			gg.nameG = br.readLine();

			// 메뉴 추가 메소드 호출(Gagae 클래스)
			gg.addMenu();
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			MmenuPlus();
		}

		
	}// end MmenuPlus()

	// 메뉴 삭제 메소드
	public void MmenuMinus()
	{
		// Gagae 인스턴스 생성
		Gagae gg = new Gagae();
		try
		{
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 점포 유형을 선택하세요 : ");
			// 점포 종류 변수에 입력받기(Gagae 클래스)
			gg.kind = Integer.parseInt(br.readLine());

			System.out.print("\n>> 점포 이름을 입력하세요 : ");
			// 점포 이름 변수에 입력받기(Gagae 클래스)
			gg.nameG = br.readLine();
			
			// 메뉴 추가 메소드 호출(Gagae 클래스)
			gg.delMenu();
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			MmenuMinus();
		}

		
	}// end MmenuMinus()
///////////////////////////////////////////////////////////////
	
	// 점주 등록 메소드
	public void masterKeyIn()
	{
		// Random 인스턴스 생성
		Random rd = new Random();

		// masterKey 고유문자 생성
		String temp = "mas";

		// 점주 정보 Iterator
		Iterator<String> it = mas.keySet().iterator();
		
		try
		{
			System.out.println("\n [1. 점주 등록]");
			System.out.println("--------------------------");
			System.out.print(">> 점주 이름을 입력하세요 : ");
			// 점주 이름 입력
			String n = br.readLine();


			while (it.hasNext())
			{
				if (mas.get(it.next()).equals(n))
				{
					System.out.println("이미 등록되어있는 점주입니다.");
					return;
				}
			}

			
			System.out.printf("[%s] 이름으로 등록하시겠습니까?(Y/N) : ", n);
			// (Y/N) 입력받기
			selectS = br.readLine();
			

			if (!selectS.equals("y") && !selectS.equals("Y"))
			{
				System.out.println("다시 이용해주시기 바랍니다.\n\n");
				return;
			}

			// 고유식별자 mas + 랜덤8자리 숫자 생성
			for (int i=0; i<8; i++)
			{
				temp += rd.nextInt(10);
			}
			System.out.printf("[%s] Master Key가 발급되었습니다.\n\n\n",temp);

			mas.put(temp,n);
			System.out.println(mas.containsKey(temp));
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			masterKeyIn();
		}

	}// end masterKeyIn()

	// 점주 삭제
	public void masterKeyOut()
	{
		try
		{
			System.out.println("\n [2. 점주 삭제]");
			System.out.print(">> 해당 점주의 Master Key를 입력하세요 : ");
			// MasterKey 입력받기
			String temp = br.readLine();		

			// 점주정보에 해당 입력정보가 존재 할 경우
			if (mas.containsKey(temp))
			{
				System.out.printf(">> [%s], 정말로 삭제하시겠습니까?(Y/N) : ", mas.get(temp));
				String sel = br.readLine();
				if (sel.equals("y") || sel.equals("Y"))
				{
					// 점주정보가 들어가있는 모든 점포 정리
					Iterator<String> it = ghan.keySet().iterator();
					while (it.hasNext())
					{
						String in = it.next();
						if (ghan.get(in).getMaster().equals(mas.get(temp)))
						{
							ghan.remove(in);	
							break;
						}
					}

					Iterator<String> it1 = gchi.keySet().iterator();
					while (it1.hasNext())
					{
						String in = it1.next();
						if (gchi.get(in).getMaster().equals(mas.get(temp)))
						{
							gchi.remove(in);	
							break;
						}
					}

					Iterator<String> it2 = gjap.keySet().iterator();
					while (it2.hasNext())
					{
						String in = it2.next();
						if (gjap.get(in).getMaster().equals(mas.get(temp)))
						{
							gjap.remove(in);	
							break;
						}
					}

					Iterator<String> it3 = gbun.keySet().iterator();
					while (it3.hasNext())
					{
						String in = it3.next();
						if (gbun.get(in).getMaster().equals(mas.get(temp)))
						{
							gbun.remove(in);	
							break;
						}
					}
					
					// 점주 마스터키 완전 삭제
					mas.remove(temp);
					System.out.println("▶ 삭제되었습니다.");
				}
				else if (!sel.equals("y") && !sel.equals("Y"))
					System.out.println("▶ 삭제되지 않았습니다.");
			}
			else if (!mas.containsKey(temp))
				System.out.println("▶ 해당 점주는 등록되어있지 않습니다.");

			System.out.println();
			System.out.println();
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			masterKeyOut();
		}

		
	}// end masterKeyOut()

	// 결제 관리 메소드
	public void cashMenu()
	{
		// Casher 인스턴스 생성
		Casher ch = new Casher();
		
		try
		{
			System.out.println();
			System.out.println("==[7. 결제 관리]==");
			System.out.println("------------------");
			System.out.println("1. 거스름돈 현황");
			System.out.println("2. 거스름돈 보충");
			System.out.println("3. 거스름돈 회수");
			System.out.print(">> (1~3 중) 선택하세요 : ");

			select();

			switch (select+11)
			{
				case CASH_REST: ch.cashRestPrint(); break;
				case CASH_UP: ch.cashRestUp(); break;
				case CASH_GET: ch.cashRestGet(); break;
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			cashMenu();
		}
			
		

		
	}// end cashMenu()


	// 이벤트 설정 메소드
	public void eventControl() throws IOException
	{
		// Event1 인스턴스 생성
		Event1 ts = new Event1();

		// 이벤트 설정 메소드 호출
		ts.eventSel();	

	}// end eventControl()	
	
	// 관리자 당일 총 실적 확인 메소드
	public void managerToday() throws IOException
	{
		Iterator<Integer> it;	// 오늘실적 메뉴(중복허용)
		Iterator<String> its;	// 오늘실적 메뉴
		Iterator<Integer> itc;	// 메뉴 리스트

		// MenuFind 인스턴스 생성
		MenuFind mf = new MenuFind();

		// 출력 번호 변수 선언
		int z=1;

		// Gagae 인스턴스 생성
		Gagae gg = new Gagae();
		
		System.out.print("비밀번호를 입력해주세요 : ");
		String kstr = br.readLine();
		
		// 기존의 입력된 비밀번호와 입력받는 비밀번호가 같은지 비교
		if (!managerKey.equals(kstr))
		{
			System.out.println("확인할 수 없습니다.");
			return;
		}
		System.out.println();
		System.out.println(" [당일 총 실적 현황]\n");
		System.out.println("===============================================");
		System.out.println("번호   가게명\t\t판매량\t가격\t메뉴명");
		
		// 당일 총 실적 Iterator
		it = today.keySet().iterator();

		// 당일 실적 메뉴, 당일 실적 가게 중복없이 정리하기
		while (it.hasNext())
		{
			Integer toint = it.next();
			todayList.add(today.get(toint).getMname());
			todayGagae.add(today.get(toint).getGname());
		}
		System.out.println();
		// 메뉴 Iterator
		itc = menu.keySet().iterator();
			
		// 메뉴와 당일 실적을 비교해서 해당되는 메뉴들 출력
		while (itc.hasNext())
		{
			
			Integer toin = itc.next();
			

			its = todayList.iterator();
		
			while (its.hasNext())
			{
				
				String sss = its.next();
				if (menu.get(toin).getMenuName().equals(sss) && todayGagae.contains(menu.get(toin).getGagaeName()))
				{
					System.out.printf("%2d. [%s] \t %d개\t%,d\t%s\t\n", z++, menu.get(toin).getGagaeName(), menu.get(toin).getSell(), menu.get(toin).getPrice(), menu.get(toin).getMenuName());
					break;
				}

			}
			
			
		
		}
		System.out.println("\n===============================================");
		// 당일 실적 메뉴, 당일 실적 가게 리셋
		todayList.clear();
		todayGagae.clear();
			

	}// end managerToday()

}// class Manager