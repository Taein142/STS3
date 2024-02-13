package com.controller;

import java.util.List;

import com.dto.DataDto;
import com.service.DataService;
import com.view.DataView;

public class DataController {
	DataView dv = new DataView();
	DataService ds = new DataService();
	
	//데이터 입력 제어용 메소드
	private void inputData() {
		DataDto data = new DataDto();//입력값을 담을 그릇
		dv.inputData(data);//그릇을 입력 메소드로 전달
		String msg = ds.insertData(data);//입력값 들어간 그릇 전달
		dv.printMsg(msg);
	}
	
	//데이터 전체 출력용 메소드
	private void outputData() {
		List<DataDto> dList = ds.getList();
		dv.outputList(dList);
	}
	
	//검색 결과 출력용 메소드
	private void searchData() {
		int code = dv.searchCode("검색코드: ");
		DataDto data = ds.getData(code);
		
		//검색 결과가 있을 때와 없을 때의 구분
		if(data != null) {
			dv.outputData(data);	
		}
		else {
			dv.printMsg("검색결과 없음.");
		}
	}
	
	//데이터 수정용 메소드
	private void updateData() {
		int code = dv.searchCode("수정코드: ");
		DataDto data = ds.getData(code);
		
		//검색한 코드가 있으면 수정 작업 진행, 없으면 메시지 출력
		if(data != null) {
			dv.outputData(data);//검색 결과 출력
			dv.updateInput(data);//수정 정보 입력
			
			//입력된 정보로 수정 처리
			String msg = ds.updateData(data);
			
			dv.printMsg(msg);//수정 처리 결과 메시지 출력
		}
		else {
			dv.printMsg("해당 데이터 없음.");
		}
		
	}
	
	//데이터 삭제용 메소드
	private void deleteData() {
		int code = dv.searchCode("삭제코드: ");
		DataDto data = ds.getData(code);
		
		//검색결과가 있어야 삭제가 가능.
		if(data != null) {
			dv.outputData(data);//삭제할 데이터 확인
			String msg = ds.deleteData(code);
			dv.printMsg(msg);
		}
		else {
			dv.printMsg("해당 데이터 없음.");
		}
	}
	
	//전체 제어 메소드
	public void controll() {
		int menu = -1;
		
		while(true) {
			menu = dv.showFirst();//타이틀과 메뉴 출력, 번호 입력
			
			if(menu == 0) {
				dv.printMsg("종료");
				return;
			}
			
			switch(menu) {
			case 1://데이터 입력
				inputData();
				break;
			case 2://데이터 출력
				outputData();
				break;
			case 3://데이터 검색
				searchData();
				break;
			case 4://데이터 수정
				updateData();
				break;
			case 5://데이터 삭제
				deleteData();
				break;
			default:
				dv.printMsg("입력 오류. 0~5 사이의 숫자를 입력!");
			}//switch end
		}//while end
	}//method end
}//class end






