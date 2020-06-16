package com.project.ssangyong.kiosk;
// 메뉴기준 선택시 해당 메뉴의 식당들 출력하는 class

import java.util.Iterator;
import java.util.Scanner;

public class MenuFind extends Main
{


	public int i=1;		//-- 누적용 변수 선언
	String sunteack;	//-- 선택용 변수 선언
	

	// 원하는 메뉴를 선택했을 때 그 메뉴를 가지고있는 식당을 찾는 메소드
	public void find(String st) throws Exception
	{
		// Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);

		// menu 자료구조 Iterator
		Iterator<Integer> it = menu.keySet().iterator();

		// Display 인스턴스 생성
		Display di = new Display();
		
		// 메뉴를 지니고 있는 식당을 출력
		while (it.hasNext())
		{
			Integer in = it.next();

			if (menu.get(in).getMenuName().equals(st))
				System.out.printf("%d. %s\n", i++, menu.get(in).getGagaeName());	
		}
		i=1;	// i 초기화

		// 뒤이어 원하는 식당으로 연결
		System.out.print(">> 원하는 식당을 입력하세요 : ");
		sunteack = sc.next();
		System.out.println();

		di.menuDisplay(sunteack);
		
		System.out.println();
	}// end find()

	// 해당 메뉴를 가지고 있는 점포의 갯수를 리턴해주는 메소드
	public int findInt(String st) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Iterator<Integer> it = menu.keySet().iterator();
		Display di = new Display();
		
		
		
		while (it.hasNext())
		{
			Integer in = it.next();

			if (menu.get(in).getMenuName().equals(st))
				i++;	
		}
		return i;
	}// end findInt()


}// class MenuFind