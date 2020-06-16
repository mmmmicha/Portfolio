package com.project.ssangyong.kiosk;
// 각 자료구조 선언 및 초기화 -> 대부분의 class들이 상속하는 class
// main method 포함하는 class

import java.util.Hashtable;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.TreeMap;

public class Main
{
	//-- 자료구조 선언
	//	 모든 클래스들이 Main 클래스를 상속받아 공유하기 위해서 static 을 사용
	static TreeMap<String,String> mas;
	static TreeMap<String, GagaeVO> ghan;
	static TreeMap<String, GagaeVO> gchi;
	static TreeMap<String, GagaeVO> gjap;
	static TreeMap<String, GagaeVO> gbun;
	static TreeMap<String, GagaeVO> glMap;
	static Hashtable<String,String> ht;
	static TreeMap<String,String> master;
	static TreeSet<String> todayList;
	static TreeMap<Integer, Siljuck> today;
	static TreeSet<String> todayGagae;
	static TreeMap<Integer, Siljuck> basket;

	static TreeMap<Integer, MenusVO> menu;

	static TreeSet<String> all;

	static int n = 0;
	static int num = 0;
	static int number = 0; 
	final int EXIT = 99;
	

	public static void main(String[] args) throws Exception
	{

		ghan = new TreeMap<String, GagaeVO>();		// 한식 점포 데이터
		gchi = new TreeMap<String, GagaeVO>();		// 중식 점포 데이터
		gjap = new TreeMap<String, GagaeVO>();		// 일식 점포 데이터
		gbun = new TreeMap<String, GagaeVO>();		// 분식 점포 데이터

		glMap = new TreeMap<String, GagaeVO>();		// test 자료구조
		
		mas = new TreeMap<String,String>();			// 점주 정보 인스턴스 생성	(마스터키 발급)
		ht = new Hashtable<String,String>();		// 가게 이벤트 인스턴스 생성
		master = new TreeMap<String,String>();		// 관리자 이벤트 인스턴스 생성

		all = new TreeSet<String>();				// '식당기준' menu 리스트 인스턴스 생성 (MapSet 클래스에서 사용)
		todayList = new TreeSet<String>();			// 총실적 나타내기
		todayGagae = new TreeSet<String>();			// 인스턴스용 자료구조
		

		today = new TreeMap<Integer, Siljuck>();	// 관리자 실적 인스턴스생성(소원,은채)
		basket = new TreeMap<Integer, Siljuck>();	// 장바구니용 인스턴스 생성

		menu = new TreeMap<Integer,MenusVO>();		// 메뉴 인스턴스 생성

		Event1 ev1 = new Event1();					// 이벤트 인스턴스 생성

		ev1.eventStorem();							// 이벤트 초기설정(전체공지)
		ev1.eventMasterm();							// 이벤트 초기설정(점포 총 리스트)

		Display dis = new Display();				// Display 인스턴스 생성


// 각 메뉴 초기 설정 ---------------------------
		ChogiMenu chm = new ChogiMenu();				// 초기메뉴 인스턴스 생성
		chm.kor();										// 한식
		chm.chi();										// 중식
		chm.jap();										// 일식
		chm.bun();										// 분식
		chm.key();										// 마스터키
//-----------------------------------------------

		do
		{
			dis.mainDisplay();							// 시작화면
			dis.mainEvent();							// 이벤트공지화면 출력
			dis.mainSelect();							// 본격실행 코드							
					
		}
		while (true);
	}
}
