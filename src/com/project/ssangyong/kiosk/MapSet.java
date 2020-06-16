package com.project.ssangyong.kiosk;
// 메뉴기준, 식당기준 출력할 method 구현한 class

import java.util.Iterator;

public class MapSet extends Main
{
	public void mainList()	// '메뉴 기준' 리스트 출력 시에 사용할 메소드
	{
		Iterator<Integer> it = menu.keySet().iterator();
		while (it.hasNext())
		{
			
			Integer in = it.next();
			
			// [all] TreeSet 자료구조 : 중복되지 않게 메뉴들이 정렬됨.
			all.add(menu.get(in).getMenuName());
		}
	}// end mainList()
		
	
	// 정렬된 메뉴들 출력
	public void print()
	{
		Iterator<String> it = all.iterator();
		int i=1;

		while (it.hasNext())
		{
			System.out.printf("%d. %s\n", i++, it.next());
		}
	}// end print()



}// class MapSet