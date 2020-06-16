package com.project.ssangyong.kiosk;
// 점포, 메뉴의 추가/제거가 구현된 class
// 식당기준 선택시 종류별 식당 출력

import java.util.Random;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;


public class Gagae extends Main			
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	public static String nameG;			// 점포 이름 담을 변수
	private static String nameM;			// 메뉴 이름 담을 변수
	public static int kind;					// 음식 유형 담을 변수
	String n;								// do~while 에 쓰인 변수((y/n)선택)
	String mkey;
	
// 한,중,일,분식 별 점포 등록 메소드=======================================	

	// addGhan 한식당 점포 등록
	public void addGhan() throws IOException			
	{
		Display dis = new Display();

		System.out.println("\n=======[1.점포 등록]=======");
		System.out.print(">> 점포 이름을 입력하세요 : ");
		// 식당 이름 입력
		nameG = br.readLine();
	
		ghan.put(nameG, new GagaeVO());			// 이름을 key로 식당 정보 생성
		
		ghan.get(nameG).setKind(dis.DISPLAY_KOR);

		System.out.print(">> 점주의 이름을 입력하세요 : ");
		ghan.get(nameG).setMaster(br.readLine());

		System.out.print(">> 점포의 전화번호를 입력하세요 : ");
		ghan.get(nameG).setTel(br.readLine());

		addMenu();		// 메뉴 추가 method 호출

		if (ghan.containsKey(nameG) || mas.containsKey(mkey))
			System.out.println("▶ 점포가 정상적으로 등록되었습니다.\n\n");
		else if (!gbun.containsKey(nameG))
			System.out.println("▶ 점포가 추가되지 않았습니다.\n\n");
	}
	//--------------------------------------------- addGhan 한식당 점포 등록


	// addGchi 중식당 점포 등록
	public void addGchi() throws IOException			
	{
		Display dis = new Display();

		System.out.println("\n=======[1.점포 등록]=======");
		System.out.print(">> 점포 이름을 입력하세요 : ");
	
		nameG = br.readLine();
	
		gchi.put(nameG, new GagaeVO());
		
		gchi.get(nameG).setKind(dis.DISPLAY_CHI);

		System.out.print(">> 점주의 이름을 입력하세요 : ");
		gchi.get(nameG).setMaster(br.readLine());

		System.out.print(">> 점포의 전화번호를 입력하세요 : ");
		gchi.get(nameG).setTel(br.readLine());

		addMenu();		

		if (gchi.containsKey(nameG) || mas.containsKey(mkey))
			System.out.println("▶ 점포가 정상적으로 등록되었습니다.\n\n");
		else if (!gbun.containsKey(nameG))
			System.out.println("▶ 점포가 추가되지 않았습니다.\n\n");
	}
	// --------------------------------------------addGchi 중식당 점포 등록


	// addGjap 일식당 점포 등록
	public void addGjap() throws IOException			
	{
		Display dis = new Display();

		System.out.println("\n=======[1.점포 등록]=======");
		System.out.print(">> 점포 이름을 입력하세요 : ");
		
		nameG = br.readLine();
	
		gjap.put(nameG, new GagaeVO());	
		
		gjap.get(nameG).setKind(dis.DISPLAY_JAP);

		System.out.print(">> 점주의 이름을 입력하세요 : ");
		gjap.get(nameG).setMaster(br.readLine());

		System.out.print(">> 점포의 전화번호를 입력하세요 : ");
		gjap.get(nameG).setTel(br.readLine());

		addMenu();	

		if (gjap.containsKey(nameG) || mas.containsKey(mkey))
			System.out.println("▶ 점포가 정상적으로 등록되었습니다.\n\n");
		else if (!gbun.containsKey(nameG))
			System.out.println("▶ 점포가 추가되지 않았습니다.\n\n");
	}
	// --------------------------------------------addGjap 일식당 점포 등록


	// addGbun 분식 점포 등록
	public void addGbun() throws IOException			
	{
		Display dis = new Display();

		System.out.println("\n=======[1.점포 등록]=======");
		System.out.print(">> 점포 이름을 입력하세요 : ");
		// 식당 이름 입력
		nameG = br.readLine();
	
		gbun.put(nameG, new GagaeVO());	

		gbun.get(nameG).setKind(dis.DISPLAY_BUN);

		System.out.print(">> 점주의 이름을 입력하세요 : ");
		gbun.get(nameG).setMaster(br.readLine());

		System.out.print(">> 점포의 전화번호를 입력하세요 : ");
		gbun.get(nameG).setTel(br.readLine());

		addMenu();	

		if (gbun.containsKey(nameG) || mas.containsKey(mkey))
			System.out.println("▶ 점포가 정상적으로 등록되었습니다.\n\n");
		else if (!gbun.containsKey(nameG))
			System.out.println("▶ 점포가 추가되지 않았습니다.\n\n");
	}
	// ------------------------------------------- addGbun 분식 점포 등록
	


// 	한,중,일,분식 별 식당 삭제 메소드======================================= 

	public void delGhan() throws IOException		// 식당 삭제 method
	{							
		do
		{
			System.out.println("\n=======[점포삭제]=======");
			System.out.print(">> 점포 이름을 입력하세요 : ");
			nameG = br.readLine();
			
			if (ghan.containsKey(nameG))
			{	
				System.out.print(">> 마스터키를 입력하세요 : ");
				mkey = br.readLine();

				if (mas.get(mkey).equals(ghan.get(nameG).getMaster()))
				{
					ghan.remove(nameG);
					System.out.printf("\n▶ [ %s ] 점포가 정상적으로 삭제되었습니다.\n\n", nameG);
				}
				else if (!mas.get(mkey).equals(ghan.get(nameG).getMaster()) || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");
			}
			else if (!ghan.containsKey(nameG))
				System.out.print("▶ 해당 점포가 존재하지 않습니다.\n\n"); 

			System.out.print(">> 점포 삭제를 계속하시겠습니까? (y/n) : ");
			n = br.readLine();
			System.out.println();
		}
		while (n.equals("y"));
	}
	// -----------------------------------------------delGhan 한식당 삭제


	// delGchi 중식당 삭제
	public void delGchi() throws IOException		
	{								
		do
		{
			System.out.println("\n=======[점포삭제]=======");
			System.out.print(">> 점포 이름을 입력하세요. : ");
			nameG = br.readLine();
		
			if (ghan.containsKey(nameG))
			{		
				System.out.print(">> 마스터키를 입력하세요 : ");
				mkey = br.readLine();

				if (mas.get(mkey).equals(gchi.get(nameG).getMaster()))
				{
					gchi.remove(nameG);
					System.out.printf("\n▶ [ %s ] 점포가 정상적으로 삭제되었습니다.\n\n", nameG);
				}
				else if (!mas.get(mkey).equals(gchi.get(nameG).getMaster()) || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");
			}
			else if (!ghan.containsKey(nameG))
				System.out.print("▶ 해당 점포가 존재하지 않습니다.\n\n"); 

			System.out.print(">> 점포 삭제를 계속하시겠습니까? (y/n) : ");
			n = br.readLine();
			System.out.println();
		}
		while (n.equals("y"));
	}
	// -----------------------------------------------delGchi 중식당 삭제
	

	// delGjap 일식당 삭제
	public void delGjap() throws IOException		
	{								
		do
		{
			System.out.println("\n=======[점포삭제]=======");
			System.out.print(">> 점포 이름을 입력하세요. : ");
			nameG = br.readLine();
		
			if (ghan.containsKey(nameG))
			{	
				System.out.print(">> 마스터키를 입력하세요 : ");
				mkey = br.readLine();
					
				System.out.printf("%s", gjap.get(nameG).getMaster());
				if (mas.get(mkey).equals(gjap.get(nameG).getMaster()))
				{
					gjap.remove(nameG);
					System.out.printf("\n▶ [ %s ] 점포가 정상적으로 삭제되었습니다.\n\n", nameG);
				}
				else if (!mas.get(mkey).equals(gjap.get(nameG).getMaster()) || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");
			}
			else if (!gjap.containsKey(nameG))
				System.out.print("▶ 해당 점포가 존재하지 않습니다.\n\n"); 

			System.out.print(">> 점포 삭제를 계속하시겠습니까? (y/n) : ");
			n = br.readLine();
			System.out.println();
		}
		while (n.equals("y"));
	}
	// -----------------------------------------------delGjap 일식당 삭제


	// delGbun 분식점 삭제
	public void delGbun() throws IOException		
	{						
		do
		{
			System.out.println("\n=======[점포삭제]=======");
			System.out.print(">> 점포 이름을 입력하세요. : ");
			nameG = br.readLine();
		
			if (gbun.containsKey(nameG))
			{	
				System.out.print(">> 마스터키를 입력하세요 : ");
				mkey = br.readLine();

				if (mas.get(mkey).equals(gbun.get(nameG).getMaster()))
				{
					gbun.remove(nameG);
					System.out.printf("\n▶ [ %s ] 점포가 정상적으로 삭제되었습니다.\n\n", nameG);
				}
				else if (!mas.get(mkey).equals(gbun.get(nameG).getMaster()) || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");
			}
			else if (!gbun.containsKey(nameG))
				System.out.print("▶ 해당 점포가 존재하지 않습니다.\n\n"); 

			System.out.print(">> 점포 삭제를 계속하시겠습니까? (y/n) : ");
			n = br.readLine();
			System.out.println();
		}
		while (n.equals("y"));
	}
	// -----------------------------------------------delGbun 분식 삭제


	// 	메뉴 등록 메소드========================================================
	public void addMenu() throws IOException	
	{		
			
		Display dis = new Display();
		
		if (!ghan.containsKey(nameG) && !gchi.containsKey(nameG) && !gjap.containsKey(nameG) && !gbun.containsKey(nameG))
			System.out.println("▶ 해당 점포는 존재하지 않습니다.\n\n");
		else if (ghan.containsKey(nameG) || gchi.containsKey(nameG) || gjap.containsKey(nameG) || gbun.containsKey(nameG))
		{		
			System.out.print(">> 마스터키를 입력하세요 : ");
			mkey = br.readLine();
			System.out.println();
					
			if (kind==dis.DISPLAY_KOR)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(ghan.get(nameG).getMaster()))
				{
					System.out.println("\n=================[메뉴 추가]=================");
					do
					{
						System.out.print(">> 메뉴 이름, 가격, 조리시간을 입력하세요 : ");
						nameM = sc.next();
						int pri = sc.nextInt();
						int tim = sc.nextInt();

						menu.put(num++, new MenusVO(nameM, nameG, pri, tim));

						if (menu.containsKey(menu.size()-1))										// menu의 크기를 이용해 key 얻어내기 (num=0)	// Iterator로 대체 가능
							System.out.println("▶ 메뉴가 정상적으로 추가되었습니다.\n\n");
						else
							System.out.println("▶ 메뉴가 추가되지 않았습니다.\n\n");

						System.out.print(">> 메뉴 입력을 계속하시겠습니까? (y/n) : ");
						n = br.readLine();
						System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(ghan.get(nameG).getMaster()) )
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");


			}
			else if (kind==dis.DISPLAY_CHI)
			{
				if (mas.get(mkey).equals(gchi.get(nameG).getMaster()))
				{
					System.out.println("\n=================[메뉴 추가]=================");
					do
					{
						System.out.print(">> 메뉴 이름, 가격, 조리시간을 입력하세요 : ");
						nameM = sc.next();
						int pri = sc.nextInt();
						int tim = sc.nextInt();

						menu.put(num++, new MenusVO(nameM, nameG, pri, tim));

						if (menu.containsKey(menu.size()-1))										// menu의 크기를 이용해 key 얻어내기 (num=0)	// Iterator로 대체 가능
							System.out.println("▶ 메뉴가 정상적으로 추가되었습니다.\n\n");
						else
							System.out.println("▶ 메뉴가 추가되지 않았습니다.\n\n");

						System.out.print(">> 메뉴 입력을 계속하시겠습니까? (y/n) : ");
						n = br.readLine();
						System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.get(mkey).equals(gchi.get(nameG).getMaster())  || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");


			}
			else if (kind==dis.DISPLAY_JAP)
			{
				if (mas.get(mkey).equals(gjap.get(nameG).getMaster()))
				{
					System.out.println("\n=================[메뉴 추가]=================");
					do
					{
						System.out.print(">> 메뉴 이름, 가격, 조리시간을 입력하세요 : ");
						nameM = sc.next();
						int pri = sc.nextInt();
						int tim = sc.nextInt();

						menu.put(num++, new MenusVO(nameM, nameG, pri, tim));

						if (menu.containsKey(menu.size()-1))										// menu의 크기를 이용해 key 얻어내기 (num=0)	// Iterator로 대체 가능
							System.out.println("▶ 메뉴가 정상적으로 추가되었습니다.\n\n");
						else
							System.out.println("▶ 메뉴가 추가되지 않았습니다.\n\n");

						System.out.print(">> 메뉴 입력을 계속하시겠습니까? (y/n) : ");
						n = br.readLine();
						System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.get(mkey).equals(gjap.get(nameG).getMaster())  || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");


			}
			else if (kind==dis.DISPLAY_BUN)
			{
				if (mas.get(mkey).equals(gbun.get(nameG).getMaster()))
				{
					System.out.println("\n=================[메뉴 추가]=================");
					do
					{
						System.out.print(">> 메뉴 이름, 가격, 조리시간을 입력하세요 : ");
						nameM = sc.next();
						int pri = sc.nextInt();
						int tim = sc.nextInt();

						menu.put(num++, new MenusVO(nameM, nameG, pri, tim));

						if (menu.containsKey(menu.size()-1))										// menu의 크기를 이용해 key 얻어내기 (num=0)	// Iterator로 대체 가능
							System.out.println("▶ 메뉴가 정상적으로 추가되었습니다.\n\n");
						else
							System.out.println("▶ 메뉴가 추가되지 않았습니다.\n\n");

						System.out.print(">> 메뉴 입력을 계속하시겠습니까? (y/n) : ");
						n = br.readLine();
						System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.get(mkey).equals(gbun.get(nameG).getMaster())  || !mas.containsKey(mkey))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");
			}
		}
	}


	// 메뉴 삭제 메소드 ===========================================================	
	public void delMenu() throws IOException
    {

		Display dis = new Display(); 
      
		if (!ghan.containsKey(nameG) && !gchi.containsKey(nameG) && !gjap.containsKey(nameG) && !gbun.containsKey(nameG))   
			 System.out.print("▶ 해당 식당은 존재하지 않습니다.\n\n");
		else if (ghan.containsKey(nameG) || gchi.containsKey(nameG) || gjap.containsKey(nameG) || gbun.containsKey(nameG))
		{   
			System.out.print(">> 마스터키를 입력하세요 : ");
			mkey = br.readLine();
			System.out.println();

			if (kind==dis.DISPLAY_KOR)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(ghan.get(nameG).getMaster()))
				{
					System.out.println("\n=======[메뉴 삭제]=======");         
					do
					{
						 System.out.print(">> 메뉴를 입력하세요 : ");
						 nameM = br.readLine();

						 Iterator<Integer> itt = menu.keySet().iterator(); 
						 while (itt.hasNext())
						 {
							 Integer jong = itt.next();
							 if (menu.get(jong).getMenuName().equals(nameM) && menu.get(jong).getGagaeName().equals(nameG))
							 {
								 menu.remove(jong);
								 System.out.print("▶ 메뉴가 정상적으로 삭제되었습니다.\n\n");
								 break;
							 }
							 else if (! itt.hasNext())
								 System.out.print("▶ 해당 메뉴가 존재하지 않습니다.\n\n");
						 }
						 System.out.print(">> 메뉴 삭제를 계속하시겠습니까? (y/n) : ");
						 n = br.readLine();
						 System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(ghan.get(nameG).getMaster()) )
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");


			}
			if (kind==dis.DISPLAY_CHI)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(gchi.get(nameG).getMaster()))
				{
					System.out.println("\n=======[메뉴 삭제]=======");         
					do
					{
						 System.out.print(">> 메뉴를 입력하세요 : ");
						 nameM = br.readLine();

						 Iterator<Integer> itt = menu.keySet().iterator(); 
						 while (itt.hasNext())
						 {
							 Integer jong = itt.next();
							 if (menu.get(jong).getMenuName().equals(nameM) && menu.get(jong).getGagaeName().equals(nameG))
							 {
								 menu.remove(jong);
								 System.out.print("▶ 메뉴가 정상적으로 삭제되었습니다.\n\n");
								 break;
							 }
							 else if (! itt.hasNext())
								 System.out.print("▶ 해당 메뉴가 존재하지 않습니다.\n\n");
						 }
						 System.out.print(">> 메뉴 삭제를 계속하시겠습니까? (y/n) : ");
						 n = br.readLine();
						 System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gchi.get(nameG).getMaster()) )
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");


			}
			if (kind==dis.DISPLAY_JAP)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(gjap.get(nameG).getMaster()))
				{
					System.out.println("\n=======[메뉴 삭제]=======");         
					do
					{
						 System.out.print(">> 메뉴를 입력하세요 : ");
						 nameM = br.readLine();

						 Iterator<Integer> itt = menu.keySet().iterator(); 
						 while (itt.hasNext())
						 {
							 Integer jong = itt.next();
							 if (menu.get(jong).getMenuName().equals(nameM) && menu.get(jong).getGagaeName().equals(nameG))
							 {
								 menu.remove(jong);
								 System.out.print("▶ 메뉴가 정상적으로 삭제되었습니다.\n\n");
								 break;
							 }
							 else if (! itt.hasNext())
								 System.out.print("▶ 해당 메뉴가 존재하지 않습니다.\n\n");
						 }
						 System.out.print(">> 메뉴 삭제를 계속하시겠습니까? (y/n) : ");
						 n = br.readLine();
						 System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gjap.get(nameG).getMaster()) )
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");


			}
			if (kind==dis.DISPLAY_BUN)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(gbun.get(nameG).getMaster()))
				{
					System.out.println("\n=======[메뉴 삭제]=======");         
					do
					{
						 System.out.print(">> 메뉴를 입력하세요 : ");
						 nameM = br.readLine();

						 Iterator<Integer> itt = menu.keySet().iterator(); 
						 while (itt.hasNext())
						 {
							 Integer jong = itt.next();
							 if (menu.get(jong).getMenuName().equals(nameM) && menu.get(jong).getGagaeName().equals(nameG))
							 {
								 menu.remove(jong);
								 System.out.print("▶ 메뉴가 정상적으로 삭제되었습니다.\n\n");
								 break;
							 }
							 else if (! itt.hasNext())
								 System.out.print("▶ 해당 메뉴가 존재하지 않습니다.\n\n");
						 }
						 System.out.print(">> 메뉴 삭제를 계속하시겠습니까? (y/n) : ");
						 n = br.readLine();
						 System.out.println();
					}
					while (n.equals("y"));
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gbun.get(nameG).getMaster()) )
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");
			}
		}
	}

	

// Display에서 식당기준 선택시 종류별 식당 출력 메소드====================================
	public void hanShow()
	{
		System.out.println(" ====[ 한식당 ]==== \n");
		Iterator<String> it1 = ghan.keySet().iterator();
		int i=1;
		while (it1.hasNext())
		{
			String s1 = it1.next();
			System.out.printf("%d. %s\n",i++, s1);
		}
		System.out.println();
	}


	public void chiShow()
	{
		System.out.println(" ====[ 중식당 ]==== \n");
		int i=1;
		Iterator<String> it2 = gchi.keySet().iterator();
		while (it2.hasNext())
		{
			String s2 = it2.next();
			System.out.printf("%d. %s\n", i++, s2);
		}
		System.out.println();

	}


	public void japShow()
	{
		System.out.println(" ====[ 일식당 ]==== \n");
		int i=1;
		Iterator<String> it3 = gjap.keySet().iterator();
		while (it3.hasNext())
		{
			String s3 = it3.next();
			System.out.printf("%d. %s\n", i++, s3);
		}
		System.out.println();

	}


	public void bunShow()
	{
		System.out.println(" ====[ 분식점 ]==== \n");
		int i=1;
		Iterator<String> it4 = gbun.keySet().iterator();
		while (it4.hasNext())
		{
			String s4 = it4.next();
			System.out.printf("%d. %s\n", i++, s4);
		}
		System.out.println();

	}

} // end - public class Gagae extends Main