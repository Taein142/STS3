package com.view;

import java.util.List;

import com.dto.DataDto;

public class DataView {
	InOutClass ioc = new InOutClass();
	
	//타이틀 출력 및 메뉴 출력
	public int showFirst() {
		ioc.newLinePrint("");//첫줄 띄기.
		ioc.newLinePrint("<<DB 연동 데이터 관리 프로그램>>");
		ioc.newLinePrint("---------------------------");
		ioc.newLinePrint("메뉴>");
		ioc.newLinePrint("1. 데이터 입력");
		ioc.newLinePrint("2. 데이터 출력");
		ioc.newLinePrint("3. 데이터 검색");
		ioc.newLinePrint("4. 데이터 수정");
		ioc.newLinePrint("5. 데이터 삭제");
		ioc.newLinePrint("0. 종료");
		int m = ioc.inputNum("선택: ");
		
		return m;
	}
	
	//데이터 입력 메소드
	public void inputData(DataDto data) {
		String str = null;
		int num = -1;
		
		ioc.newLinePrint("<데이터 입력>");
		ioc.newLinePrint("----------------------------");
		str = ioc.inputStr("문자열: ");
		data.setM_str(str);//dto에 문자열 저장
		num = ioc.inputNum("정수: ");
		data.setM_int(num);//dto에 정수 저장
		str = ioc.inputStr("날짜(YYYY-MM-DD): ");
		data.setM_date(str);
	}
	
	//기능에 따라 입/출력을 위한 메소드..
	
	//단순 메시지 출력용 메소드
	public void printMsg(String msg) {
		ioc.newLinePrint(msg);
	}

	//전체 데이터 출력용 메소드
	public void outputList(List<DataDto> dList) {
		ioc.newLinePrint("<데이터 출력>");
		ioc.newLinePrint("----------------------------");
		for(DataDto d : dList) {
			ioc.newLinePrint(d.toString());
			ioc.newLinePrint("-------------------");
		}
	}
	
	//검색코드 입력받는 메소드
	public int searchCode(String str) {
		int code = 0;
		
		ioc.newLinePrint("<데이터 검색>");
		ioc.newLinePrint("----------------------------");
		code = ioc.inputNum(str);
		
		return code;
	}
	
	//검색 결과 데이터 출력용 메소드
	public void outputData(DataDto data) {
		ioc.newLinePrint("<검색 결과>");
		ioc.newLinePrint("----------------------------");
		ioc.newLinePrint(data.toString());
	}
	
	//수정 사항 입력용 메소드
	public void updateInput(DataDto data) {
		String str = null;
		int n = -1;
		
		ioc.newLinePrint("<수정 내용>");
		ioc.newLinePrint("(수정 내용 없을 경우 엔터키 입력.)");
		ioc.newLinePrint("----------------------------");
		str = ioc.inputStr("문자열: ");
		if(!str.equals("")) {//수정 내용이 입력되면..
			data.setM_str(str);
		}
		n = ioc.inputNum("정수: ");
		if(n != -999999) {//수정 내용이 입력되면..
			data.setM_int(n);
		}
		str = ioc.inputStr("날짜(YYYY-MM-DD): ");
		if(!str.equals("")) {//수정 내용이 입력되면..
			data.setM_date(str);
		}
	}
	
}//class end





