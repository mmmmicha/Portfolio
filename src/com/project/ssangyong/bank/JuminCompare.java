package com.project.ssangyong.bank;

import java.util.Scanner;

public class JuminCompare extends Customer
{

	private static String temp;							//-- 주민번호 임시 저장 변수 선언
	
	

	public void juminCom()								//-- 주민번호 비교 메소드
	{

		// Scanner 인스턴스 생성
		Scanner sc = new Scanner (System.in);
		int arr[] = {2,3,4,5,6,7,0,8,9,2,3,4,5};		//-- 주민번호 계산을 위해 각 자릿수에 곱할 상수 저장
		int tot = 0 ;									//-- 곱셈 연산 후 누적 합 저장할 변수 선언 및 초기화
		
		do												//-- 주민번호 14자리가 아닐 경우 다시 입력받는 반복문
		{
			System.out.print("▷고객님의 소중한 주민번호를 입력해주세요.^^(예시 xxxxxx-xxxxxxx ) : ");
			temp = sc.next();

			if (temp.length() != 14)
			{
				System.out.println("▷주민번호를 다시 입력해주세요.\n");
			}
		
		}
		while (temp.length() !=14);
		

		

		if(temp.length() !=14)
		{
			System.out.println("입력오류");
			return; //-- 메소드 종료 → main() 메소드 종료 → 프로그램 종료
		}

		for (int i=0; i<13; i++)
		{
			if (i==6)
			{
				continue;			// i가 6번째는 무시하고 7번쨰로 넘어감 (149번쨰 line 무시하고 계속해라....)
			}
			tot += arr[i] * Integer.parseInt(temp.substring(i,(i+1)));	//-- 최종 계산 결과를 누적합에 대입
	
		}

		int su = 11 - tot % 11;
		
		// 최종 결과 출력 이전에 추가 연산 필요~!!
		// -- su에 대한 연산 결과가 두 자리로 나올 경우
		// 주민번호 마지막 자리의 숫자와 비교할 수 없는 상황
		su = su %10;
		//-- 여기까지 수행하면 3 과 4를 모두 끝낸 상황이며
		// 최종 연산 결과는 변수su에 담겨있는 상황이 된다.

		// 최종 결과 출력
		
		if(su == Integer.parseInt(temp.substring(13)) && temp.equals(super.getJumin()))
		{
			System.out.println("확인되었습니다\n");
			
			super.selectC = 'n';						//-- PassCompare 클래스 와 연결되어 이 경우 거래과정을 지속함

			// 테스트
			//System.out.println(super.selectC);
		}
		else
		{
			System.out.println("당사자의 신분증이 아닙니다.");
			super.selectC = 'y';						//-- PassCompare 클래스 와 연결되어 이 경우 거래과정을 중단하는 방향으로 진행

			// 테스트
			//System.out.println(super.selectC);
			
		}	
		

	}// end juminCom()

}// end class JuminCompare