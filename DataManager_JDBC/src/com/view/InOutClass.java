package com.view;

import java.util.Scanner;

public class InOutClass {
	//입력을 위한 부품(이 클래스에서만 사용하도록 접근 제어)
	private Scanner scan = new Scanner(System.in);
	
	//정수 입력용 메소드
	public int inputNum(String str) {
		int n = -999999;
		oneLinePrint(str);
		String s = scan.nextLine();//숫자문자열 입력
		try {
			n = Integer.parseInt(s);//숫자문자열 -> 정수로 변환
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			n = -999999;
		}
		return n;
	}
	//문자열 입력용 메소드
	public String inputStr(String str) {
		oneLinePrint(str);
		String s = scan.nextLine();
		return s;
	}
	
	//한줄 출력용 메소드
	public void oneLinePrint(String str) {
		System.out.print(str);
	}
	//줄바꿈 출력용 메소드
	public void newLinePrint(String str) {
		System.out.println(str);
	}
}
