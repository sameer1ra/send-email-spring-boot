package com.ram.SendingEmail;

public class Session {
	
	private String date;
	private int available_capacity;
	private int min_age_limit;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAvailable_capacity() {
		return available_capacity;
	}
	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}
	public int getMin_age_limit() {
		return min_age_limit;
	}
	public void setMin_age_limit(int min_age_limit) {
		this.min_age_limit = min_age_limit;
	}
}
