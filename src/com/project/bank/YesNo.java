package com.project.bank;

public class YesNo extends Customer
{
	public void yesNo()
	{
		try
		{
			System.out.print("\n▷또 다른 업무를 도와드릴까요?(Y/N) : ");
			super.selectC = (char)System.in.read();
			System.in.skip(2);

			if (super.selectC != 'Y' && super.selectC != 'y')			// 앞서 선택이 y가 아닐경우
			{
				try
				{
				  System.out.println();
				  System.out.println("============================================================================");
				  Thread.sleep(100);
				  System.out.println("|           ====♡ 방문해주셔서 감사합니다 좋은하루 되세요 ♡====          |");
				  Thread.sleep(100);
				  System.out.println("|                                                                          |");
				  Thread.sleep(100);
				  System.out.println("|         #####      #####      #####     #######                          |");
				  Thread.sleep(100);
				  System.out.println("|        ##         ##   ##    ##   ##    ##    ##                         |");
				  Thread.sleep(100);
				  System.out.println("|       ##         ##     ##  ##     ##   ##     ##                        |");
				  Thread.sleep(100);
				  System.out.println("|       ##   ####  ##     ##  ##     ##   ##     ##                        |");
				  Thread.sleep(100);
				  System.out.println("|       ##     ##  ##     ##  ##     ##   ##     ##                        |");
				  Thread.sleep(100);
				  System.out.println("|        ##    ##   ##   ##    ##   ##    ##    ##                         |");
				  Thread.sleep(100);
				  System.out.println("|         ######     #####      #####     #######                          |");
				  Thread.sleep(100);
				  System.out.println("|                                                                          |");
				  Thread.sleep(100);
				  System.out.println("|                                                                          |");
				  Thread.sleep(100);
				  System.out.println("|                   #######     ##     ##    ########       **       **    |");
				  Thread.sleep(100);
				  System.out.println("|                   ##    ##     ##   ##     ##            *   **  **   *  |");
				  Thread.sleep(100);
				  System.out.println("|                   ##     #      ## ##      ##            *     **     *  |");
				  Thread.sleep(100);
				  System.out.println("|                   #######        ###       ########       *          *   |");
				  Thread.sleep(100);
				  System.out.println("|                   ##     #       ###       ##              *        *    |");
				  Thread.sleep(100);
				  System.out.println("|                   ##    ##       ###       ##                *    *      |");
				  Thread.sleep(100);
				  System.out.println("|                   #######        ###       ########            **        |");
				  Thread.sleep(100);
				  System.out.println("|                                                                          |");
				  Thread.sleep(100);
				  System.out.println("============================================================================");
			   }
			   catch (Exception e)
			   {
				  System.out.println(e.toString());
			   }
				return;													// yegum() 메서드 종료
			}
			else
			{
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		

	}// end yesNo()

}// end class YesNo 