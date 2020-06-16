package com.project.ssangyong.kiosk;
// 메뉴의 속성을 갖고있는 class

class MenusVO extends Main
{
	
	private String menuname;	// 메뉴 이름
	private String gagaename;	// 가게 이름 
	private int price;			// 가격
	private int time;			// 조리시간
	private int sell=0;			// 판매량

	MenusVO(String menuname, String gagaename, int price, int time)
	{
		this.menuname = menuname;
		this.gagaename = gagaename;
		this.price = price;
		this.time = time;
	}

	MenusVO(String menuname)
	{
		this.menuname = menuname;
	}

	MenusVO()
	{
		
	}
	
// getter/setter ------------------------------------------------------
	public String getMenuName()
	{
		return menuname;
	}
	public void setMenuName(String menuname)
	{
		this.menuname = menuname;
	}	

	public String getGagaeName()
	{
		return gagaename;
	}
	public void setGagaeName(String gagaename)
	{
		this.gagaename = gagaename;
	}	

	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}	


	public int getTime()
	{
		return time;
	}
	public void setTime(int time)
	{
		this.time = time;
	}


	public int getSell()
	{
		return sell;
	}
	public void setPlusSell(int sell)
	{
		this.sell += sell;
	}
	public void setMinusSell(int sell)
	{
		this.sell -= sell;
	}
//-----------------------------------------------------------


}// end class MenusVO