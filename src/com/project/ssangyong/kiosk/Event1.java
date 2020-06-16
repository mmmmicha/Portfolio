package com.project.ssangyong.kiosk;
// 이벤트 기본 세팅
// 관리자, 점주의 이벤트를 추가/제거/수정 하게 구현한 class

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;


public class Event1 extends Main
{
	 
    private static String names;			// 가게이름
	private static String evs;				// 가게이벤트
	private static String con;				// yes, no
	public static final int E_MASTER =1;	//관리자 이벤트 관리모드   
	public static final int E_STORE =2;     //가게 이벤트 관리모드


	public void eventMasterm()   //전체이벤트 -- 기본설정
	{
		master.put("1","키오스크에 관한 문의사항 또는 기계고장시 ▷ 010-7338-1257 ◁");
	}


	public void eventStorem()  //가게이벤트 -- 기본설정
	{
		ht.put("은채의인생떡볶이","점심시간 한정(12:00~14:00) 쿨피스 공짜!!");
		ht.put("스시를범하다", "미니우동 서비스 ★오픈이벤트★");
		ht.put("밥맛스러운광현", "SNS 홍보시 음료수 공짜!!!");
		ht.put("민하의쌈싸라","방문포장시 삼겹살 2+1!!");
		ht.put("중국집의정석","★1주년 이벤트★ 탕수육 2000원 할인!!");		
	}

	public void eventFirst()  //전체 공지 출력해주는 메소드
	{
		System.out.println("\t\t※※※ 전체 공지 ※※※\n");
		Iterator<String> it =master.keySet().iterator();

		while (it.hasNext())
		{
			String s = it.next();
			System.out.printf("%3s. %s\n\n", s, master.get(s));
		}
		System.out.println();	
	}
		

	public void eventDisplay()  //가게 이벤트 출력해주는 메소드
	{
		System.out.println("====================[○오늘의 특가 이벤트○]====================\n");
		Iterator<String> it = ht.keySet().iterator();

		while (it.hasNext())
		{
			String s = it.next();
			System.out.printf("%s : %s\n\n", s, ht.get(s));
		}
		System.out.println("================================================================\n");
	}


	public void eventSel()throws IOException  //관리자가 (관리자, 점주)이벤트 관리하는 메소드
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("[이벤트 관리모드]");
		System.out.println("1. 관리자");
		System.out.println("2. 점주");
		System.out.print(">> 입력 : ");
		int a = Integer.parseInt(br.readLine());

		switch (a)
		{
		case E_MASTER : eventMaster();break;
		case E_STORE : eventStore();break;	
		}		
	}


	public void eventMaster()throws IOException  //관리자 이벤트 메소드
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("\n1. 이벤트 수정");
		System.out.println("2. 이벤트 추가");
		System.out.println("3. 이벤트 삭제");
		System.out.print(">> 입력 : ");
		int a = Integer.parseInt(br.readLine());

		if (a==1)   // 관리자 이벤트 수정메뉴 → 현재 입력된 공지사항을 수정
		{
			System.out.println("\t\t  [관리자 이벤트 수정 메뉴]\n");
			System.out.println("\t\t ==▶현재 입력된 관리자 이벤트◀==\n");

			Iterator<String> it = master.keySet().iterator();
			while (it.hasNext())
			{
				String s = it.next();
				System.out.printf("%3s. %s\n\n", s, master.get(s));
			}
			System.out.println();

			System.out.print(">> 수정할 번호 입력 : ");    //전체공지 수정할 번호 입력받음
			names = br.readLine();                  

			if (!master.containsKey(names))
				System.out.println("\n▶ 번호가 존재하지 않습니다.\n\n");  //입력받은 공지가없으면 안내
			else
			{
				System.out.print(">> 수정할 이벤트 내용입력 : ");
				evs =br.readLine();

				master.put(names,evs);

				System.out.println("▶ 정상적으로 수정되었습니다.\n\n");
			}
		}
		else if (a==2)  //관리자 이벤트 추가 메뉴
		{
			System.out.println("\t\t  [관리자 이벤트 추가 메뉴]\n");
			System.out.println("\t\t ==▶현재 입력된 관리자 이벤트◀==\n");

			Iterator<String> it = master.keySet().iterator();
			while (it.hasNext())
			{
				String s = it.next();
				System.out.printf("%s : %s\n\n", s, master.get(s));
			}
			System.out.println();

			System.out.print(">> 추가할 번호 입력 : ");  
			names = br.readLine();
			System.out.print(">> 추가할 이벤트 내용 : ");
			evs = br.readLine();

			master.put(names,evs);

			System.out.println("▶ 정상적으로 추가되었습니다.\n\n");
		}
		else if (a==3)   //관리자 이벤트 전체 삭제 메뉴
		{
			System.out.println("\t\t  [관리자 이벤트 삭제 메뉴]\n");
			System.out.println("\t\t ==▶현재 입력된 관리자 이벤트◀==\n");

			Iterator<String> it = master.keySet().iterator();
			while (it.hasNext())
			{
				String s = it.next();
				System.out.printf("%s : %s\n\n", s, master.get(s));
			}
			System.out.println();

			System.out.println("1.전체삭제 / 2.부분삭제");
			System.out.print(">> 입력 : ");
			String b = br.readLine();

			if (b.equals("1"))  //1번 누를시 전체삭제
			{
				System.out.print(">> 정말 전체삭제 하시겠습니까?(Y/N) : ");
				con=br.readLine();

				if (con.equals("y") || con.equals("Y"))
				{
					ht.clear();
					System.out.println("▶ 전체삭제되었습니다.\n\n");
				}
				else 
					return;
			}
			else if(b.equals("2"))  //2번 누를시 부분삭제
			{
				System.out.print(">> 삭제할 번호 입력 : ");
				names = br.readLine();

				if (!master.containsKey(names))
					System.out.println("\n▶ 번호가 존재하지 않습니다.\n\n");
				else
				{
					System.out.print(">> 정말 삭제 하시겠습니까?(Y/N) : ");
					con=br.readLine();
					
					if (con.equals("y") || con.equals("Y"))
					{
						master.remove(names);
						System.out.println("▶ 삭제되었습니다.\n\n");
					}
					else
						return;
				}
			}
		}
	}


	public void  eventStore()throws IOException   //점포 이벤트 관리 메소드
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		Display dis = new Display();
		Gagae gg = new Gagae();

		System.out.println("\n1. 이벤트 수정");
		System.out.println("2. 이벤트 추가");
		System.out.println("3. 이벤트 삭제");
		System.out.print(">> 입력 : ");
		int a = Integer.parseInt(br.readLine());

		if (a==1)  //가게를 찾아 이벤트 수정하는 과정
		{
			System.out.println("\t\t  [점포 이벤트 수정 메뉴]\n");
			System.out.println("\t\t ==▶현재 입력된 점포 이벤트◀==\n");

			Iterator<String> it = ht.keySet().iterator();
			while (it.hasNext())
			{
				String s = it.next();
				System.out.printf("%s : %s\n\n", s, ht.get(s));
			}
			System.out.println();
			
			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 수정할 점포 유형 선택 : ");
			gg.kind = Integer.parseInt(br.readLine());
			System.out.println();

			System.out.print(">> 수정할 점포명 입력 : ");
			names = br.readLine();

			if (!ht.containsKey(names))
				System.out.println("\n▶ 점포가 존재하지 않습니다.\n\n");
			else if (ht.containsKey(names))
			{

				//자신의 가게만 접근 할 수 있도록 마스터키 입력하도록 함 - 틀릴시 접근제한
				System.out.print(">> 마스터키를 입력하세요 : ");      
				String mkey = br.readLine();	
				System.out.println();
				
				if (gg.kind == dis.DISPLAY_KOR)
				{
					if (mas.containsKey(mkey) && mas.get(mkey).equals(ghan.get(names).getMaster()))
					{
						System.out.print(">> 수정할 이벤트 내용 : ");
						evs = br.readLine();

						ht.put(names,evs);
						System.out.println("▶ 정상적으로 수정되었습니다.\n\n");  //접근허용
					}
					else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(ghan.get(names).getMaster()))
						System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");	//접근제한				
				}
				else if (gg.kind == dis.DISPLAY_CHI)
				{
					if (mas.containsKey(mkey) && mas.get(mkey).equals(gchi.get(names).getMaster()))
					{
						System.out.print(">> 수정할 이벤트 내용 : "); //접근허용
						evs = br.readLine();

						ht.put(names,evs);
						System.out.println("▶ 정상적으로 수정되었습니다.\n\n");
					}
					else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gchi.get(names).getMaster()))
						System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");		//접근제한	
				}
				else if (gg.kind == dis.DISPLAY_JAP)
				{
					if (mas.containsKey(mkey) && mas.get(mkey).equals(gjap.get(names).getMaster()))
					{
						System.out.print(">> 수정할 이벤트 내용 : "); //접근허용
						evs = br.readLine();

						ht.put(names,evs);
						System.out.println("▶ 정상적으로 수정되었습니다.\n\n"); 
					}
					else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gjap.get(names).getMaster()))
						System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");	//접근제한		
				}
				else if (gg.kind == dis.DISPLAY_BUN)
				{
					if (mas.containsKey(mkey) && mas.get(mkey).equals(gbun.get(names).getMaster()))
					{
						System.out.print(">> 수정할 이벤트 내용 : "); //접근허용
						evs = br.readLine();

						ht.put(names,evs);
						System.out.println("▶ 정상적으로 수정되었습니다.\n\n");
					}
					else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gbun.get(names).getMaster()))
						System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");	//접근제한			
				}
			}
		
				
		}
		else if (a==2) //가게를 찾아 이벤트 추가하는 과정
		{
			System.out.println("\t\t  [점포 이벤트 추가 메뉴]\n");
			System.out.println("\t\t ==▶현재 입력된 점포 이벤트◀==\n");

			Iterator<String> it = ht.keySet().iterator();
			while (it.hasNext())
			{
				String s = it.next();
				System.out.printf("%s : %s\n\n", s, ht.get(s));
			}
			System.out.println();

			System.out.println("1. 한식류	2. 중식류	3. 일식류	4.분식류");
			System.out.print(">> 추가할 점포 유형 선택 : ");
			gg.kind = Integer.parseInt(br.readLine());
			System.out.println();

			System.out.print(">> 추가할 점포명 입력 : ");
			names = br.readLine();
			
			//마스터키를 입력받고 입력오류시 접근제한.
			System.out.print(">> 마스터키를 입력하세요 : ");
			String mkey = br.readLine();	
			System.out.println();
			
			if (gg.kind == dis.DISPLAY_KOR)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(ghan.get(names).getMaster()))
				{
					System.out.print(">> 추가할 이벤트 내용 : ");  //접근허용
					evs = br.readLine();

					ht.put(names,evs);
					System.out.println("▶ 정상적으로 추가되었습니다.\n\n");  //접근제한
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(ghan.get(names).getMaster()))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");						
			}
			else if (gg.kind == dis.DISPLAY_CHI)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(gchi.get(names).getMaster()))
				{
					System.out.print(">> 추가할 이벤트 내용 : "); //접근허용
					evs = br.readLine();

					ht.put(names,evs);
					System.out.println("▶ 정상적으로 추가되었습니다.\n\n");
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gchi.get(names).getMaster()))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");	//접근제한		
			}
			else if (gg.kind == dis.DISPLAY_JAP)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(gjap.get(names).getMaster()))
				{
					System.out.print(">> 추가할 이벤트 내용 : ");   //접근허용
					evs = br.readLine();

					ht.put(names,evs);
					System.out.println("▶ 정상적으로 추가되었습니다.\n\n");
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gjap.get(names).getMaster()))
						System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");	//접근제한		
				}
			else if (gg.kind == dis.DISPLAY_BUN)
			{
				if (mas.containsKey(mkey) && mas.get(mkey).equals(gbun.get(names).getMaster()))
				{
					System.out.print(">> 추가할 이벤트 내용 : ");  //접근허용
					evs = br.readLine();

					ht.put(names,evs);
					System.out.println("▶ 정상적으로 추가되었습니다.\n\n");
				}
				else if (!mas.containsKey(mkey) || !mas.get(mkey).equals(gbun.get(names).getMaster()))
					System.out.println("▶ 해당 점포에 접근 권한이 없습니다.\n");	//접근제한		
			}
			
		
		}
		else if (a==3)   //점포 이벤트 삭제하는 과정
		{
			System.out.println("\t\t  [점포 이벤트 삭제 메뉴]\n");
			System.out.println("\t\t ==▶현재 입력된 점포 이벤트◀==\n");

			Iterator<String> it = ht.keySet().iterator();
			while (it.hasNext())
			{
				String s = it.next();
				System.out.printf("%s : %s\n\n", s, ht.get(s));
			}
			System.out.println();

			System.out.println("1.전체삭제 / 2.부분삭제");
			System.out.print(">> 입력 : ");
			String b = br.readLine();

			if (b.equals("1"))  //점포이벤트 전체삭제
			{
				System.out.println(">> 정말 전체삭제 하시겠습니까?(Y/N)");
				con=br.readLine();

				if (con.equals("y") || con.equals("Y"))
				{
					ht.clear();
					System.out.println("▶ 전체삭제되었습니다.\n\n");
				}
				else return;
			}
			else if(b.equals("2")) //점포이벤트 부분삭제
			{
				System.out.print(">> 삭제할 점포명 입력 : ");
				names = br.readLine();

				if (!ht.containsKey(names))
					System.out.println("\n▶ 해당 키워드가 존재하지 않습니다.\n\n");
				else
				{
					System.out.print(">> 정말 삭제 하시겠습니까?(Y/N) : ");
					con=br.readLine();
					
					if (con.equals("y") || con.equals("Y"))
					{
						ht.remove(names);
						System.out.println("▶ 삭제되었습니다.\n\n");
					}
					else
						return;
				}
			}
		}
	}
}
