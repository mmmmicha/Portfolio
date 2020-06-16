package com.project.ssangyong.kiosk;
// 점주모드를 구현한 class

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;

public class Master extends Main
{
	private static final int MASTER_GAGAE = 1;		//-- 점주 점포 추가/삭제

	private static final int GAGAE_PLUS = 5;		//-- 점주 점포 추가
	private static final int GAGAE_MINUS = 6;		//-- 점주 점포 삭제

	private static final int MASTER_MENU = 2;		//-- 점주 메뉴 추가/삭제

	private static final int MENU_PLUS = 7;			//-- 점주 메뉴 추가
	private static final int MENU_MINUS = 8;		//-- 점주 메뉴 삭제

	private static final int MASTER_TODAY = 3;		//-- 점주 당일 실적

	private static final int MASTER_EVENT = 4;		//-- 점주 이벤트 추가/삭제

	private static int select;						//-- 선택 Integer
	private static String selectS;					//-- 선택 String
	static String pass;								//-- masterKey 입력 받을 변수 선언

	// BufferedReader 인스턴스 생성
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	

	// 점주모드 메인 Display용 메소드
	public void masMenu()
	{
		try
		{
			// MasterKey 입력 받기
			System.out.print("\n>> Master Key 를 입력하세요 : ");
			pass = br.readLine();
			System.out.println(mas.get(pass));

			
			// MasterKey가 이미 등록이 되어 있는지 확인
			if (mas.containsKey(pass))
			{
				System.out.println(">> 인증되었습니다.");
				System.out.println();
				System.out.println();
			}
			else if (!mas.containsKey(pass))
			{
				System.out.println(">> 접근할 수 없습니다.");
				System.out.println();
				System.out.println();
				return;
			}

			// Event1 인스턴스 생성
			Event1 ts = new Event1();
			
			// 99번 눌렀을 시 이전화면으로 돌아갈 수 있는 반복문 구성
			do
			{
				System.out.println("=====================");
				System.out.println("   [점주 모드]");
				System.out.println("1. 점포 등록 삭제");
				System.out.println("2. 메뉴 추가 삭제");
				System.out.println("3. 당일 실적 현황");
				System.out.println("4. 이벤트 추가 삭제");
				System.out.println("---------------------");
				System.out.println("99. 이전화면");
				System.out.println("=====================");
				System.out.print(">> (1~4중) 선택하세요 : ");
				select();
				

				switch (select)
				{
					case MASTER_GAGAE: gagaeMenu(); break;		// 점포 등록 삭제
					case MASTER_MENU: menuMenu(); break;		// 메뉴 추가 삭제
					case MASTER_TODAY: masterToday(); break;	// 당일 실적 현황
					case MASTER_EVENT: ts.eventStore();break;	// 이벤트 추가 삭제
					case EXIT: return;							// 99번
				
				}
			}
			while (true);
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			masMenu();
		}
		

			
		
	}// end masMenu()


	// 입력받는 메소드 선언
	public void select() throws IOException
	{

		select = Integer.parseInt(br.readLine());

	}// end select()

	// 점포 추가 삭제 Display 메소드
	public void gagaeMenu()
	{
		try
		{
			System.out.println("\n[추가 삭제]");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.println("---------------------");
			System.out.println("99. 이전화면");
			System.out.println("=====================");
			System.out.print("(1,2) 선택하세요. : ");
			
			select();

			switch (select + 4)
			{
				case GAGAE_PLUS: gagaePlus(); break;
				case GAGAE_MINUS: gagaeMinus(); break;
				case EXIT +4 : masMenu(); break;
			
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			gagaeMenu();
		}
			
		
	}// end gagaeMenu()
	
	// 점포 추가 메소드
	public void gagaePlus()
	{	
		try
		{
			Gagae gg = new Gagae();
			Display dis = new Display();

			// 점포를 어떤류로 생성할 지 설정
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 식당 유형을 선택하세요 : ");
			gg.kind = Integer.parseInt(br.readLine());
			
			switch (gg.kind)
			{
			case 1: gg.addGhan(); break;	// 한식
			case 2: gg.addGchi(); break;	// 중식
			case 3: gg.addGjap(); break;	// 일식
			case 4: gg.addGbun(); break;	// 분식
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			gagaePlus();
		}
		
		

	}// end gagaePlus()

	// 점포 삭제 메소드
	public void gagaeMinus()
	{	
		try
		{
			// 점포 인스턴스 생성
			Gagae gg = new Gagae();

			// 어떤류의 점포를 삭제할 지 선택
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 식당 유형을 선택하세요 : ");
			gg.kind = Integer.parseInt(br.readLine());
			
			switch (gg.kind)
			{
				case 1: gg.delGhan(); break;	// 한식
				case 2: gg.delGchi(); break;	// 중식
				case 3: gg.delGjap(); break;	// 일식
				case 4: gg.delGbun(); break;	// 분식
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			gagaeMinus();
		}
			
		
	}//end gagaeMinus()

	// 메뉴 추가 삭제 메소드
	public void menuMenu()
	{
		try
		{
			System.out.println("\n [추가 삭제]");
			System.out.println("--------------");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.print("(1,2) 선택하세요. : ");

			select();

			switch (select + 6)
			{
				case MENU_PLUS: menuPlus(); break;		// 메뉴 추가
				case MENU_MINUS: menuMinus(); break;	// 메뉴 삭제	
			}
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			menuMenu();
		}
			
		
		
	}// end menuMenu()

	// 메뉴 추가 메소드
	public void menuPlus()
	{
		try
		{
			// Gagae 인스턴스 생성
			Gagae gg = new Gagae();

			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 점포 유형을 선택하세요 : ");
			gg.kind = Integer.parseInt(br.readLine());
		
			System.out.print("\n>> 점포 이름을 입력하세요 :");
			gg.nameG = br.readLine();
			
			// 메뉴 추가 메소드 호출(Gagae 클래스)
			gg.addMenu();
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			menuPlus();
		}
		
		
	}// end menuPlus()


	// 메뉴 삭제 메소드
	public void menuMinus()
	{
		try
		{
			// Gagae 인스턴스 생성
			Gagae gg = new Gagae();

			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 점포 유형을 선택하세요 : ");
			gg.kind = Integer.parseInt(br.readLine());

		
			System.out.print("\n>> 점포 이름을 입력하세요 :");
			gg.nameG = br.readLine();
			
			// 메뉴 삭제 메소드 호출(Gagae 클래스)
			gg.delMenu();
				
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			menuMinus();
		}
		
		
	}// end menuMinus()

	// 점주 당일 실적 출력 메소드
	public void masterToday()
	{
		
		try
		{	

			// 실적 순서 출력용 변수 선언
			int z=1;
		
			// Gagae 인스턴스 생성
			Gagae gg = new Gagae();
			String kstr = "";	//-- masterKey 입력 받기용 변수 선언
			System.out.println();
			System.out.print("식당이름을 입력해주세요 : ");
			String gstr = br.readLine();	//-- 식당이름 입력 받기용 변수 선언
			System.out.print("Master Key 를 입력해주세요 : ");
			kstr = br.readLine();

			// 애초에 들어온 masterKey와 동일하지 않는 정보에 접근하려고 할 때 거를수 있는 조건
			if (!(pass.equals(kstr)))
			{
				System.out.println("다른 점주의 정보는 이용하실 수 없습니다.");
				return;
			}
			
			// 등록되지 않은 masterKey에 대한 접근제한 조건
			if (ghan.containsKey(gstr))
			{
				if (!ghan.get(gstr).getMaster().equals(mas.get(kstr)))
				{
					System.out.println("확인할 수 없습니다.");
					return;
				}
			}
			else if (gchi.containsKey(gstr))
			{
				if (!gchi.get(gstr).getMaster().equals(mas.get(kstr)))
				{
					System.out.println("확인할 수 없습니다.");
					return;
				}
			}
			else if (gjap.containsKey(gstr))
			{
				if (!gjap.get(gstr).getMaster().equals(mas.get(kstr)))
				{
					System.out.println("확인할 수 없습니다.");
					return;
				}
			}
			else if (gbun.containsKey(gstr))
			{
				if (!gbun.get(gstr).getMaster().equals(mas.get(kstr)))
				{
					System.out.println("확인할 수 없습니다.");
					return;
				}
			}
			else
			{
				System.out.println("해당 식당 혹은 키가 존재하지 않습니다.");
				return;
			}
				
				
			
			// 당일 실적 현황(해당 점주에 한해서) 출력
			System.out.println();
			System.out.printf("['%s' 당일실적현황]\n",gstr);
			System.out.println("=============================================\n");
			System.out.println("번호   가게명\t\t판매량\t가격\t메뉴명");
			
			Iterator<Integer> it = today.keySet().iterator();	// 당일 총실적 누적 자료구조에 대한 Iterator
			Iterator<Integer> its = menu.keySet().iterator();	// 메뉴 자료구조에 대한 Iterator
			Iterator<String> itss = todayList.iterator();		// 당일 총실적에서 중복된 부분을 없애기 위해 set으로 변환 Iterator


			// 당일 실적 메뉴리스트와 가게 이름리스트 중복되지 않도록 담기
			while (it.hasNext())
			{
				int ipp = it.next();
				todayList.add(today.get(ipp).getMname());
				todayGagae.add(today.get(ipp).getGname());

			}

			// 메뉴 Iterator 재선언
			its = menu.keySet().iterator();
			while (its.hasNext())		
			{
				Integer toin = its.next();
				

				// 중복되지 않은 당일실적 Iterator
				itss = todayList.iterator();
				while (itss.hasNext())
				{
					String toint = itss.next();

					// 당일 메뉴이름과 가게이름까지 동일하면 그 실적을 출력
					if (menu.get(toin).getMenuName().equals(toint) && menu.get(toin).getGagaeName().equals(gstr))
					{
						System.out.printf("%2d. [%s] \t %d개\t%,d\t%s\t\n", z++, menu.get(toin).getGagaeName(), menu.get(toin).getSell(), menu.get(toin).getPrice(), menu.get(toin).getMenuName());
					}
				}
			}
			System.out.println("\n=============================================");
			
		}
		catch (Exception ex)
		{
			System.out.println("\n올바르게 입력주세요!\n");
			masterToday();
		}
		

		
		

	}// end masterToday()
}// class Master