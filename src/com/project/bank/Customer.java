package com.project.bank;

import java.util.Scanner;

public class Customer	// 사용자 메인 클래스 이자 신원확인 클래스
{
	
//	주요 고객정보 관련 변수 선언 및 메소드 정의  /////////////////////////////////////////////////////////////////////////////

	private static String name;				//-- 고객 이름 저장 문자열 
	private static String phone;			//-- 고객 핸드폰 저장 문자열
	private static String jumin;			//-- 고객 주민번호 저장 문자열
	private static String pass , pass1;		//-- 고객 비밀번호 저장 문자열
	private static String tongName;
	private static long tongjang = 0;
	private static long cash = 100000000;	//-- 고객 보유 금액 1억.
	static String select;					//-- 고객 선택 변수(String)
	static char selectC;					//-- 고객 선택 변수(char)
	private static boolean flag = true;
	
	

	public static final long getCash()			//-- getCash()
	{
		return cash;
	}// end getCash() 

	public static final void setCash(long cash)	//-- setCash()
	{
		Customer.cash = cash;
	}// end setCash()

	public static final String getPass()		//-- getPass()
	{
		return pass;
	}// end getPass() 

	public static final void setPass(String pass)//-- setPass()
	{
		Customer.pass += pass;
	}// end setPass()

	public static final String getJumin()		//-- getJumin()
	{
		return jumin;
	}// end getJumin() 

	public static final void setJumin(String jumin)
	{
		Customer.jumin = jumin;
	}// end setJumin()

	public static final String getPhone()		//-- getPhone()
	{
		return phone;
	}// end getPhone() 

	public static final void setPhone(String phone)//-- setPhone()
	{
		Customer.phone = phone;
	}// end setPhone()

	public static final long getTongjang()		//-- getTongjang()
	{
		return tongjang;
	}// end getTongjang() 

	public static final void setTongjang(long tongjang)//-- setTongjang()
	{
		Customer.tongjang = tongjang;
	}// end setTongjang()

	public static final String getTongname()		//-- getTongname()
	{
		return tongName;
	}// end getTongname()

	public static final void setTongname(String tongName)//-- setTongname()
	{
		Customer.tongName = tongName;
	}// end setTongname()

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void input() //이름 입력 메소드
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("\n==== 고객님의 정보를 작성 부탁드립니다.^^ =====");	// 회원가입을 고객정보로 바꿈
		System.out.print("▷이름을 입력해주세요 : ");
		name = sc.next();
		System.out.println();

	}// end name()
	
	public void phone() //전화번호 저장 메소드
	{
		Scanner sc = new Scanner (System.in);
		do
		{
			System.out.print("▷고객님의 핸드폰 번호를 입력해주세요.^^ (예시 : 010xxxxxxxx) : ");
			phone = sc.next();

			if (phone.length() !=11)
			{
				System.out.println("핸드폰 번호를 다시 입력해주세요.\n");
			}
		}
		while (phone.length() !=11); //11자리가 넘어갈 경우에 다시 입력
		

	}// end phone()


	public void pass()	//비밀번호 저장 메소드
	{
		Scanner sc = new Scanner(System.in);
	
		do
		{
			System.out.print("▷개설할 비밀번호를 입력해 주세요. (4자리): ");
			pass = sc.next();
			System.out.print("▷다시 한 번 비밀번호를 입력해 주세요. (4자리): ");
			pass1 = sc.next();

		}	
		while (pass.length() !=4); 

			if (pass.equals(pass1)==true)	//pass1과 pass가 true일경우 저장
			{
				System.out.println("비밀번호 저장 완료!");
			}
		do
		{
			if (pass.equals(pass1)==false) //pass1과 pass가 false일경우 다시 입력
			{
				System.out.print("▷비밀 번호가 틀렸습니다ㅠㅠ 다시 입력해 주세요. : ");
				pass1 = sc.next();						
			}
		}
		while (pass.equals(pass1)==false);

	}// end pass()


	public void jumin() //주민 번호 저장 메소드
	{
		Scanner sc = new Scanner (System.in);
		int[]arr = {2,3,4,5,6,7,0,8,9,2,3,4,5};


		while (flag)
		{
			do
			{
				System.out.print("▷고객님의 소중한 주민번호를 입력해주세요. (예시 xxxxxx-xxxxxxx ) : ");
				jumin = sc.next();

				if (jumin.length() !=14)
				{
					System.out.println("▷주민번호를 다시 입력해주시기 바랍니다.\n");
				}
			
			}
			while (jumin.length() !=14);
			

			// 곱셈 연산 후 누적 합
			int tot = 0 ;

			if(jumin.length() !=14)
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
				tot += arr[i] * Integer.parseInt(jumin.substring(i,(i+1)));
		
			}

			int su = 11 - tot % 11;
			//테스트
			//System.out.println(su);

			// 최종 결과 출력 이전에 추가 연산 필요~!!
			// -- su에 대한 연산 결과가 두 자리로 나올 경우
			// 주민번호 마지막 자리의 숫자와 비교할 수 없는 상황
			su = su %10;
			//-- 여기까지 수행하면 3 과 4를 모두 끝낸 상황이며
			// 최종 연산 결과는 변수su에 담겨있는 상황이 된다.

			// 최종 결과 출력
			
			if(su == Integer.parseInt(jumin.substring(13)))
			{
				System.out.println("정확한 주민번호입니다\n");
				flag = false;
			}
			else if (su != Integer.parseInt(jumin.substring(13)))
			{
				System.out.println("정확하지 않은 주민번호입니다.");
				flag = true;
			}
		}
			
		
		
			
		
		
		
		
			

	

	}// end jumin()
	
	public void print() //출력 메소드
	{
		input();
		jumin();
		phone();
		pass();
		
		System.out.println("\n=========회원정보==========");
		System.out.printf("이름 : %s\n",name);
		System.out.printf("핸드폰 번호 (계좌번호) : %s\n",phone);
		System.out.printf("주민번호: %s\n",jumin);
		System.out.println("===========================\n");
	}// end print()

	
}
