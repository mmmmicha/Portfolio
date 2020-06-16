package com.project.ssangyong.kiosk;
// 점포의 속성이 들어있는 class

import java.util.Hashtable;

public class GagaeVO extends Main
{
	private int kind;				// 음식 유형
	private String master;			// 점포 책임자	
	private String tel;				// 점포 전화번호
	private int input=0;			// 점포 총매출
	

	GagaeVO (int kind, String master, String tel)
	{
		this.kind = kind;
		this.master = master;
		this.tel = tel;
	}

	GagaeVO()
	{
		
	}


	// getter / setter -------------------------------------------
	public int getKind()
	{
		return kind;
	}
	public void setKind(int kind)
	{
		this.kind = kind;
	}


	public String getMaster()
	{
		return master;
	}
	public void setMaster(String master)
	{
		this.master = master;
	}


	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}


	public int getInput()
	{
		return input;
	}
	public void setInput(int input)
	{
		this.input += input;
	}
	//------------------------------------------------------------

}