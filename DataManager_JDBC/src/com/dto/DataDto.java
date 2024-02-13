package com.dto;

public class DataDto {
	private int m_code;
	private String m_str;
	private int m_int;
	private String m_date;//컬럼 형식은 date지만 문자열로 취급
	
	public int getM_code() {
		return m_code;
	}
	public void setM_code(int m_code) {
		this.m_code = m_code;
	}
	public String getM_str() {
		return m_str;
	}
	public void setM_str(String m_str) {
		this.m_str = m_str;
	}
	public int getM_int() {
		return m_int;
	}
	public void setM_int(int m_int) {
		this.m_int = m_int;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	
	@Override
	public String toString() {
		String str = "CODE: " + m_code + "\n"
				+ "STR: " + m_str + "\n"
				+ "INT: " + m_int + "\n"
				+ "DATE: " + m_date;
		return str;
	}
	
}




