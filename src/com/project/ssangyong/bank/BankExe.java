package com.project.ssangyong.bank;

public class BankExe extends Customer
{
	public static void main(String[] args)
	{
		Customer cs = new Customer();
		cs.print();

		
		Account ac = new Account();
		ac.account();

		//wk.whatKind();
	}
}