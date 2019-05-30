package com.example.FastPay.data.entity;

public class Money {
	
	String euro;
	String dollar;
	
	public Money(String euro, String dollar) {
		
		this.euro=euro;
		this.dollar=dollar;
		
	}
	
	public String getEuro() {
		return euro;
	}
	public void setEuro(String euro) {
		this.euro = euro;
	}
	public String getDollar() {
		return dollar;
	}
	public void setDollar(String dollar) {
		this.dollar = dollar;
	}
	
	

}
