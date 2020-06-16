package com.project.ssangyong.kiosk;

public class Siljuck extends Main          
{
	//가게(점주)의 실적현황을 하기위해 구현한 클래스

	private String gname;   //가게이름
	private String mname;   //메뉴이름
	private int pri;		//메뉴 가격
	private int jori;		//조리시간
	private int maechul=0;	//매출량

	Siljuck(String gname, String mname, int pri)     
	{
	}

	Siljuck()
	{
	}

	// getter/setter
	public int getMaechul()                         //가게 매출 
	{
		return maechul;
	}
	public void setPlusMaechul(int maechul)         //매출 증가
	{
		this.maechul += maechul;
	}

	public void setMinusMaechul(int maechul)        //매출 감소
	{
		this.maechul -= maechul;
	}

	public void setMaechul(int maechul)
	{
		this.maechul = maechul;
	}

	public int getJori()               //조리시간
	{ 
		return jori;
	}
	public void setJori(int jori)
	{
		this.jori = jori;
	}

	
	public String getGname()           //가게이름
	{
		return gname;
	}
	public void setGname(String gname)
	{
		this.gname = gname;
	}
	
	public String getMname()           //메뉴이름
	{
		return mname;
	}
	public void setMname(String mname)
	{
		this.mname = mname;
	}	

	public int getPri()                //메뉴 가격
	{
		return pri;
	}
	public void setPri(int pri)
	{
		this.pri = pri;
	}	

	

}
