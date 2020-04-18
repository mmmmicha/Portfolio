package com.project.bank;

import java.util.Scanner;
//import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ChangGu extends Customer	// 창구 display 클래스
{

////////////////////////////////////////////////////////////////////////////////

	private static long bankcash;


	public static void ChanGu()		// 창구 생성자 → 은행돈을 초기화 함	
	{
		long bankcash = 3000000000L;
	}// end 생성자

	public static final long getBCash()
	{
		return bankcash;
	}// end getBCash()

	public static final void setBCash(long bankcash)
	{
		ChangGu.bankcash = bankcash;
	}// end setBCash()

	
////////////////////////////////////////////////////////////////////////////////
	
	public void changgu()
	{
		Scanner sc = new Scanner(System.in);
		WhatKind wk = new WhatKind();
		
	
		try
		{
			System.out.println("============================================================================");
			Thread.sleep(100);
			System.out.println("|              ====♡ 꼼마은행에 방문하신것을 환영합니다 ♡====            |");
			Thread.sleep(100);
			System.out.println("|                                                                          |");
			Thread.sleep(100);
			System.out.println("|                                                                          |");
			Thread.sleep(100);
			System.out.println("|           #######          ###         ##      ##      ##    ##          |");
			Thread.sleep(100);
			System.out.println("|           ##    ##        ## ##        ###     ##      ##   ##           |");
			Thread.sleep(100);
			System.out.println("|           ##     #      ##     ##      ## ##   ##      ##  ##            |");
			Thread.sleep(100);
			System.out.println("|           #######       #########      ##  ##  ##      ####              |");
			Thread.sleep(100);
			System.out.println("|           ##     #      ##     ##      ##    # ##      ##  ##            |");
			Thread.sleep(100);
			System.out.println("|           ##    ##      ##     ##      ##     ###      ##   ##           |");
			Thread.sleep(100);
			System.out.println("|           #######       ##     ##      ##      ##      ##    ##          |");
			Thread.sleep(100);
			System.out.println("|                                                                          |");
			Thread.sleep(100);
			System.out.println("|                          _______________________                         |");
			Thread.sleep(100);
			System.out.println("|                          |          |          |                         |");
			Thread.sleep(100);
			System.out.println("|                          |          |          |                         |");
			Thread.sleep(100);
			System.out.println("|                          |        ㅇ|ㅇ        |                         |");
			Thread.sleep(100);
			System.out.println("|                          |          |          |                         |");
			Thread.sleep(100);
			System.out.println("|                          |          |          |                         |");
			Thread.sleep(100);
			System.out.println("============================================================================");
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

		

		try
		{
			// 고객정보 입력
			// 타이머 설정
			Thread.sleep(1000);
			super.print();
			
			System.out.print("	====== 어서오세요. 고객님 ♡ ====== \n");
			System.out.print("▷은행 업무를 진행하시겠어요? (Y/N) :");
			super.selectC = (char)System.in.read();
			System.in.skip(2);	

			System.out.println();

			if (super.selectC !='y' && super.selectC != 'Y')
			{
				System.out.println("		======= 감사합니다. 안녕히 가세요.^^ ======");	
				return;
			}
			else
			{
				System.out.println("잠시만 기다려주세요. 방문 창구 곧 안내해드릴게요.^^\n");
			}
			Random rd = new Random();
			int[] inwon = new int[5];		
			
			
			for (int j=0;j<inwon.length ;j++ )
			{
				
				inwon[j]=rd.nextInt(5)+1; 

				System.out.print("대기인원에 따라 소요시간이 발생될 수 있는점 양해부탁드려요.^^*\n");
				
//////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (inwon[j]==1)
				{
				   System.out.println("현재 대기 인원 : 1명");
				   for (int i=0; i<1; i++)
				   {
					  System.out.println(1-i + "명 남았습니다....");
					  Thread.sleep(1500);
				   }
				   System.out.println();break;   
				   
				}
				else if (inwon[j]==2)
				{
				   System.out.println("현재 대기 인원 : 2명");
				   for (int i=0; i<2; i++)
				   {
					  System.out.println(2-i + "명 남았습니다....");
					  Thread.sleep(1500);
				   }
				   System.out.println();break;
				   
				}
				else if (inwon[j]==3)
				{
				   System.out.println("현재 대기 인원 : 3명");
				   for (int i=0; i<3; i++)
				   {
					  System.out.println(3-i + "명 남았습니다....");
					  Thread.sleep(1500);
				   }
				   System.out.println();break;
				}
				else if (inwon[j]==4)
				{
				   System.out.println("현재 대기 인원 : 4명");   
				   for (int i=0; i<4; i++)
				   {
					  System.out.println(4-i + "명 남았습니다....");
					  Thread.sleep(1500);
				   }
				   System.out.println();break;
				}
				else
				   System.out.println("현재 대기 인원 : 5명");
				   for (int i=0; i<5; i++)
				   {
					  System.out.println(5-i + "명 남았습니다....");
					  Thread.sleep(1500);
				   }
				   System.out.println();break;
			 
				
////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
			
			System.out.println("===================================");
			System.out.println(" 창구① | 창구② | 창구③ | 창구④ ");
			System.out.println("===================================");

			
			int[] num = new int[4];	

			for (int i=0;i<num.length;i++)
			{
				num[i]=rd.nextInt(4)+1;   
				// 랜덤 숫자 만들기
				if (num[i]==1)
				{		
					System.out.println("   ▲   \n");
					break;			
					
				}
				else if (num[i]==2)
				{
					System.out.println("            ▲   \n");
					break;			
				}
				else if (num[i]==3)
				{
					System.out.println("                     ▲   \n");
					break;			
				}
				else
				{
					System.out.println("                             ▲   \n");
					break;			
				}
				
		
		}
		
		wk.whatKind();

	}
	catch (Exception e)
	{
		System.out.println(e.toString());
	}
	}// end changgu()
}
